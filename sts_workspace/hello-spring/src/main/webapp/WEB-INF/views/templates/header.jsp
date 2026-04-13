<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/hello-spring.css" type="text/css" />
${param.css}
<script type="text/javascript" src="/js/jquery-4.0.0.slim.min.js"></script>
<title>${param.title}</title>
${param.script}
</head>
<body>
	<!-- HTML 주석 개발자도구에서 보 -->
	<%-- JSP주석 개발자 도구에서안보임 --%>
	<%--
<% for (BoardVO board:searchResult) { %>
<div> <%=board.getId()%></div>
}
<% } %> 
--%>
	<div class="wrapper">
	<div class= "header">
		<c:choose>
			<c:when test="${empty sessionScope.__LOGIN_DATA__}">
				<%--로그인 안 했을 때 --%>
				<a href="/regist"> Regist </a>
				<a href="/login"> Login </a>
				<%--로그인 안 했을 때 --%>
			</c:when>
			<c:otherwise>
				<div class="member-info" data-email="${sessionScope.__LOGIN_DATA__.email}"> ${sessionScope.__LOGIN_DATA__.name} ( ${sessionScope.__LOGIN_DATA__.email} )</div>
				<%--로그인 했을 때 --%>  
				<a href="/mview/${sessionScope.__LOGIN_DATA__.email}">마이페이지</a>
				<a href="/logout"> 로그아웃 </a>
				<%--로그인 했을 때 --%>
			</c:otherwise>
		</c:choose>
	</div>