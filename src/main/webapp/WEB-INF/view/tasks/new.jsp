<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>new</title>
	</head>
	<body>
		<form:form action="" method="POST" modelAttribute="task" >
			<form:input path="name" class="input-large" />
		    <form:errors path="name" cssClass="alert alert-error" />
		    <form:input path="description" class="input-large" />
		    <form:errors path="description" cssClass="alert alert-error" />
		    
		    <button type="submit" >Save</button>
		</form:form>
	</body>
</html>