<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- JSP Import -->
 <jsp:include page="/WEB-INF/views/templates/header.jsp"> 
    <jsp:param value ="CANNOT FIND PAGE " name="title" /></jsp:include>
<h1>${errorMessage}</h1>
 <jsp:include page="/WEB-INF/views/templates/footer.jsp">  
    <jsp:param value ="Good Bye " name="title" />
 </jsp:include>