package com.ktdsuniversity.edu.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.query.ReplyQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.ReplyVO;

public class ReplyDao {

	public DataAccessHelper dah;

	public ReplyDao(DataAccessHelper dah) {
		this.dah = dah;
	}

	// List<ReplyVO> 댓글 목록 조회(게시글 아이디)
	// 게시글에 등록된 모든 댓글 조회 (대댓글 포함) - 계층 조회
	public List<ReplyVO> SelectReplyAllHieracny(String boardId) {
		List<ReplyVO> returnList = new ArrayList<>();
		ReplyVO returnVO = new ReplyVO();

		this.dah.preparedStatement(ReplyQuery.MakeSelectAllHieracnyQuery(), (pstmt) -> {
			pstmt.setString(1, boardId);
		});
		this.dah.executeQuery(SQLType.SELECT, (rs) -> {
			returnVO.setId(rs.getString("ID"));
			returnVO.setBoardId(rs.getString("BOARD_ID"));
			returnVO.setTopId(rs.getString("TOP_ID"));
			returnVO.setContent(rs.getString("CONTENT"));
			returnVO.setWriteDate(rs.getString("WRITE_DATE"));

			returnList.add(returnVO);
		});

		return returnList;
	}

	// ReplyVO 댓글 조회 (댓글 아이디)
	public ReplyVO SelectReplyOne(String replyID) {
		ReplyVO returnVO = new ReplyVO();

		this.dah.preparedStatement(ReplyQuery.MakeSelectQuery(), (pstmt) -> {
			pstmt.setString(1, replyID);
		});
		this.dah.executeQuery(SQLType.SELECT, (rs) -> {
			returnVO.setId(rs.getString("ID"));
			returnVO.setBoardId(rs.getString("BOARD_ID"));
			returnVO.setTopId(rs.getString("TOP_ID"));
			returnVO.setContent(rs.getString("CONTENT"));
			returnVO.setWriteDate(rs.getString("WRITE_DATE"));
		});
		return returnVO;
	}

	// List<ReplyVO> 대댓글 조회 (댓글 아이디)
	// 댓글에 등록된 모든 대댓글 조회(대댓글 포함) - 계층 조회
	public List<ReplyVO> SelectReplyOneHieracny(String replyID) {
		List<ReplyVO> returnList = new ArrayList<>();
		ReplyVO returnVO = new ReplyVO();

		this.dah.preparedStatement(ReplyQuery.MakeSelectOneHieracnyQuery(), (pstmt) -> {
			pstmt.setString(1, replyID);
		});
		this.dah.executeQuery(SQLType.SELECT, (rs) -> {
			returnVO.setId(rs.getString("ID"));
			returnVO.setBoardId(rs.getString("BOARD_ID"));
			returnVO.setTopId(rs.getString("TOP_ID"));
			returnVO.setContent(rs.getString("CONTENT"));
			returnVO.setWriteDate(rs.getString("WRITE_DATE"));

			returnList.add(returnVO);
		});
		return returnList;
	}

	// void 댓글 등록(ReplyVO)
	public void InsertNewReply(ReplyVO rp) {

		this.dah.preparedStatement(ReplyQuery.MakeInsertQuery(), (pstmt) -> {
			pstmt.setString(1, rp.getBoardId());
			pstmt.setString(2, rp.getTopId());
			pstmt.setString(3, rp.getContent());
		});
		this.dah.executeQuery(SQLType.INSERT, null);

	}

	// void 댓글 수정(ReplyVO)
	public void EditReply(ReplyVO rp) {

		this.dah.preparedStatement(ReplyQuery.MakeUpdateQuery(), (pstmt) -> {
			pstmt.setString(1, rp.getContent());
			pstmt.setString(2, rp.getId());
		});
		this.dah.executeQuery(SQLType.UPDATE, null);

	}

	// void 댓글 삭제(댓글 아이디)
	public void DeleteReply(ReplyVO rp) {

		this.dah.preparedStatement(ReplyQuery.MakeDeleteQuery(), (pstmt) -> {
			pstmt.setString(1, rp.getId());
		});
		this.dah.executeQuery(SQLType.DELETE, null);

	}

}
