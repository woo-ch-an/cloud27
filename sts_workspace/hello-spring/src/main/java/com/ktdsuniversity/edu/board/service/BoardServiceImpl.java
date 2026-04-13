package com.ktdsuniversity.edu.board.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.board.dao.BoardDao;
import com.ktdsuniversity.edu.board.enums.ReadType;
import com.ktdsuniversity.edu.board.vo.BoardVO;
import com.ktdsuniversity.edu.board.vo.request.SearchListVO;
import com.ktdsuniversity.edu.board.vo.request.UpdateVO;
import com.ktdsuniversity.edu.board.vo.request.WriteVO;
import com.ktdsuniversity.edu.board.vo.response.SearchResultVO;
import com.ktdsuniversity.edu.exceptions.HelloSpringException;
import com.ktdsuniversity.edu.files.dao.FilesDao;
import com.ktdsuniversity.edu.files.helpers.MultipartFileHandler;
import com.ktdsuniversity.edu.files.vo.request.SearchFileGroupVO;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private MultipartFileHandler multipartFileHandler;

	@Autowired
	private FilesDao filesDao;

	@Override
	public SearchResultVO findAllBoard(SearchListVO searchListVO) {
		SearchResultVO result = new SearchResultVO();

		// 게시글개수 조회
		int count = this.boardDao.selectBoardCount(searchListVO);
		result.setCount(count);

		searchListVO.computePagination(count);
		
		if (count == 0) {
			return result;
		}
		// 게시글 목록조회

		List<BoardVO> list = this.boardDao.selectBoardList(searchListVO);

		result.setResult(list);

		return result;
	}

	@Transactional
	@Override
	public boolean createNewBoard(WriteVO writeVO) {

		// 첨부파일 업 로 드
		List<MultipartFile> attachFiles = writeVO.getAttachFile();
		String fileGroupId = this.multipartFileHandler.upload(attachFiles);
		writeVO.setFileGroupId(fileGroupId);

		// dao-> insert 요청

		int insertCount = this.boardDao.insertNewBoard(writeVO);

		logger.debug("생성된 게시글의 개 {}", insertCount);

		return insertCount == 1;
	}

	@Override
	public BoardVO findBoardByArticleId(String articleId, ReadType readType) {

		if (readType == ReadType.VIEW) {
			int updateCount = this.boardDao.updateViewCntIncreaseById(articleId);
			logger.debug("\"조회수가 증가된 게시글의 수 {}", updateCount);
			if (updateCount == 0) {
				// 존재하지 않는 게시글
				throw new HelloSpringException("errors/404", "존재하지 않는 게시글입니다 ");
			}
		}

		BoardVO boardVariableObject = this.boardDao.selectBoardById(articleId);

		return boardVariableObject;
	}
	
	@Transactional
	@Override
	public boolean updateBoardByArticleId(UpdateVO updateVO) {

		if (updateVO.getDeleteFileNum() != null && updateVO.getDeleteFileNum().size() > 0) {

			SearchFileGroupVO searchFileGroupVO = new SearchFileGroupVO();
			searchFileGroupVO.setDeletefileNum(updateVO.getDeleteFileNum());
			searchFileGroupVO.setFileGroupId(updateVO.getFileGroupId());
			// 선택 파일 삭제 필요한거 -> 파일경로 -> 파일제거 + DB 제거
			List<String> deleteTargets = this.filesDao.selectFilePathByFileGroupIdAndFileNums(searchFileGroupVO);
			// 선택한거 경로가서 지우기
			for (String target : deleteTargets) {
				new File(target).delete();
			}
			// 선택한거 DB가서 지우기
			int deleteCount = this.filesDao.deleteFilesByFileGroupIdAndFileNums(searchFileGroupVO);
			logger.debug("삭제한 파일 데이터 수 {}", deleteCount);

		}
		// 첨부파일 업 로 드
		List<MultipartFile> attachFiles = updateVO.getAttachFile();

		String fileGroupId = updateVO.getFileGroupId();
		if (fileGroupId == null || fileGroupId.length() == 0) {
			fileGroupId = this.multipartFileHandler.upload(attachFiles);
			updateVO.setFileGroupId(fileGroupId);
		} else {
			// 기존의 첨부파일 삭제 <-- 이거아님
			// this.filesDao.deleteFilesById(updateVO.getId());

			this.multipartFileHandler.upload(attachFiles, updateVO.getFileGroupId());
		}

		int updateCount = this.boardDao.updateBoardById(updateVO);

		return updateCount == 1;
	}

	@Transactional
	public boolean deleteBoardByArticleId(String id) {
		// 게시글 지울 때 안에 있는 첨부파일도 같이 지우깅
		// 1. 삭제 하려는 게시글에 첨부된 파일을 가져온다
		List<String> filePaths = this.filesDao.selectFileByFileGroupId(id);
		// 2. 파일 목록이 존재하면 모든 파일 제거
		if (filePaths != null && filePaths.size() > 0) {
			for (String path : filePaths)
				new File(path).delete();
		}

		// 3. 파일 목록 제거하고 fILES 테이블에서 파일 정보 모두 삭제

		int deleteCount = this.filesDao.deleteFilesByFileGroupId(id);

		return deleteCount == 1;
	}
}
