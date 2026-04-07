<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- JSP Import -->
<jsp:include page="/WEB-INF/views/templates/header.jsp">
	<jsp:param value="게시글 조회 : 게시글 아이디 " name="title" />
	<jsp:param
		value="<script type='text/javascript' src='/js/board.js'> </script>"
		name="script" />
</jsp:include>
<h1>게시글 내용 조회</h1>
<div class="gird view">
	<span> id </span>
	<div>${article.memberVO.registDate}</div>

	<span> subtitle </span>
	<div>${article.subject}</div>

	<span> email </span>
	<div> t ${article.memberVO.name} q</div>

	<span> viewCount </span>
	<div>${article.viewCnt}</div>

	<span> creatDate </span>
	<div>${article.crtDt}</div>

	<span> mMdfiy date </span>
	<div>${article.mdfyDt}</div>

	<span> 첨부파일 </span>
	<div>
		<ul class="vertical-list">
			<c:forEach items="${article.files}" var="file">
				<li><a href="/file/${file.fileGroupId}/${file.fileNum}">
						${file.displayName}</a></li>
			</c:forEach>
		</ul>
	</div>

	<span> content </span>
	<!-- pre => Presentation -->
	<pre>${article.content}</pre>

	<div class="btn-group">
		<div class="right-align">
			<c:if test="${article.email eq sessionScope.__LOGIN_DATA__.email}">
				<a class="del-btn" href="/update/${article.id}">Update</a>
				<a class="del-btn" href="/delete?id=${article.id}">Delete</a>
            </c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp">
	<jsp:param value="게시글 내용 조회 : ${board.id} " name="title" />
</jsp:include>
