package com.ktdsuniversity.edu.replies.vo;

import java.util.List;

import com.ktdsuniversity.edu.files.vo.FilesVO;
import com.ktdsuniversity.edu.members.vo.MemberVO;

public class RepliesVO {
	private String id;
	private String reply;
	private int recommendCnt;
	private String crtDt;
	private String mdfyDt;
	private String email;
	private String articleId;
	private String parentReplyId;
	private String fileGroupId;
	private MemberVO memberVO; 
	private List<FilesVO> filesVO;
	
	private int level;

	public List<FilesVO> getFilesVO() {
		return this.filesVO;
	}

	public void setFilesVO(List<FilesVO> filesVO) {
		this.filesVO = filesVO;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public MemberVO getMemberVO() {
		return this.memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getRecommendCnt() {
		return this.recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArticleId() {
		return this.articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getParentReplyId() {
		return this.parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public String getFileGroupId() {
		return this.fileGroupId;
	}

	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
}
