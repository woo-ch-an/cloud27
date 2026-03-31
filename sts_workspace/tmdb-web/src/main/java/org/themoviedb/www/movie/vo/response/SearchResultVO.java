package org.themoviedb.www.movie.vo.response;

import java.util.List;

import org.themoviedb.www.movie.vo.MovieVO;

public class SearchResultVO {
	
	private List<MovieVO> result;
	private int Count;
	
	
	public List<MovieVO> getResult() {
		return result;
	}
	public void setResult(List<MovieVO> result) {
		this.result = result;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
}
