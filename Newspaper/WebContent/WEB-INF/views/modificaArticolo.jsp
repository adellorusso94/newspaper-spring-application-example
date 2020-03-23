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
			if(document.modificaForm.titolo.value=="") {
				alert("Inserire un titolo!");
				return false;
			}
			
			if(document.modificaForm.testo.value=="") {
				alert("Inserire un testo!");
				return false;
			}
			
			if(confirm("Modificare l'articolo?")) {
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
		<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}/modifica/invio" name="modificaForm" method="post" onsubmit="return validaInvio();">
			<table>
				<tbody>
					<tr>
						<th>
							Titolo
						</th>
						<td>
							<textarea id="titolo" name="titolo" rows="1" cols="100" maxlength="45">${articolo.getTitolo()}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							Testo
						</th>
						<td>
							<textarea id="testo" name="testo" rows="50" cols="100" maxlength="4000">${articolo.getTesto()}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							Data
						</th>
						<td>
							<textarea id="data" name="data" rows="1" cols="100" readonly="readonly">${articolo.getData().toString().substring(0, 10)}</textarea>
						</td>
					</tr>
					<tr>
						<th>
							ID Autore
						</th>
						<td>
							<textarea id="id_autore" name="id_autore" rows="1" cols="100" readonly="readonly">${articolo.getAutore().getId_utente()}</textarea>
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
		<form action="/SpringMVC/home/articoli/${articolo.getId_articolo()}" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
</body>
</html>