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
<script type="text/javascript">
function validaInvio() {
	if (document.reg.username.value=="") {
        alert("Inserire username");
        return false;
    }
	
	if (document.reg.password.value=="") {
        alert("Inserire password");
        return false;
    }
	
    if (document.reg.nome.value=="") {
        alert("Inserire nome");
        return false;
    }
    
    if (document.reg.cognome.value=="") {
		alert("Inserire cognome");
		return false;
	}
    
	if (document.reg.giornalista.value=="") {
		alert("Selezionare Tipo Utente");
		return false;
	}
}
</script>
<body>
	<div align="center">
		<h3>${message}</h3>
		<h4>Registrazione</h4>
		<form action="/SpringMVC/nuovo_utente" name="reg" method="post" onSubmit="return validaInvio();">
			<p><input name ="username" type="text" placeholder="username"></p>
			<p><input name ="password" type="password" placeholder="password"></p>
			<p><input name ="nome" type="text" placeholder="nome"></p>
			<p><input name ="cognome" type="text" placeholder="cognome"></p>
			<p><select name="giornalista">
				<option value="">Tipo Utente</option>
		 		<option value="0">Lettore</option>
		 		<option value="1">Giornalista</option>
			</select>
			</p>
			<p><input type="submit" value="Registrati"></p>
		</form>
		<form action="/SpringMVC/" method="get">
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>