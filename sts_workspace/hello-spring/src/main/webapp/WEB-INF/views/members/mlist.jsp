<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value ="List Member " name="title" />
    <jsp:param value ="<script type='text/javascript' src='/js/members.js'> </script>" name="script" />
</jsp:include>


	<div class="gird update">
		<h1>List of Members</h1>
		<h4>we have ${Count} Members ~</h4>
		<table class="grid write">
			<thead>
				<tr>

					<th>Name</th>
					<th>Email</th>
					<th>Password</th>

				</tr>

			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty memberList}">
						<c:forEach items="${memberList}" var="member">
							<tr>
								<!-- 반복상  -->
								<td>${member.name}</td>
								<td><a href="/mview/${member.email}"> ${member.email}</a></td>
								<td>${member.password}</td>

							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3">no Memeber</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

    <a href="/regist"> Register</a>
	</div>
 <jsp:include page="/WEB-INF/views/templates/footer.jsp"> 
    <jsp:param value ="게시글 내용 조회 : ${board.id} " name="title" />
 </jsp:include>