package com.ktdsuniversity.edu.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.dao.query.BoardQuery;
import com.ktdsuniversity.edu.board.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.board.db.helper.SQLType;
import com.ktdsuniversity.edu.board.vo.BoardVO;

/**
 * Dao : Data Access Object java에서 DB로 데이터 생성 수정 삭제 조회 등을 위한 클래스
 */
public class BoardDao {

	public DataAccessHelper dah;

	public BoardDao(DataAccessHelper dah) {
		this.dah = dah;
	}

	public List<BoardVO> readAllArticle() {
		List<BoardVO> returnVO = new ArrayList<>();
		BoardVO vo = new BoardVO();

		// UPDATE -> 조회수 + 1
		// SELECT -> 가져오깅
		this.dah.preparedStatement(BoardQuery.MakeSelectAll(), null);
		this.dah.executeQuery(SQLType.SELECT, (rs) -> {
			vo.setId(rs.getString("ID"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setViewCount(rs.getInt("VIEW_COUNT"));
			vo.setWriteDate(rs.getString("WRITE_DATE"));
			vo.setLatestModifyDate(rs.getString("LATEST_MODIFY_DATE"));
			returnVO.add(vo);
		});

		return returnVO;
	}

	public void updateViewCount(String articleID) {
		// UPDATE -> 조회수 + 1
		this.dah.preparedStatement(BoardQuery.MakeUpdateViewCount(), (pstmt) -> {
			pstmt.setString(1, articleID);
		});
		this.dah.executeQuery(SQLType.UPDATE, null);
	}

	public BoardVO readArticle(String articleID) {
		BoardVO returnVO = new BoardVO();

		// SELECT -> 가져오깅
		this.dah.preparedStatement(BoardQuery.MakeSelectOne(), (pstmt) -> {
			pstmt.setString(1, articleID);
		});
		this.dah.executeQuery(SQLType.SELECT, (rs) -> {
			returnVO.setId(rs.getString("ID"));
			returnVO.setTitle(rs.getString("TITLE"));
			returnVO.setContent(rs.getString("CONTENT"));
			returnVO.setViewCount(rs.getInt("VIEW_COUNT"));
			returnVO.setWriteDate(rs.getString("WRITE_DATE"));
			returnVO.setLatestModifyDate(rs.getString("LATEST_MODIFY_DATE"));
		});

		return returnVO;
	}

	public void deleteArticle(String deleteID) {

		this.dah.preparedStatement(BoardQuery.MakeDeleteQuery(), (pstmt) -> {
			pstmt.setString(1, deleteID);
		});
		this.dah.executeQuery(SQLType.DELETE, null);

	}

	public void modifyArticle(BoardVO modifyArticle) {

		this.dah.preparedStatement(BoardQuery.MakeUpdateQuery(), (pstmt) -> {
			pstmt.setString(1, modifyArticle.getTitle());
			pstmt.setString(2, modifyArticle.getContent());
			pstmt.setString(3, modifyArticle.getId());
		});
		this.dah.executeQuery(SQLType.UPDATE, null);

	}

	public void createNewArticle2(BoardVO newArticle) {

		this.dah.preparedStatement(BoardQuery.MakeInsertQuery(), (pstmt) -> {
			pstmt.setString(1, newArticle.getTitle());
			pstmt.setString(2, newArticle.getContent());
		});
		this.dah.executeQuery(SQLType.INSERT, null);

	}

	public int createNewArticle(BoardVO newArticle) {

		// 1. ojdbc11.jar 파일이 프로젝트에 존재하는지 확인
		try {
			// oracle.jdbc.driver.OracleDriver 클래스를 불러온다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// oracle.jdbc.driver.OracleDriver 를 찾지 못했을 때 실행되는 블럭
			System.out.println("ORACLE DB에 접속하기 위한 라이브러리가 없습니다");
			return 0;
		}

		// 2. oracle db에 접속
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BOARD", "BOARD");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// 연결에 실패했을 때 실행되는 블럭
			System.out.println("데이터베이스 연결을 할 수 없습니다");
			System.out.println("사유 : " + e.getMessage());
			return 0;
		}

		// 3. INSERT QUERY 작성
		StringBuffer query = new StringBuffer();

		query.append(" INSERT INTO BOARD.BOARD ");
		query.append(" (ID                                                                          ");
		query.append(" , TITLE                                                                      ");
		query.append(" , CONTENT                                                                    ");
		query.append(" , WRITE_DATE)                                                                ");
		query.append(" VALUES                                                                       ");
		query.append(" ('BO-' || TO_CHAR(SYSDATE, 'YYYYMMDD-') || LPAD(SEQ_BOARD_PK.NEXTVAL, 6, '0')");
		query.append(" , ?                                                                         ");
		query.append(" , ?                                                                         ");
		query.append(" , SYSDATE)      ");

		// 3-1 데이터 할당하기
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(query.toString());
			pstmt.setString(1, newArticle.getTitle());
			pstmt.setString(2, newArticle.getContent());
		} catch (SQLException e) {
			// pstmt의 파이프가 만들어져있는 상태에서 예외 발생시
			// pstmt의 파이프를 먼저 닫는다
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
				}
			}
			// 연결된 Connection을 닫는다
			try {
				connection.close();
			} catch (SQLException e1) {
			}

			// SQL 실행 에러시 실행되는 블럭
			// 1. DB와 연결이 끊어져 있을 떄
			// 2. 작성된 쿼리의 내용이 잘못되었을 떄
			System.out.println("쿼리 내용에 문제가 있습니다");
			System.out.println("사유 : " + e.getMessage());
			return 0;
		}

		// 4. INSERT QUERY 실행
		int insertCount;
		try {
			insertCount = pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
			// INSERT 쿼리에 파라미터 할당이 잘못되었을 때
			// '?' 개수에 맞지 않게 할당했을 때
			// PK가 중복되었을 떄 등등
			// 컬럼의 타입과 INSERT 값이 다를 떄
			// 컬럼이 허용하는 최대 길이보다 값의 길이가 더 클 떄
			System.out.println("쿼리 실행에 문제가 있습니다");
			System.out.println("사유 : " + e.getMessage());
			return 0;
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}

			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return insertCount;
	}
}
