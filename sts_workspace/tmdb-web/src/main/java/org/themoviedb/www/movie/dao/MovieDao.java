package org.themoviedb.www.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.themoviedb.www.movie.vo.MovieVO;
import org.themoviedb.www.movie.vo.response.SelectResultForMovieUrlVO;

@Mapper
public interface MovieDao {

	int selectMovieCount() ;

	List<MovieVO> selectMovieList();

	int insertNewMovie(MovieVO movieVO);

	SelectResultForMovieUrlVO findMovieByMovieId(String movieId); 

}
