package com.ktdsuniversity.edu.board.vo.request;

/**
 * 게시글검색, 게시글 페이지네이션 때 사용
 */

public class SearchListVO {

	// 목록을 보여준 페이지의 번호
	private int pageNo;

	// 하나에 페이지에 보여줄 게시글 개수
	private int listSize;

	// 페이지 생성 개수
	// Math.upzz(게시글 갯수 / listSize)
	private int pageCount;

	// 하나의 페이지 그룹에 보여줄 페이지 개수
	private int pageCountInGroup;

	// ceil ( 페이지 개수 / pageCountInGroup)
	private int pageGroupCount;

	// 현 페이지 그룹 번호
	private int groupNo;

	// 현 페이지 그룹의 시작번호
	private int groupStartPageNo;

	// 현 페이지 그룹의 마지막 페이지 번호
	private int groupEndPageNo;

	// 현 그룹의 다음 그룹이 있는지 is
	private boolean hasNextPageGroup;

	// 현 그룹의 다음 이전이 있는지 is
	private boolean hasPrevPageGroup;

	// 현 노출되고 있는 그룹의 이 그룹 페이지 시작 번호
	private int prevPageGroupStartPageNo;

	// 현 노출되고 있는 그룹의 다음 그룹 페이지 시작 번호
	private int nextPageGroupStartPageNo;

	
	private String searchType;
	
	private String searchKeyword;
	
	// listSize의 기본값 할당을 위한 생성자
	public SearchListVO() {
		// 한 페이지에 10개의 게시글이 노출되도록 설정
		this.listSize = 10;

		// 한 페이지에10개 의페이지 그룹이 생성되도록 설정
		this.pageCountInGroup = 10;

	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getListSize() {
		return this.listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCountInGroup() {
		return this.pageCountInGroup;
	}

	public void setPageCountInGroup(int pageCountInGroup) {
		this.pageCountInGroup = pageCountInGroup;
	}

	public int getPageGroupCount() {
		return this.pageGroupCount;
	}

	public void setPageGroupCount(int pageGroupCount) {
		this.pageGroupCount = pageGroupCount;
	}

	public int getGroupNo() {
		return this.groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getGroupStartPageNo() {
		return this.groupStartPageNo;
	}

	public void setGroupStartPageNo(int groupStartPageNo) {
		this.groupStartPageNo = groupStartPageNo;
	}

	public int getGroupEndPageNo() {
		return this.groupEndPageNo;
	}

	public void setGroupEndPageNo(int groupEndPageNo) {
		this.groupEndPageNo = groupEndPageNo;
	}

	public boolean isHasNextPageGroup() {
		return this.hasNextPageGroup;
	}

	public void setHasNextPageGroup(boolean hasNextPageGroup) {
		this.hasNextPageGroup = hasNextPageGroup;
	}

	public boolean isHasPrevPageGroup() {
		return this.hasPrevPageGroup;
	}

	public void setHasPrevPageGroup(boolean hasPrevPageGroup) {
		this.hasPrevPageGroup = hasPrevPageGroup;
	}

	public int getPrevPageGroupStartPageNo() {
		return this.prevPageGroupStartPageNo;
	}

	public void setPrevPageGroupStartPageNo(int prevPageGroupStartPageNo) {
		this.prevPageGroupStartPageNo = prevPageGroupStartPageNo;
	}

	public int getNextPageGroupStartPageNo() {
		return this.nextPageGroupStartPageNo;
	}

	public void setNextPageGroupStartPageNo(int nextPageGroupStartPageNo) {
		this.nextPageGroupStartPageNo = nextPageGroupStartPageNo;
	}

	
	public String getSearchType() {
		return this.searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getSearchKeyword() {
		return this.searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	// 조회된 게시글 개수와 listSize를 이용해 총 몇개의 페이지가 필요한 지 계산한다
	public void computePagination(int articleCount) {
		// 페이지 개수 계산
		this.pageCount = (int) Math.ceil(articleCount / (double) this.listSize);
		// 페이지를 페이ㅣ지네이션하기 위한 계산

		// 페이지 그룹 개수 계산 {페이지 개수 / 페이지 그룹당 페이지 개수}
		this.pageGroupCount = (int) Math.ceil(this.pageCount / (double) this.pageCountInGroup);

//		현재 페이지 그룹 번호 계산 ,현재 페이지 번호 /페이지 그룹당 페이지 개수
		this.groupNo = this.pageNo / this.pageCountInGroup;

		// 현재 페이지 그룹의 시작 페이지 번호계산 현재 페이지 그룹 번호 * 페이지 그룹당 페이지 개수
		this.groupStartPageNo = this.groupNo * this.pageCountInGroup;
//		현재 페이지 그룹의 마지막 페이지 번호계산 / ( 현재 페이지 그룹번호 + 1 ) * 페이지 그룹당 페이지 개수 -1 
		this.groupEndPageNo = (this.groupNo + 1) * this.pageCountInGroup - 1;
		
		// 마지막 페이지 번호 보정 / 현재 페이지 그룹의마지막 페이지 번호가 총 페이지 개수보다클 경우 보정 필요
		if(this.groupEndPageNo > this.pageCount) {
			this.groupEndPageNo = this.pageCount -1 ;
		}
		
		// 다음 구룹이 존재하는지 계산 / 현재 페이지 그룹이 총페이지 그룹 개수보다 작을 때 -1 
		this.hasNextPageGroup = this.groupNo < this.pageGroupCount - 1;
		
		//이전 그룹이 존재하는지계 / 현재페이지 그룹이 0 보다 클 떄
		this.hasPrevPageGroup = this.pageNo > 0;
		
		// 다음 그룹의 시작 페이지 번호 계산  / 현재 페이지 그룹의 마지막 페이지 번호 + 1
		this.nextPageGroupStartPageNo = this.groupEndPageNo + 1;
		
		// 이전 그룹의 시작 페이지 번호 계산 / 현재 페이지 그룹의 시작 번호 - 현재 페이지 번호
		this.prevPageGroupStartPageNo = this.groupStartPageNo - this.pageCountInGroup;
	}

}
