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
		<h4>Articoli pubblicati</h4>
		<table border="1">
			<thead>
				<tr>
					<th>Titolo</th>
					<th>Data Pubblicazione</th>
					<th>Autore</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="articolo" items="${lista_articoli}">
					<tr>
						<td>${articolo.getTitolo()}</td>
						<td>${articolo.getData()}</td>
						<td>${articolo.getAutore().getUsername()}</td>
						<td>
							<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}" method="get">
								<input type="submit" value="Click">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${giornalista == '1'}">
		<div align="center">
			<h4>Area giornalista</h4>
			<form action="/SpringMVC/home/articoli/crea" method="get">
				<input type="submit" value="Nuovo articolo">
			</form>
		</div>
	</c:if>
	<br>
	<div align="center">
		<form action="/SpringMVC/home" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>