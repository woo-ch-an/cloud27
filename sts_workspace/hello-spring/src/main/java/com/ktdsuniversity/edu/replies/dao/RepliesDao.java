package com.ktdsuniversity.edu.replies.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ktdsuniversity.edu.replies.vo.RepliesVO;
import com.ktdsuniversity.edu.replies.vo.reponse.RecommendResultVO;
import com.ktdsuniversity.edu.replies.vo.request.CreateVO;
import com.ktdsuniversity.edu.replies.vo.request.UpdateVO;

@Mapper
public interface RepliesDao {

	int insertNewReoly(CreateVO createVO);

	RepliesVO selectReplyByReplyId(String id);

	int selectRepliesCpuntByReplyArticleId(String articleId);

	List<RepliesVO> selectRepliesByArticleId(String articleId);

	RecommendResultVO selectRecommendResultByReplyId(String replyId);

	int updateRecommendCountByReplyId(String replyId);

	int deleteReplyById(String replyId);

	int updateReplyByReplyId(UpdateVO updateVO);

}
