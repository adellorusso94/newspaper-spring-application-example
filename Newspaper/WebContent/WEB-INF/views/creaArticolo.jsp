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
			if(document.creaForm.titolo.value=="") {
				alert("Inserire un titolo!");
				return false;
			}
			
			if(document.creaForm.testo.value=="") {
				alert("Inserire un testo!");
				return false;
			}
			
			if(confirm("Creare l'articolo?")) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</head>
<body>
	<div align="center">
		<h4>Crea Articolo</h4>
		<br>
		<form action="/SpringMVC/home/articoli/crea/invio" name="creaForm" method="post" onsubmit="return validaInvio();">
			<table border="1">
				<tbody>
					<tr>
						<th>
							Titolo
						</th>
						<td>
							<textarea id="titolo" name="titolo" rows="1" cols="100" maxlength="45"></textarea>
						</td>
					</tr>
					<tr>
						<th>
							Testo
						</th>
						<td>
							<textarea id="testo" name="testo" rows="50" cols="100" maxlength="4000"></textarea>
						</td>
					</tr>
					<tr>
						<th>
							Data
						</th>
						<td>
							<textarea id="data" name="data" rows="1" cols="100" readonly="readonly"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<input type="submit" value="Crea">
		</form>
	</div>
	<br>
	<div align="center">
		<form action="/SpringMVC/home/articoli/" method="get">
			<input type="submit" value="Indietro">
		</form>
	</div>
	<script>
		var d = new Date(),
		month = ("0" + (d.getMonth() + 1)).slice(-2),
		date = d.getDate(),
		year = d.getFullYear(),
		area = document.getElementsByTagName("textarea")[2];
		area.value = year + "-" + month + "-" + date;
	</script>
</body>
</html>