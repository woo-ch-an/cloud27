package com.ktdsuniversity.edu.tmdb.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.dao.query.AppearanceQuery;
import com.ktdsuniversity.edu.tmdb.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.tmdb.db.helper.SQLType;
import com.ktdsuniversity.edu.tmdb.vo.ActorVO;
import com.ktdsuniversity.edu.tmdb.vo.AppearanceVO;

public class AppearanceDao {
	DataAccessHelper dah;
	
	public AppearanceDao(DataAccessHelper dah) {
		this.dah = dah;
	}
	
	public List<AppearanceVO> selectAppearanaceByMovieId(String movieID){
		List<AppearanceVO> returnList = new ArrayList<>();
		AppearanceVO appearance = new AppearanceVO();
		ActorVO act = new ActorVO();
		
		this.dah.preparedStatement(AppearanceQuery.makeSelectQuery(), pstmt -> {
			pstmt.setString(1, movieID);			
		});

		this.dah.executeQuery(SQLType.SELECT, rs -> {
			appearance.setAppearanceId(rs.getString("APPEARANCE_ID"));
			appearance.setActorId(rs.getString("ACTOR_ID"));
			appearance.setMovieId(rs.getString("MOVIE_ID"));
			appearance.setCharacter(rs.getString("\"CHARACTER\""));
			act.setActorId(appearance.getActorId());
			act.setActorName(rs.getString("ACTOR_NAME"));
			act.setActorProfileUrl(rs.getString("ACTOR_PROFILE_URL"));
			
			appearance.setActor(act);
			
			returnList.add(appearance);
		});
		
		return returnList;
	}
}
