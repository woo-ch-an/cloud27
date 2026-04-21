package com.ktdsuniversity.edu.board.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.board.enums.ReadType;
import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.request.SearchListVO;
import com.ktdsuniversity.edu.board.vo.request.UpdateVO;
import com.ktdsuniversity.edu.board.vo.request.WriteVO;
import com.ktdsuniversity.edu.board.vo.response.SearchResultVO;
import com.ktdsuniversity.edu.common.utils.AuthUtils;
import com.ktdsuniversity.edu.exceptions.HelloSpringApiException;
import com.ktdsuniversity.edu.members.vo.MembersVO;

import jakarta.validation.Valid;

@Controller
public class BoardApiController {

	private static final Logger logger = LoggerFactory.getLogger(BoardApiController.class);

	/**
	 * 빈 컨테이너에 들어있는 객체 중 타입이 일치하는 객체를 할당 받는다.
	 */
	@Autowired
	private BoardService boardService;

	// http://192.168.211.11:8080/?pageNo=0&listSize=10&searchType=&searchKeyword
	@ResponseBody
	@GetMapping("/api/articles") // 게시글 전부 조회 하기 뭐 그런거
	public Map<String, Object> viewListPage(SearchListVO searchListVO) {
		SearchResultVO searchResult = this.boardService.findAllBoard(searchListVO);
		Map<String, Object> jsonResult = new HashMap<>();
		jsonResult.put("result", searchResult);
		jsonResult.put("pagination", searchListVO);

		return jsonResult;
	}

	// 게시글을 등록하는 EndPoint
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	@PostMapping("/api/articles")
	public Map<String, Boolean> doWriteAction(@Valid WriteVO writeVO,
			// @Valid의 결과를 받아오는 파라미터.
			// 반드시 @Valid 파라미터 이후에 작성!
			BindingResult bindingResult,
			// Spring Security의 인증 토큰.
			Authentication authentication) {
		// 사용자의 입력값을 검증 했을 때, 에러가 있다면
		if (bindingResult.hasErrors()) {
			throw new HelloSpringApiException("Error on Write ", HttpStatus.BAD_REQUEST.value(), bindingResult.getFieldErrors());
		}

		MembersVO loginUser = AuthUtils.getPrincipal();
		// 로그인 데이터(__LOGIN_DATA__)에서 로그인 한 사용자의 이메일을 가져온다.
		writeVO.setEmail(loginUser.getEmail());
 
		// create, update, delete => 성공/실패 여부 반환.
		boolean createResult = this.boardService.createNewBoard(writeVO);
 
		return Map.of("result", createResult);
	}

	// 게시글 내용 조회. 
	@ResponseBody
	@GetMapping("/api/articles/{articleId}")
	public BoardVO viewDetailPage(@PathVariable String articleId) {

		// articleId로 데이터베이스에서 게시글을 조회한다.
		// 조회할 때 조회수가 하나 증가해야 한다.
		BoardVO findResult = this.boardService.findBoardByArticleId(articleId, ReadType.VIEW);
 
		return findResult;
	}

	/**
	 * 작성자 본인이나 관리자일떄만 삭제하고 뭐그런거다른사람오면 뭐 .. 안됨 뭐 그런 무...던지고 받고 뭐 그럼
	 * 
	 * @param id
	 * @return
	 */
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	@DeleteMapping("/api/articles/{id}")
	public Map<String, Boolean> doDeleteAction(@PathVariable String id) {
		boolean deleteResult = this.boardService.deleteBoardByArticleId(id);
		logger.debug("삭제 결과? {}", deleteResult);
		return Map.of("result", deleteResult);
		
	}

	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	@PutMapping("/api/articles/{articleId}")
	public Map<String, Boolean> doUpdateAction(@PathVariable String articleId, UpdateVO updateVO, Authentication authentication) {

		updateVO.setId(articleId);

		MembersVO loginUser = (MembersVO) authentication.getPrincipal();
		updateVO.setEmail(loginUser.getEmail());

		boolean updateResult = this.boardService.updateBoardByArticleId(updateVO);

		return Map.of("result", updateResult);
	}

	@PreAuthorize("hasRole('RL-20260414-000001')")
	@ResponseBody
	@DeleteMapping("/api/articles")
	public Map<String, Boolean> doDeleteAllAction() {
		boolean deleteResult = this.boardService.deleteAllBoard();
		return Map.of("result", deleteResult);
	}

}