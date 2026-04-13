package com.ktdsuniversity.edu.replies.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.exceptions.HelloSpringApiException;
import com.ktdsuniversity.edu.members.vo.MemberVO;
import com.ktdsuniversity.edu.replies.service.RepliesService;
import com.ktdsuniversity.edu.replies.vo.RepliesVO;
import com.ktdsuniversity.edu.replies.vo.reponse.RecommendResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.SearchResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.UpdateResultVO;
import com.ktdsuniversity.edu.replies.vo.request.CreateVO;
import com.ktdsuniversity.edu.replies.vo.request.UpdateVO;

import jakarta.validation.Valid;

@Controller
public class RepliesController {
	private static final Logger logger = LoggerFactory.getLogger(RepliesController.class);

	@Autowired
	private RepliesService repliesService;

	@ResponseBody
	@GetMapping("/api/replies/{articleId}")
	public SearchResultVO getRepliesList(@PathVariable String articleId){
		SearchResultVO searchResult = this.repliesService.findRepliesByArticleId(articleId);
		
		return searchResult;
	}
	
	@ResponseBody
	@PostMapping("/api/replies-with-file")
	public RepliesVO doCreateNewReplyWithFileAction(@Valid CreateVO createVO, BindingResult bindingResult,
			@SessionAttribute("__LOGIN_DATA__") MemberVO loginMember) {

		if (bindingResult.hasErrors()) {
			// JSON의 유효성검사처리
			List<FieldError> errors = bindingResult.getFieldErrors();
			throw new HelloSpringApiException("Not enough Parameters", HttpStatus.BAD_REQUEST.value(), errors);
			// JSON 못보내겠으니 Exception 처리
		}
		createVO.setEmail(loginMember.getEmail());

		logger.debug("reply: {} ", createVO.getReply());
		logger.debug("email: {} ", createVO.getEmail());
		logger.debug("articleId: {} ", createVO.getArticleId());
		logger.debug("parentReplyId: {} ", createVO.getParentReplyId());
		logger.debug("fileGroupId TQ : {} ", createVO.getFileGroupId());

		RepliesVO creatResult = this.repliesService.createNewReply(createVO);

		return creatResult;
	}
	
	@ResponseBody
	@GetMapping("/api/replies/recommend/{replyId}")
	public RecommendResultVO doIncreseRecommendCountReuturn(@PathVariable String replyId, @SessionAttribute("__LOGIN_DATA__") MemberVO loginMember) {
		
		RecommendResultVO updateResult = this.repliesService.updateRecommendCount(replyId);
		 
		return updateResult; 
	}
	
	@GetMapping("/api/replies/delete/{replyId}")
	public String doDeleteRepliesAction(@PathVariable String replyId) {
		
		this.repliesService.deleteReplyById(replyId);
		return "redirection:/";
	}

	// AJAX Request/Response
	// Json Format @Request/@Response Body
	@ResponseBody
	@PostMapping("/api/replies")
	public RepliesVO doCreateNewReplyAction(@RequestBody @Valid CreateVO createVO, BindingResult bindingResult,
			@SessionAttribute("__LOGIN_DATA__") MemberVO loginMember) {

		if (bindingResult.hasErrors()) {
			// JSON의 유효성검사처리
			List<FieldError> errors = bindingResult.getFieldErrors();
			throw new HelloSpringApiException("Not enough Parameters", HttpStatus.BAD_REQUEST.value(), errors);
			// JSON 못보내겠으니 Exception 처리
		}
		createVO.setEmail(loginMember.getEmail());

		logger.debug("reply: {} ", createVO.getReply());
		logger.debug("email: {} ", createVO.getEmail());
		logger.debug("articleId: {} ", createVO.getArticleId());
		logger.debug("parentReplyId: {} ", createVO.getParentReplyId());

		RepliesVO creatResult = this.repliesService.createNewReply(createVO);

		return creatResult;
	}
	
	@ResponseBody
	@PostMapping("/api/replies/{replyId}")
	public UpdateResultVO doUpdateReplyByReplyId(@PathVariable String replyId, @Valid UpdateVO updateVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			throw new HelloSpringApiException("파라미터가 충분하지 않슴ㄷ", HttpStatus.BAD_REQUEST.value(), errors);
		}

		
		updateVO.setReplyId(replyId);
		UpdateResultVO updateResultVO = this.repliesService.updateReply(updateVO);
		return updateResultVO;
		
	}

}
