<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <sec:csrfMetaTags />
<link rel="stylesheet" href="/css/hello-spring.css" type="text/css" />
${param.css}
<script type="text/javascript" src="/js/jquery-4.0.0.slim.min.js"></script>
<title>${param.title}</title> ${param.script}
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
		<div class="header">
			<sec:authorize access="!isAuthenticated()">
				<%--로그인 안 했을 때 --%>
				<a href="/regist"> Regist </a>
				<a href="/login"> Login </a>
				<%--로그인 안 했을 때 --%>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<%-- 로그인 했을 때의 링크 시작 --%>
				<div class="member-info"
					data-email="<sec:authentication property='principal.email' />">
					<sec:authentication property='principal.name' />
					🏿 (
					<sec:authentication property='principal.email' />
					)
				</div>
				<a
					href="/member/view/<sec:authentication property='principal.email' />">마이페이지</a>
				<a href="/logout">로그아웃</a>
				<%-- 로그인 했을 때의 링크 끝 --%>
			</sec:authorize>
		</div>