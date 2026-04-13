package com.ktdsuniversity.edu.members.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.members.service.MembersService;
import com.ktdsuniversity.edu.members.service.MembersServiceImpl;
import com.ktdsuniversity.edu.members.vo.MemberVO;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;
import com.ktdsuniversity.edu.members.vo.response.DuplicateResultVO;
import com.ktdsuniversity.edu.members.vo.response.SearchMemberResultVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private final MembersServiceImpl membersServiceImpl;
	@Autowired
	private MembersService membersService;

	MemberController(MembersServiceImpl membersServiceImpl) {
		this.membersServiceImpl = membersServiceImpl;
	}

	@ResponseBody
	@GetMapping("/regist/check/duplicate/{email}")
	public DuplicateResultVO doCheckDuplicateEmailAction(@PathVariable String email) {
		// 이메일이 이미 사용중인가 ?-> 에 대한 결과를 JSON으로다가전돌송 사용 true / 미사용 false
		MemberVO memberVO = this.membersService.selectMemeber(email);
		
		DuplicateResultVO result = new DuplicateResultVO();
		result.setEmail(email);
		result.setDuplicate(memberVO != null);
		
		return result;
	}
	
	@GetMapping("/regist")
	public String viewMemberView() {
		return "/members/memberadd";
	}

	@PostMapping("/regist")
	public String createMember(@Valid @ModelAttribute MemberVO memberVO, BindingResult bindingResult, Model model) {
 
		if(bindingResult.hasErrors()) {
			model.addAttribute("inputData", memberVO);
			return "members/memberadd";
		}
		
		this.membersService.createNewMember(memberVO);
		return "redirect:/mview";
	}

	// /member/view/userId 회원 정보 조회
	@GetMapping("/mview")
	public String viewMemebersPage(Model model) {
		SearchMemberResultVO memberResult = this.membersService.findAllMembers();

		int listCount = memberResult.getCount();
		model.addAttribute("Count", listCount);
		List<MemberVO> memberList = memberResult.getResult();
		model.addAttribute("memberList", memberList);

		return "/members/mlist";
	}

	// /member/update/userId 회원 정보 수정
	@GetMapping("/mview/{memberEmail}")
	public String viewMemeberDetailPage(Model model, @PathVariable String memberEmail) {

		MemberVO member = this.membersService.selectMemeber(memberEmail);
		model.addAttribute("name", member.getName());
		model.addAttribute("password", member.getPassword());
		model.addAttribute("email", member.getEmail());

		return "/members/view";
	}

	// /member/update/userId 회원 정보 수정(do)
	@GetMapping("/mupdate/{memberEmail}")
	public String viewUpdateMembersPage(Model model, @PathVariable String memberEmail) {
		MemberVO member = this.membersService.selectMemeber(memberEmail);
		model.addAttribute("name", member.getName());
		model.addAttribute("password", member.getPassword());
		model.addAttribute("email", member.getEmail());

		return "members/update";
//		return "redirect:/members/" + memberEmail;
	}

	@PostMapping("/mupdate/{memberEmail}")
	public String doUpdateMembersAction(@PathVariable String memberEmail, MemberVO memberVO) {

		boolean updateResult = this.membersService.updateMembersByMemberEmail(memberVO);

		logger.debug("member 수정 성공 ? {}", updateResult);
		
		return "redirect:/mview/" + memberVO.getEmail();
	}

	// /member/delete?id=userId 회원 정보 삭제
	@GetMapping("/mdelete/{memberEmail}")
	public String doDeleteMemberAction(@PathVariable String memberEmail) {
 
		this.membersService.deleteMember(memberEmail);
		return "redirect:/mview";
	}

	@GetMapping("/members")
	public String viewMembersListPage(Model model) {
		return "/members/list";

	}
	
	@GetMapping("/login")
	public String viewLoginPage() {
		 
		return "/members/login";
		}
	
	@PostMapping("/login")
	public String doLoginAction(@Valid @ModelAttribute LoginVO loginVO, BindingResult bindingResult, Model model,@RequestParam(required= false, defaultValue="/") String go ,HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("loginData",loginVO);
			return "members/login";
			
		}
		String userIp = request.getRemoteAddr();
		loginVO.setIp(userIp);
		
		MemberVO member = this.membersService.findMemberByEmailAndPassword(loginVO);
		
		// 서버의 세션을 삭제한다. (로그아웃 혹은 30분 후)
		request.getSession().invalidate();
		
		// request.getSession(); Http Requst header로 전달된 JSessionID 객체 변환
		// request.getSession(true); <- 안에 True 가 있음 -> 이전 세션 discard.  새로운 세션 생성
		
		HttpSession session = request.getSession(true);
		session.setAttribute("__LOGIN_DATA__", member);
		
		return "redirect:"+go;
	}
	
	@GetMapping("/logout")
	public String doLogoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/delete-me")
	public String doDeleteAction(HttpSession session, @SessionAttribute(name="__LOGIN_DATA__", required=false) MemberVO loginMember) {
		// 1. 로그인 세션에서 회원 이메일을 가져온다
		String loginEmail = loginMember.getEmail();
		
		// 2. Members Table에서 이메일을 이용해 회원의 정보를 삭제한다
		this.membersServiceImpl.deleteMember(loginEmail);
		
		// 3. 현재 로그인된 사용자를 로그아웃 시킨다
		session.invalidate();
		
		// 4. "members/deletesuccesss" 페이지를 보연준다
		// 내용 : 탈퇴가 완료되었습니다 다음에 다시 만나욤 
		return "members/deletesuccess";
	}
	
}
