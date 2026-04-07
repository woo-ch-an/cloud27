<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value ="View Member " name="title" />
    <jsp:param value ="<script type='text/javascript' src='/js/members.js'> </script>" name="script" />
</jsp:include>


		<h1>View Members</h1>
	<div class="grid update">
		<div>
			<label for="name">Name : </label> <label> ${name} ~ </label>
		</div>

		<div>
			<label for="email">email</label> <label> ${email} </label>

		</div>

		<div>
			<label for="password">password</label> <label> ${password}</label>

		</div>
		<div class="btn-group">
			<div class="right-align">
                <a class="del-btn" href="/mupdate/${email}">Update</a>
                <a class="del-btn" href="/mdelete/${email}">Delete</a>
                <a class="del-btn" href="/delete-me">탈퇴</a>
			</div>
		</div>

	</div>
 <jsp:include page="/WEB-INF/views/templates/footer.jsp"> 
    <jsp:param value ="게시글 내용 조회 : ${board.id} " name="title" />
 </jsp:include>