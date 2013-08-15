<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>${message}</h1>
		<a href="/new">new</a>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>desc</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
					<tr>
						<td>${task.id}</td>
						<td>${task.name}</td>
						<td>${task.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>