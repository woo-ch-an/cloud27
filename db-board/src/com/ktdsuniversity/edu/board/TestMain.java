package com.ktdsuniversity.edu.board;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.service.BoardService;
import com.ktdsuniversity.edu.board.service.ReplyService;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

public class TestMain {
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
				
		// 게시글 작성(DB게시글 작성)
		BoardVO newArticle = new BoardVO();

		newArticle.setTitle("New Article");
		newArticle.setContent("New Article's Content");

		DataAccessHelper dah = new DataAccessHelper("localhost", 1521, "XE","BOARD" ,"BOARD");
		BoardService boardService = new BoardService(dah);
		// int insertCount = boardService.createNewArticle(newArticle);
		// System.out.println(insertCount + "개의 게시글이 생성되었습니다");

		// boardDao.createNewArticle2(newArticle);

		// 보드ID BO-20260303-000020의 Content를 수정하고 LATEST_MODIFY_DATE의 시간도 수정한다
		BoardVO modifyArticle = new BoardVO();
		modifyArticle.setId("BO-20260303-000020");
		modifyArticle.setTitle("Update Article");
		modifyArticle.setContent("Update Content");

//		boardService.modifyArticle(modifyArticle);

//		boardService.deleteArticle("BO-20260303-000019");

		// 게시글 조회
//		BoardVO article =  boardService.readArticle("BO-20260303-000020");
//		System.out.println(article.toString());

		System.out.println(boardService.readAllArticle());
		
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 댓글 시작 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		ReplyService res = new ReplyService(dah);
		ReplyVO rpvo = new ReplyVO();
		List<ReplyVO> replyList = new ArrayList<>();
	
		// 댓글 등록
		// 보드id, 내용 작성 
		rpvo.setBoardId("BO-20260303-000003");
		rpvo.setTopId(null);
		rpvo.setContent("ReplyContetn ~~ ");
		
		res.InsertNewReply(rpvo);
		rpvo.setContent("Edited Content !:~ ");
		rpvo.setId("RP-20260304-000006");
		
		res.EditReply(rpvo);
		res.DeleteReply(rpvo);
		
		System.out.println(res.SelectReplyOne("RP-20260304-000002"));
		replyList = res.SelectReplyAllHieracny("BO-20260303-000003");
		
		replyList = res.SelectReplyOneHieracny("RP-20260304-000002");

		for(int i=0; i<replyList.size(); i++) {
			System.out.println(replyList.get(i));
		}
		long end = System.currentTimeMillis();
		
		dah.close();
		System.out.println(end - now);
		System.out.println("🤮🤮🤮🤮🤮🤮");
	}
}
