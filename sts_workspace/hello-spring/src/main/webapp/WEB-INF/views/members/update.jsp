<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/hello-spring.css" type="text/css" />
<title>회원가입</title>
</head>
<body>
	<form method="post" action="/mupdate/${email}">
		<div class="gird update">
			<h1>View Members</h1>
			<div>
				<label for="name">Name : </label> <input name="name" type=text
					value="${name}" />
			</div>

			<div>
				<label for="email">email : </label> <input name="email" type=text
					value="${email }" />

			</div>

			<div>
				<label for="password">password : </label> <input name="password"
					type=text value="${password}" />

			</div>
			<div class="btn-group">
				<div class="right-align">
					<input type="submit" value="저장" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>