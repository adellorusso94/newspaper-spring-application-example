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
			if(document.modificaForm.testo.value=="") {
				alert("Inserire un testo!");
				return false;
			}
			
			if(confirm("Modificare il commento?")) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<h4>Modifica Articolo</h4>
		<br>
		<form action="/SpringMVC/home/articoli/${commento.getArticolo().getId_articolo()}/commenti/${commento.getId_commento()}/modifica/invio" name="modificaForm" method="post" onsubmit="return validaInvio();">
			<table>
				<tbody>
					<tr>
					<tr>
						<th>
							Testo
						</th>
						<td>
							<textarea id="testo" name="testo" rows="10" cols="100" maxlength="200">${commento.getTesto()}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							Data
						</th>
						<td>
							<textarea id="data" name="data" rows="1" cols="100" readonly="readonly">${commento.getData().toString().substring(0, 10)}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							ID Utente
						</th>
						<td>
							<textarea id="id_utente" name="id_utente" rows="1" cols="100" readonly="readonly">${commento.getAutore().getId_utente()}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							ID Articolo
						</th>
						<td>
							<textarea id="id_articolo" name="id_articolo" rows="1" cols="100" readonly="readonly">${commento.getArticolo().getId_articolo()}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<input type="submit" value="Modifica">
		</form>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home/articoli/${commento.getArticolo().getId_articolo()}/commenti" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>