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
		<h4>I tuoi commenti</h4>
		<table border="1">
			<thead>
				<tr>
					<th>N.</th>
					<th>Titolo Articolo</th>
					<th>Testo Commento</th>
					<th>Data</th>
					<th>Link Articolo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="commento" items="${commenti}">
					<tr>
						<td>${commento.getId_commento()}</td>
						<td>${commento.getArticolo().getTitolo()}</td>
						<td>${commento.getTesto()}</td>
						<td>${commento.getData()}</td>
						<td>
							<form action="/SpringMVC/home/articoli/${commento.getArticolo().getId_articolo()}" method="get">
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
		<form action="/SpringMVC/home/profili/${utente.getId_utente()}" method="get">
			<input style="margin-bottom: 3%" type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>