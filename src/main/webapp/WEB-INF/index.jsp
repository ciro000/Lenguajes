<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>


<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Languages </title>
	</head>
	
	<body>
		
		<table>
			<thead>
				<tr>
					<th> Name </th>
					<th> Creator </th>
					<th> Version </th>
					<th> Action </th>
			</thead>
			<tbody>
				<c:forEach items="${lenguajes}" var="lenguaje">
				<tr>
					<td><c:out value="${lenguaje.name}"/></td>
					<td><c:out value="${lenguaje.creator}"/></td>
					<td><c:out value="${lenguaje.currentVersion}"/></td>
					<td>
					
					<form action="/languages/${lenguaje.id}" method="post">
					<input type="hidden" name="_method" value="delete">		
					<input type="submit" value="Delete">
					</form>
					
						 <a href="/languages/${lenguaje.id}/edit"> edit</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<form:form action="/languages" method="post" modelAttribute="lenguaje">
			<p>
				<form:label path="name"> Name </form:label>
				<form:input path="name" type="text"/>
				<form:errors path="name"/>
			</p>
			
			<p>
				<form:label path="creator"> Creator </form:label>
				<form:input path="creator" type="text"/>
				<form:errors path="creator"/>
			</p>
			
			<p>
				<form:label path="currentVersion"> Version </form:label>
				<form:input path="currentVersion" type="text"/>
				<form:errors path="currentVersion"/>
			</p>
			
			<input type="submit" value="Submit"/>
		
		</form:form>
	
	
	</body>
</html>