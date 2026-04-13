<%-- <%@ 디렉티브 %> --%>
<%-- Page Directive --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL 을 사용하기 위해 taglib directory 필요 --%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value ="게시글 내용 조회 : ${board.id} " name="title" />
    </jsp:include>
	<h1>게시글 목록</h1>
	<div>총 ${searchCount}개의 게시글이 검색되었습니다</div>
		<table class="grid">
			<thead>
				<tr>
					<th>No</th>
					<th>Subtitle</th>
					<th>Email</th>
					<th>ViewCount</th>
					<th>Creatdate</th>
					<th>ModifyDate</th>

				</tr>
			</thead>
			<tbody>
				<!--  SerachResult 가 있으면 데이터 보여주고 아님말고-->
				<c:choose>
					<c:when test="${not empty searchResult}">
						<c:forEach items="${searchResult}" var="board">
							<tr>
								<!-- 반복상  -->
								<td>${board.id}</td>
								<td><a href="/view/${board.id}"> ${board.subject}</a></td>
								<td>${board.email}</td>
								<td>${board.viewCnt}</td>
								<td>${board.crtDt}</td>
								<td>${board.mdfyDt}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>

							<td colspan="6">no data</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>


	</table>
	<div class="del-btn ">
		<c:if test="${not empty sessionScope.__LOGIN_DATA__}">
	<a href="/write"> New article</a>
</c:if>
</div>

  <ul class="page-navigator">
          <c:forEach begin="0" 
                     end="${pagination.pageCount}" 
                     step="1"
                     var="page">
            ${page}
          </c:forEach>
        </ul>

	<jsp:include page="/WEB-INF/views/templates/footer.jsp"> 
    <jsp:param value ="게시글 내용 조회 : ${board.id} " name="title" />
 </jsp:include>