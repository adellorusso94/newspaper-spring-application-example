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
		<h4>Il tuo profilo</h4>
		<table border="1">
			<thead>
				<tr id="firstRow">
					<th colspan="2">I tuoi dati</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>Nome</th>
					<td>${utente.getNome()}</td>
				</tr>
				<tr>
					<th>Cognome</th>
					<td>${utente.getCognome()}</td>
				</tr>
				<tr>
					<th>Username</th>
					<td>${utente.getUsername()}</td>
				</tr>
				<c:choose>
					<c:when test="${utente.getGiornalista()==1}">
						<tr>
							<th>Tipo Utente</th>
							<td>Giornalista</td>
						</tr>
					</c:when>
					<c:when test="${utente.getGiornalista()==0}">
						<tr>
							<th>Tipo Utente</th>
							<td>Lettore</td>
						</tr>
					</c:when>
				</c:choose>
			</tbody>
		</table>
	</div>
	<br>
	<c:if test="${utente.getGiornalista()==1}">
		<div align="center">
			<form action="/SpringMVC/home/profili/${utente.getId_utente()}/articoli" method="get">
				<input type="submit" value="I tuoi articoli">
			</form>
		</div>
		<br>
	</c:if>
	<div align="center">
		<form action="/SpringMVC/home/profili/${utente.getId_utente()}/commenti">
			<input type="submit" value="I tuoi commenti">
		</form>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>