package com.ktdsuniversity.edu.replies.vo.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

public class CreateVO {
	private String id;
	@NotBlank(message = "댓글내용을 작성해주")
	private String reply;
	private String email;

	@NotBlank(message = "없는게시글")
	private String articleId;
	private String parentReplyId;
	
	private String fileGroupId;
	private List<MultipartFile> attachFile;
	
	

	public String getFileGroupId() {
		return this.fileGroupId;
	}

	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}

	public List<MultipartFile> getAttachFile() {
		return this.attachFile;
	}

	public void setAttachFile(List<MultipartFile> attachFile) {
		this.attachFile = attachFile;
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

}
