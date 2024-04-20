<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
       
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> <c:out value="${lenguaje.name}"/> </title>
	</head>
	<body>
		<form action="/languages/${lenguaje.id}" method="post">
					<input type="hidden" name="_method" value="delete">		
					<input type="submit" value="Delete">
					</form> 	
			<a href="/languages">Dashboard</a>
		
		<form:form action="/languages/${lenguaje.id}" method="POST" modelAttribute="lenguaje">
		<input type="hidden" name="_method" value="put">
		
		<p>
			<form:label path="name"> Name </form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		
		<p>
			<form:label path="creator"> Creator </form:label>
			<form:input path="creator"/>
			<form:errors path="creator"/>
		</p>
		
		<p>
			<form:label path="currentVersion"> Version </form:label>
			<form:input path="currentVersion"/>
			<form:errors path="currentVersion"/>
		</p>
		
		<input type="submit" value="Submit"/>
		
		</form:form>
		
	</body>
</html>