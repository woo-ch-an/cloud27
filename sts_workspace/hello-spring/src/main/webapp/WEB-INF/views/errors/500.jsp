<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value ="SERVER ERROR " name="title" /></jsp:include>
<h1>! SYSTEM ERROR !</h1>
<h3> please try again later</h3>
 <jsp:include page="/WEB-INF/views/templates/footer.jsp">  
    <jsp:param value ="Good Bye " name="title" />
 </jsp:include>