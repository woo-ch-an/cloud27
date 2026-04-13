<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/tmdb-web.css" type="text/css"/>
<script type="text/javascript" src="/js/jquery-4.0.0.slim.min.js"></script>
<script type="text/javascript" src="/js/movie.js"></script>
<title>Movie Write</title>
</head>
<body>
<div class="wrapper">
	<h1>New Movie</h1>
	<form:form modelAttribute="updateVO" method="post" action="/update/${updateVO.movieId}" enctype="multipart/form-data">
		<div class="gird write">
			<label for="title">Movie Title</label> 
			<div class="inputdiv">
            <input type="text" id="title"name="title" placeholder="Movie Title" value="${updateVO.title}"/> 
            <form:errors path="title" cssClass="VaildationError" element="div"/>
            </div>
            <!--  Poster area ~  -->
            <!-- <label for="posterUrl">Movie PosetURL</label> 
            <input type="text" id="posterUrl"name="posterUrl" placeholder="Movie posetURL" /> -->

            <label for="attach-files">첨부파일</label>
            <div id="attach-files" class="attach-files">
            
                <input type="file" name="attachFile" /> 
                
            </div>
            <!--  Poster End -->
            
            <label for="movieRating">Movie Rating</label>
			<input id="movieRating" type="text" name="movieRating" placeholder="Movie Rating Ex)PG" value="${updateVO.movieRating}" />  

            <label for="openDate"> Release Date</label>
			<input id="openDate" type="date" name="openDate" placeholder="Movie Release Date" value="${updateVO.openDate}"/>  
            <label for="openCountry">Release Country</label>
            
			<input id="openCountry" type="text" name="openCountry" placeholder="Release Country" value="${updateVO.openCountry}"/>  
             <label for="runningTime">Runnig Time</label>
             
			<input id="runningTime" type="number" name="runningTime" placeholder="Running Time" value="${updateVO.runningTime}" /> 
             <label for="introduce">Introduce</label>
             
			<input id="introduce" type="text" name="introduce" placeholder="One-liner review" value="${updateVO.introduce}" /> 
			
             <label for="synopsis">Synopsis</label>
             
            <div class="inputdiv"> 
			<input id="synopsis" type="text" name="synopsis" placeholder="This movie is about  ..." value="${updateVO.synopsis}"/> 
			<form:errors path="synopsis" cssClass="VaildationError" element="div"/>
          
			</div>
			
             <label for="originalTitle">Original Title</label>
			
			<input id="originalTitle" type="text" name="originalTitle" placeholder="Original Title" value="${updateVO.originalTitle}"/> 
             <label for="state">State</label>
			
			<input id="state" type="text" name="state" placeholder="Current status of the movie" value="${updateVO.state}" /> 
             <label for="language">Language</label>
			
			<div class="inputdiv">
			<input id="language" type="text" name="language" placeholder="Language" value="${updateVO.language }]"/> 
			<form:errors path="language" cssClass="VaildationError" element="div"/>
            
			</div>
             <label for="budget">Production Cost</label>
			 
			<input id="budget" type="number" name="budget" placeholder="-1000$ ..." value="${updateVO.budget}"/> 
			 
             <label for="profit">Gross revenue</label>
			 
			<input id="profit" type="number" name="profit" placeholder="+1000$ ..." value="${updateVO.profit}"/> 
           
        
        <div class="btn-group">
			<div class="right-align">
				<input type="submit" value="저장" />
			</div>
		</div> 
		</div>
	</form:form></div>
</body>
</html>