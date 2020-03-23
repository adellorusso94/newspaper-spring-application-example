<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Newspaper</title>
</head>
<body>
	<div align="center">
		<h3>Benvenuto ${utente.getUsername()}</h3>
		<br>
		<form action="/SpringMVC/home/profili/${utente.getId_utente()}" method="get">
			<input type="submit" value="Profilo">
		</form>
		<br>
		<form action="/SpringMVC/home/articoli" method="get">
			<input type="submit" value="Articoli">
		</form>
		<br>
		<form action="/SpringMVC/logout" method="get">
			<input type="submit" value="Esci">
		</form>
	</div>
</body>
</html>