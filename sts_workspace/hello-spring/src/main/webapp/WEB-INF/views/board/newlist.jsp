<%-- <%@ 디렉티브 %> --%>
<%-- Page Directive --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL 을 사용하기 위해 taglib directory 필요 --%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value =" 게시글 조회 " name="title" />
    <jsp:param value ="<script type='text/javascript' src='/js/board.js'> </script>" name="script" />
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

<div class="search-box">
<select id="list-size">
    <option value="10" ${pagination.listSize eq "10" ? "selected" : ""}> 10 </option>
    <option value="20" ${pagination.listSize eq "20" ? "selected" : ""}> 20 </option>
    <option value="50" ${pagination.listSize eq "50" ? "selected" : ""}> 50 </option>
    <option value="100" ${pagination.listSize eq "100" ? "selected" : ""}> 100 </option>
    
</select>
<div>
<select id="search-type"> 
<option value="email" ${pagination.searchType eq "email" ? "selected" : "" }> Email 검색 </option>
<option value="name" ${pagination.searchType  eq "name" ? "selected" : "" }> name 검색 </option>
<option value="subject" ${pagination.searchType eq "subject" ? "selected" : "" }> subject 검색 </option>
<option value="content" ${pagination.searchType eq "content" ? "selected" : "" }> content 검색 </option>
<option value="subject+content" ${pagination.searchType eq "subject content" ? "selected" : "" }> subject+content 검색 </option>

</select>
<input type="text" id="search-keyword" placeholder="검색어 입력" value="${pagination.searchKeyword}"/>
<button class="search-button" type="button"> 검색</button>
</div>
</div>

<c:if test="${pagination.pageCount > 0 }">
<ul class="page-navigator">
	<c:if test="${pagination.hasPrevPageGroup}">
		<li><a data-page-no="0" href="javascript:void(-1);">처음</a>
		</li>
		<li><a data-page-no="${pagination.prevPageGroupStartPageNo}"  href="javascript:void(-1);"> 이전 </a></li>
	</c:if>
	<c:forEach begin="${pagination.groupStartPageNo}" end="${pagination.groupEndPageNo}" step="1"
		var="page">
		<li class="${page eq pagination.pageNo ? 'active' : '' }"><a href="/?pageNo=${page}&listSize=${pagination.listSize}">${page + 1}</a>
		</li>
	</c:forEach>

	<c:if test="${pagination.hasNextPageGroup}">
		<li><a data-page-no="${pagination.nextPageGroupStartPageNo}"  href="javascript:void(-1);">다음 </a> </li>
		<li><a data-page-no="${pagination.pageCount-1}" href="javascript:void(-1);" "> 마지막  </a></li>
	</c:if>
</ul>
</c:if>
<jsp:include page="/WEB-INF/views/templates/footer.jsp">
	<jsp:param value="게시글 내용 조회 : ${board.id} " name="title" />
</jsp:include>