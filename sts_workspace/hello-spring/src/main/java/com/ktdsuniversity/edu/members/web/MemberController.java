package com.ktdsuniversity.edu.members.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.members.service.MembersService;
import com.ktdsuniversity.edu.members.vo.MemberVO;
import com.ktdsuniversity.edu.members.vo.response.SearchMemberResultVO;

@Controller
public class MemberController {
	@Autowired
	private MembersService membersService;

	@GetMapping("/regist")
	public String viewMemberView() {
		return "/members/memberadd";
	}

	@PostMapping("/regist")
	public String createMember(MemberVO memberVo) {

		boolean createResult = this.membersService.createNewMember(memberVo);
		System.out.println(createResult + "그거용그거디버");

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
	@GetMapping("/mview/{memberName}")
	public String viewMemeberDetailPage(Model model, @PathVariable String memberName) {

		MemberVO member = this.membersService.selectMemeber(memberName);
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

		System.out.println("member VO" + memberVO);
		boolean updateResult = this.membersService.updateMembersByMemberEmail(memberVO);

		System.out.println("member 수정 성공 ? " + updateResult);

		return "redirect:/mview/" + memberVO.getEmail();
	}

	// /member/delete?id=userId 회원 정보 삭제
	@GetMapping("/mdelete/{memberEmail}")
	public String doDeleteMemberAction(@PathVariable String memberEmail) {

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		this.membersService.deleteMember(memberEmail);
		return "redirect:/mview";
	}

	@GetMapping("/members")
	public String viewMembersListPage(Model model) {
		return "/member/list";

	}
}
