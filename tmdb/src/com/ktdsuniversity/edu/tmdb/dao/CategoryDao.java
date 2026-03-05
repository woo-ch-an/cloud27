package com.ktdsuniversity.edu.tmdb.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.dao.query.CategorQuery;
import com.ktdsuniversity.edu.tmdb.db.helper.DataAccessHelper;
import com.ktdsuniversity.edu.tmdb.db.helper.SQLType;
import com.ktdsuniversity.edu.tmdb.vo.CategoryVO;

public class CategoryDao {
	DataAccessHelper dah;
	
	public CategoryDao(DataAccessHelper dah) {
		this.dah = dah;
	}
	
	public List<CategoryVO> selectCategoriesByMovieId(String movieID){
		List<CategoryVO> category = new ArrayList<>();
		CategoryVO cgvo = new CategoryVO();
		
		this.dah.preparedStatement(CategorQuery.MakeSelectQuery(), pstmt -> {
			pstmt.setString(1, movieID);			
		});

		this.dah.executeQuery(SQLType.SELECT, rs -> {
			cgvo.setCategoryId(rs.getString("CATEGORY_ID"));
			cgvo.setCategoryName(rs.getString("CATEGORY_NAME"));
			category.add(cgvo);
		});
		
		return category;
	}
}
