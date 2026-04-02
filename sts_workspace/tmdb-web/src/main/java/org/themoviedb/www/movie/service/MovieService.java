package org.themoviedb.www.movie.service;

import org.themoviedb.www.movie.vo.MovieVO;
import org.themoviedb.www.movie.vo.response.SearchResultVO;
import org.themoviedb.www.movie.vo.response.SelectResultForMovieUrlVO;

public interface MovieService {

	SearchResultVO findAllMovies();

	boolean creatNewMovie(MovieVO movieVO);

	SelectResultForMovieUrlVO findMovieByMovieId(String movieId);

}
