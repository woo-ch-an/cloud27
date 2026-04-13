package com.ktdsuniversity.edu.replies.service;

import com.ktdsuniversity.edu.replies.vo.RepliesVO;
import com.ktdsuniversity.edu.replies.vo.reponse.RecommendResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.SearchResultVO;
import com.ktdsuniversity.edu.replies.vo.reponse.UpdateResultVO;
import com.ktdsuniversity.edu.replies.vo.request.CreateVO;
import com.ktdsuniversity.edu.replies.vo.request.UpdateVO;

import jakarta.validation.Valid;

public interface RepliesService {

	RepliesVO createNewReply(CreateVO createVO);

	SearchResultVO findRepliesByArticleId(String articleId);

	RecommendResultVO updateRecommendCount(String replyId);

	boolean deleteReplyById(String replyId);

	UpdateResultVO updateReply(UpdateVO updateVO);

}
