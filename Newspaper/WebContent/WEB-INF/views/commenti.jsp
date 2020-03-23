<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Newspaper</title>
	<script type="text/javascript">
		function validaInvio(){
			if(document.creaForm.testo.value=="") {
				alert("Inserire un commento!");
				return false;
			}
			
			if(confirm("Creare il commento?")) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<h4>${articolo.getTitolo()}</h4>
		<h2>Commenti</h2>
		<table border="1">
			<thead>
				<tr>
					<th>N.</th>
					<th>Testo</th>
					<th>Data</th>
					<th>Utente</th>
					<th>Opzioni</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="commento" items="${commenti}">
					<tr>
						<td>${commento.getId_commento()}</td>
						<td>${commento.getTesto()}</td>
						<td>${commento.getData().toString().substring(0, 10)}</td>
						<td>${commento.getAutore().getUsername()}</td>
						<c:choose>
						<c:when test="${commento.getAutore().getId_utente() == idUtente}">
							<td>
								<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/commenti/${commento.getId_commento()}/cancella" onsubmit="return confirm('Cancellare il commento?');" method="get">
									<input style="margin-bottom: 3%" type="submit" value="Cancella">
								</form>
								<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/commenti/${commento.getId_commento()}/modifica" method="get">
									<input style="margin-bottom: 3%" type="submit" value="Modifica">
								</form>
							</td>
						</c:when>
						<c:when test="${giornalista == '1'}">
							<td>
								<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/commenti/${commento.getId_commento()}/cancella" onsubmit="return confirm('Cancellare il commento?');" method="get">
									<input style="margin-bottom: 3%" type="submit" value="Cancella">
								</form>
							</td>
						</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div align="center">
		<h2>Inserisci Commento</h2>
		<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/commenti/crea" name="creaForm" method="post" onsubmit="return validaInvio();">
			<table border="1">
				<tbody>
					<tr>
						<th>Testo</th>
						<td>
							<textarea id="testo" name="testo" rows="5" cols="100" maxlength="200"></textarea>
						</td>
					</tr>
					<tr>
						<th>Data</th>
						<td>
							<textarea id="data" name="data" rows="1" cols="100" readonly="readonly"></textarea>
						</td>
					</tr>
					<tr>
						<th>ID Utente</th>
						<td>
							<textarea id="id_utente" name="id_utente" rows="1" cols="100" readonly="readonly">${utente.getId_utente()}</textarea>
						</td>
					</tr>
					<tr>
						<th>ID Articolo</th>
						<td>
							<textarea id="id_articolo" name="id_articolo" rows="1" cols="100" readonly="readonly">${articolo.getId_articolo()}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<input type="submit" value="Inserisci">
		</form>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
	<script>
		var d = new Date(),
		month = ("0" + (d.getMonth() + 1)).slice(-2),
		date = d.getDate(),
		year = d.getFullYear(),
		area = document.getElementsByTagName("textarea")[1];
		area.value = year + "-" + month + "-" + date;
	</script>
</body>
</html>