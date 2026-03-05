package com.ktdsuniversity.edu.tmdb.dao;

import com.ktdsuniversity.edu.tmdb.dao.query.MovieQuery;
import com.ktdsuniversity.edu.tmdb.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.tmdb.db.helper.SQLType;
import com.ktdsuniversity.edu.tmdb.vo.MovieVO;

public class MovieDao {

	private DataAccessHelper dah;

	public MovieDao(DataAccessHelper dah) {
		this.dah = dah;
	}

	public MovieVO selectMovie(String movieID) {
		MovieVO movievo = new MovieVO();

		this.dah.preparedStatement(MovieQuery.MakeSelectQuery(), pstmt -> {
			pstmt.setString(1, movieID);
		});

		this.dah.executeQuery(SQLType.SELECT, rs -> {
			movievo.setMovieId(rs.getString("MOVIE_ID"));
			movievo.setPosterUrl(rs.getString("POSTER_URL"));
			movievo.setTitle(rs.getString("TITLE"));
			movievo.setMovieRating(rs.getString("MOVIE_RATING"));
			movievo.setOpenDate(rs.getString("OPEN_DATE"));
			movievo.setRunningTime(rs.getInt("RUNNING_TIME"));
			movievo.setIntroduce(rs.getString("INTRODUCE"));
			movievo.setSynopsis(rs.getString("SYNOPSIS"));
			movievo.setOriginalTitle(rs.getString("ORIGINAL_TITLE"));
			movievo.setState(rs.getString("STATE"));
			movievo.setLanguage(rs.getString("\"LANGUAGE\""));
			movievo.setBudget(rs.getLong("BUDGET"));
			movievo.setProfit(rs.getLong("PROFIT"));
		});

		return movievo;
	}
}
