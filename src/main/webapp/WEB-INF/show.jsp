<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> <c:out value="${lenguaje.name}"/> </title>
	</head>
	
	<body>
		<a href="/languages">Dashboard</a>
		
		<div>		
			<p><c:out value="${lenguaje.name}"/></p>
			<p><c:out value="${lenguaje.creator}"/></p>
			<p><c:out value="${lenguaje.currentVersion}"/></p>
		</div>
		
		<div>
			<a href="/languages/${lenguaje.id}/edit"> edit</a>
		</div>
	
		<div>
			<a href="#"> Delete</a>
		</div>
		
	</body>
</html>