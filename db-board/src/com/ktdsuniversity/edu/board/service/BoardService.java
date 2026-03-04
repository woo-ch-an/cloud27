package com.ktdsuniversity.edu.board.service;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.vo.BoardVO;

public class BoardService {

	private DataAccessHelper dah;
	private BoardDao boardDao;

	public BoardService(DataAccessHelper dah) {
		this.dah = dah;
		this.boardDao = new BoardDao(this.dah);
	}

	public List<BoardVO> readAllArticle() {
		List<BoardVO> lbVO = new ArrayList<>();
		lbVO = this.boardDao.readAllArticle();

		return lbVO;
	}

	public BoardVO readArticle(String articleID) {
		BoardVO result = new BoardVO();

		try {
			this.boardDao.updateViewCount(articleID);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.rollback();
		}

		result = this.boardDao.readArticle(articleID);
		return result;
	}

	public void deleteArticle(String deleteID) {
		try {
			this.boardDao.deleteArticle(deleteID);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.rollback();
		}
	}

	public void modifyArticle(BoardVO modifyArticle) {
		try {
			this.boardDao.modifyArticle(modifyArticle);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.rollback();
		}
	}

	public void createNewArticle2(BoardVO newArticle) {
		try {
			this.boardDao.createNewArticle2(newArticle);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.rollback();
		}
	}

}
