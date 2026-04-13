package com.ktdsuniversity.edu.replies.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.common.utils.ObjectUtils;
import com.ktdsuniversity.edu.common.utils.SessionUtils;
import com.ktdsuniversity.edu.exceptions.HelloSpringApiException;
import com.ktdsuniversity.edu.files.dao.FilesDao;
import com.ktdsuniversity.edu.files.helpers.MultipartFileHandler;
import com.ktdsuniversity.edu.files.vo.request.SearchFileGroupVO;
import com.ktdsuniversity.edu.replies.dao.RepliesDao;
import com.ktdsuniversity.edu.replies.vo.RepliesVO;
import com.ktdsuniversity.edu.replies.vo.reponse.RecommendResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.SearchResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.UpdateResultVO;
import com.ktdsuniversity.edu.replies.vo.request.CreateVO;
import com.ktdsuniversity.edu.replies.vo.request.UpdateVO;

@Service
public class RepliesServiceImpl implements RepliesService {
	private static final Logger logger = LoggerFactory.getLogger(RepliesServiceImpl.class);

	@Autowired
	private RepliesDao repliesdao;

	@Autowired
	private MultipartFileHandler multipartFileGandler; 
	@Autowired
	private FilesDao filesDao;

	@Transactional
	@Override
	public RepliesVO createNewReply(CreateVO createVO) {

		String fileGroupId = this.multipartFileGandler.upload(createVO.getAttachFile());
		createVO.setFileGroupId(fileGroupId);

		int insertCount = this.repliesdao.insertNewReoly(createVO);
		if (insertCount == 1) {
			RepliesVO insertResultVO = this.repliesdao.selectReplyByReplyId(createVO.getId());
			return insertResultVO;
		}
		return null;
	}

	@Override
	public SearchResultVO findRepliesByArticleId(String articleId) {
		SearchResultVO searchReslut = new SearchResultVO();
		int count = this.repliesdao.selectRepliesCpuntByReplyArticleId(articleId);
		searchReslut.setCount(count);
		if (count > 0) {
			List<RepliesVO> searchList = this.repliesdao.selectRepliesByArticleId(articleId);
			searchReslut.setResult(searchList);
		}
		return searchReslut;
	}

	@Transactional
	@Override
	public RecommendResultVO updateRecommendCount(String replyId) {

		RecommendResultVO result = new RecommendResultVO();
		int updateCount = this.repliesdao.updateRecommendCountByReplyId(replyId);

		if (updateCount == 1) {
			result = this.repliesdao.selectRecommendResultByReplyId(replyId);

			if (ObjectUtils.isNull(result)) {
				if (SessionUtils.isMineResource(result.getEmail())) {
					throw new HelloSpringApiException("권한이 부족합니다 ", HttpStatus.BAD_REQUEST.value(), "자추금지");
				}
			}

		} else {
			// TODO Exception 처리
			int a = 0;
		}

		return result;
	}

	@Override
	public boolean deleteReplyById(String replyId) {

		RepliesVO reply = this.repliesdao.selectReplyByReplyId(replyId);

		if (ObjectUtils.isNull(reply)) {
			if (SessionUtils.isMineResource(reply.getEmail())) {
				throw new HelloSpringApiException("권한이 부족합니다 ", HttpStatus.BAD_REQUEST.value(), "자추금지");
			}
		}

 
		int deleteCount = this.repliesdao.deleteReplyById(replyId);
		return deleteCount == 1;
	}

	@Transactional
	@Override
	public UpdateResultVO updateReply(UpdateVO updateVO) {
		logger.debug("asdasssss ----");
		RepliesVO reply = this.repliesdao.selectReplyByReplyId(updateVO.getReplyId());

		logger.debug("asd"+reply);
		if (ObjectUtils.isNull(reply)) {
			if (SessionUtils.isMineResource(reply.getEmail())) {
				throw new HelloSpringApiException("권한이 부족합니다 ", HttpStatus.BAD_REQUEST.value(), "자추금지");
			}
		}


		
		updateVO.setFileGroupId(reply.getFileGroupId());
		if (updateVO.getDelFileNum() != null && updateVO.getDelFileNum().size() > 0) {
			
			SearchFileGroupVO searchFileGroupVO = new SearchFileGroupVO();
			searchFileGroupVO.setDeletefileNum(updateVO.getDelFileNum());
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
		
		
		List<MultipartFile> attachFiles = updateVO.getNewAttachFile();

		String fileGroupId = updateVO.getFileGroupId();
		if (fileGroupId == null || fileGroupId.length() == 0) {
			fileGroupId = this.multipartFileGandler.upload(attachFiles);
			updateVO.setFileGroupId(fileGroupId);
		} else {
			// 기존의 첨부파일 삭제 <-- 이거아님
			// this.filesDao.deleteFilesById(updateVO.getId());

			this.multipartFileGandler.upload(attachFiles, updateVO.getFileGroupId());
		}

		int updateCount = this.repliesdao.updateReplyByReplyId(updateVO);
				UpdateResultVO result = new UpdateResultVO();
				result.setReplyId(updateVO.getReplyId());
				result.setUpdate(updateCount ==1);
		return result;
	}

}
