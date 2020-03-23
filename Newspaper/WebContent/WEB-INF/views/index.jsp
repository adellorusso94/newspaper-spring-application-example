<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper</title>
</head>
<body>
	<div class="form" align="center">
		<h3>${message}</h3>
		<h4>Login</h4>
		<form action="/SpringMVC/" method="post">
			<p>
				<input type="text" placeholder="username" name="username">
			</p>
			<p>
				<input type="password" placeholder="password" name="password">
			</p>
			<p>
				<input type="submit" class="button" value="Accedi">
			</p>
		</form>
		<form action="/SpringMVC/nuovo_utente" method="get">
			<input type="submit" value="Registrati">
		</form>
	</div>
</body>
</html>