<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper</title>
<script>
		function validaInvio() {
			if (confirm("Cancellare l'articolo?")) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<h2>${articolo.getTitolo()}</h2>
		<h4>di ${articolo.getAutore().getUsername()}</h4>
		<br>
		<textarea id="testo" name="testo" rows="50" cols="100"
			maxlength="4000" readonly="readonly">${articolo.getTesto()}</textarea>
	</div>
	<c:if test="${giornalista == '1'}">
		<div align="center">
			<h4>Area giornalista</h4>
			<br>
			<form
				action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/modifica"
				method="get">
				<input type="submit" value="Modifica">
			</form>
			<br>
			<form
				action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/cancella"
				onsubmit="return validaInvio();" method="get">
				<input type="submit" value="Cancella">
			</form>
		</div>
	</c:if>
	<br>
	<div align="center">
		<h4>Commenti</h4>
		<form
			action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/commenti"
			method="get">
			<input type="submit" value="Visualizza">
		</form>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home/articoli" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>