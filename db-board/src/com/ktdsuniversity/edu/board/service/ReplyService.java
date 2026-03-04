package com.ktdsuniversity.edu.board.service;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.ReplyDao;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

public class ReplyService {

	private DataAccessHelper dah;
	private ReplyDao replyDao;

	public ReplyService(DataAccessHelper dah) {
		this.dah = dah;
		this.replyDao = new ReplyDao(this.dah);
	}

	// List<ReplyVO> 댓글 목록 조회(게시글 아이디)
	// 게시글에 등록된 모든 댓글 조회 (대댓글 포함) - 계층 조회
	public List<ReplyVO> SelectReplyAllHieracny(String boardId) {
		List<ReplyVO> returnValue = new ArrayList<>();

		this.replyDao.SelectReplyAllHieracny(boardId);

		return returnValue;
	}

	// ReplyVO 댓글 조회 (댓글 아이디)
	public ReplyVO SelectReplyOne(String replyID) {
		ReplyVO rpvo = new ReplyVO();

		rpvo = this.replyDao.SelectReplyOne(replyID);

		return rpvo;
	}

	// List<ReplyVO> 대댓글 조회 (댓글 아이디)
	// 댓글에 등록된 모든 대댓글 조회(대댓글 포함) - 계층 조회
	public List<ReplyVO> SelectReplyOneHieracny(String replyID) {
		List<ReplyVO> returnValue = new ArrayList<>();

		this.replyDao.SelectReplyOneHieracny(replyID);

		return returnValue;
	}

	// void 댓글 등록(ReplyVO)
	public void InsertNewReply(ReplyVO rp) {
		try {
			this.replyDao.InsertNewReply(rp);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.close();
		}

	}

	// void 댓글 수정(ReplyVO)
	public void EditReply(ReplyVO rp) {
		try {
			this.replyDao.EditReply(rp);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.close();
		}
	}

	// void 댓글 삭제(댓글 아이디)
	public void DeleteReply(ReplyVO rp) {
		try {
			this.replyDao.DeleteReply(rp);
			this.dah.commit();
		} catch (RuntimeException re) {
			this.dah.close();
		}
	}
}
