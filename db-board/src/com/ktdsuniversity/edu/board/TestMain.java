package com.ktdsuniversity.edu.board;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.vo.BoardVO;

public class TestMain {

	public static void main(String[] args) {
		// 게시글 작성(DB게시글 작성)
		BoardVO newArticle = new BoardVO();
		
		newArticle.setTitle("New Article");
		newArticle.setContent("New Article's Content");
		
		BoardDao boardDao = new BoardDao();
		// int insertCount = boardDao.createNewArticle(newArticle);
		// System.out.println(insertCount + "개의 게시글이 생성되었습니다");
		
		// boardDao.createNewArticle2(newArticle);
		
		// 보드ID BO-20260303-000020의 Content를 수정하고 LATEST_MODIFY_DATE의 시간도 수정한다
		BoardVO modifyArticle = new BoardVO();
		modifyArticle.setId("BO-20260303-000020");
		modifyArticle.setTitle("Update Article");
		modifyArticle.setContent("Update Content");

//		boardDao.modifyArticle(modifyArticle);
		
//		boardDao.deleteArticle("BO-20260303-000019");
		
		// 게시글 조회
		BoardVO article =  boardDao.readArticle("BO-20260303-000020");
		System.out.println(article.toString());
		
	}
}
