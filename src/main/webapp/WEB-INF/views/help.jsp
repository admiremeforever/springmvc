<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help page</title>
</head>
<body>

	<%
	/* 	String name = (String) request.getAttribute("name");

		LocalDateTime time = (LocalDateTime) request.getAttribute("time"); */
	%>
	<h3>Hi we are in help page</h3>
	<h1>
		Hello my name is ${name}
		<%-- <%=name%> --%>
	</h1>

	<h1>
		Present date and time is ${time}
		<%-- <%=time%> --%>
	</h1>

	<hr>
	<c:forEach var="item" items="${marks}">

		<h1>${item }</h1>
	</c:forEach>


</body>
</html>