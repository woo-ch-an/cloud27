package com.ktdsuniversity.edu.files.vo.request;

import java.util.List;

public class SearchFileGroupVO {
	private String fileGroupId;
	private List<Integer> deletefileNum;
	public String getFileGroupId() {
		return this.fileGroupId;
	}
	public void setFileGroupId(String fileGroupId) {
		this.fileGroupId = fileGroupId;
	}
	public List<Integer> getDeletefileNum() {
		return this.deletefileNum;
	}
	public void setDeletefileNum(List<Integer> deletefileNum) {
		this.deletefileNum = deletefileNum;
	}
	
	
}
