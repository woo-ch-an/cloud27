<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- JSP Import -->
<jsp:include page="/WEB-INF/views/templates/header.jsp">
	<jsp:param value="Login " name="title" />
	<jsp:param
		value="<script type='text/javascript' src='/js/board.js'> </script>"
		name="script" />
</jsp:include>
<h1>로그인</h1>
<form:form modelAttribute="loginVO" method="post" action="/login">
	<c:if test="${not empty errorMessage}">
		<div class="VaildationError">${errorMessage}</div>
	</c:if>
	<div class="gird login">
		<label for="login-email">이메일</label>
		<div class="inputdiv">
			<input type="email" id="login-email" name="email"
				placeholder="이메일을 입력하세요." value="${loginData.email}${errorData.email}" />
			<form:errors path="email" cssClass="VaildationError" element="div" />
		</div>

		<label for="login-password">비밀번호</label>
		<div class="inputdiv">
			<input type="password" id="login-password" name="password"
				placeholder="비밀번호를 입력하세요." />
			<form:errors path="password" cssClass="VaildationError" element="div" />
		</div>

		<div class="btn-group">
			<div class="right-align">
				<input type="submit" value="로그인" />
			</div>
		</div>
	</div>
</form:form>
<jsp:include page="/WEB-INF/views/templates/footer.jsp">
	<jsp:param value="게시글 내용 조회 : ${board.id} " name="title" />
</jsp:include>