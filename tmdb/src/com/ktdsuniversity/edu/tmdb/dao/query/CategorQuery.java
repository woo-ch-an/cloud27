package com.ktdsuniversity.edu.tmdb.dao.query;

public class CategorQuery {
	
	public static String MakeSelectQuery() {
		StringBuffer rt = new StringBuffer();
		
		rt.append("SELECT CATEGORY_ID                                              ");
	    rt.append("     , CATEGORY_NAME                                            ");
	    rt.append("  FROM CATEGORY                                                 ");
	    rt.append(" WHERE CATEGORY_ID IN (SELECT CATEGORY_ID                       ");
	    rt.append("                         FROM GENRE                             ");
	    rt.append("                        WHERE MOVIE_ID = ?)  ");
		
		return rt.toString();
		
	}
}
