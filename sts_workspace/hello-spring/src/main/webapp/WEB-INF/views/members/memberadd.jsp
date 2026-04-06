<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/hello-spring.css" type="text/css"/>
    <script src="/js/jquery-4.0.0.slim.min.js"></script>
    <script src="/js/members.js"></script>
<title>회원가입</title>
</head>
<body> 
    <form:form modelAttribute="memberVO" method="post" action="/regist" enctype="multipart/form-data">
    <div class="gird regist">
        <h1>Member Regist</h1>
        <label for="name">Name</label> 
        <div class="inputdiv">
        <input type="text" id="name" name="name" placeholder="Write your Name" value="${inputData.name}" /> 
        <form:errors path="name" cssClass="VaildationError" element="div"/>
        </div>
        <label for="email">email</label>
        <div class="inputdiv">
        <input type="email" id="email" name="email" placeholder="Enter the Email" value="${inputData.email}"/> 
        <form:errors path="email" cssClass="VaildationError" element="div"/>
        </div>
        <label for="password">password</label>
        <div class="inputdiv">
        <input type="password" id="password" name="password" placeholder="password" /> 
        <form:errors path="password" cssClass="VaildationError" element="div"/>
        </div> 
        <!-- 비밀번호 1입력 + 확인 기능  -->
        <label for="show-password">OOps</label>
        <div class="inputdiv">
        <input type="checkbox" id="show-password"/>
        </div>
        <!-- 비번 2회 입력하기  -->
         <label for ="confirm-password"> check twice</label>
         <div class="inputdiv">
            <input type="password" id="confirm-password" /> 
         </div>
        <div class="btn-group">
            <div class="right-align"> 
                <input type="submit" value="Submit" />
            </div>
        </div> 
    </div>
    </form:form> 
</body>
</html>