package com.ktdsuniversity.edu.tmdb.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.dao.query.MakeQuery;
import com.ktdsuniversity.edu.tmdb.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.tmdb.db.helper.SQLType;
import com.ktdsuniversity.edu.tmdb.vo.MakeVO;
import com.ktdsuniversity.edu.tmdb.vo.ProducerVO;

public class MakeDao {
	DataAccessHelper dah;
	
	public MakeDao(DataAccessHelper dah) {
		this.dah = dah;
	}
	
	public List<MakeVO> selectMakeByMovieId(String movieID){
		List<MakeVO> makeVO = new ArrayList<>();
		MakeVO make = new MakeVO();

		this.dah.preparedStatement(MakeQuery.makeSelectQuery(), pstmt -> {
			pstmt.setString(1, movieID);			
		});

		this.dah.executeQuery(SQLType.SELECT, rs -> {
			make.setMakeId(rs.getString("MAKE_ID"));
			make.setProducerId(rs.getString("PRODUCER_ID"));
			make.setMovieId(rs.getString("MOVIE_ID"));
			make.setRole(rs.getString("ROLE"));
			make.setPart(rs.getString("PART"));
			makeVO.add(make);
			
			ProducerVO eachProducer = new ProducerVO();
			eachProducer.setProducerId(rs.getString("PRODUCER_ID"));
			eachProducer.setProducerName(rs.getString("PRODUCER_NAME"));
			
			make.setProducer(eachProducer);
			
			makeVO.add(make);
		});
		
		return makeVO;
	}
}
