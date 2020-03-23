<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper</title>
</head>
<body>
	<div align="center">
		<h4>I tuoi articoli</h4>
		<table border="1">
			<thead>
				<tr>
					<th>Titolo</th>
					<th>Data</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="articolo" items="${articoli}">
					<tr>
						<td>${articolo.getTitolo()}</td>
						<td>${articolo.getData()}</td>
						<td>
							<form method="get" action="/SpringMVC/home/articoli/${articolo.getId_articolo()}">
								<input type="submit" value="Click">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home/profili/${utente}">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>