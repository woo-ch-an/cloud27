<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Details</title>
</head>
<body>
<h1>Show Movie Details</h1>
    <div class="gird view">
        <span>Title</span>
        <div>${movieVO.title}</div>

        <span> Rate </span>
        <div>${movieVO.movieRating}</div>
 

        <span> openCountry </span>
        <div>${movieVO.openCountry}</div>

        <span> runningTime </span>
        <div>${movieVO.runningTime}</div>

        <span> Introduce </span>
        <div>${movieVO.introduce}</div>
        
        <span> Poster </span>
        <div> 
        <img src="/file/${movieVO.movieId}">
        </div>
        
        <span> Synopsis </span> 
        <pre>${article.synopsis}</pre>
        
        
 
    </div>
</body>
</html>