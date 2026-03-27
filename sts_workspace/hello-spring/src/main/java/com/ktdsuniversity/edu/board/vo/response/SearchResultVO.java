package com.ktdsuniversity.edu.board.vo.response;

import java.util.List;

import com.ktdsuniversity.edu.board.vo.BoardVO;

/**
 * 게시글 검색 결과를담고있는 클라ㅣ스
 * 게시글목록 개수 덩덩
 */
public class SearchResultVO {
	
	private List<BoardVO> result;
	private int Count;
	
	
	public List<BoardVO> getResult() {
		return result;
	}
	public void setResult(List<BoardVO> result) {
		this.result = result;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}

}
