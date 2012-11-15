<%
   if( session.getAttribute("usuario") != null){
       response.sendRedirect("index.jsp");
   }
%> 
<%-- 
    Document   : login
    Created on : Oct 8, 2012, 5:59:01 PM
    Author     : davidblanco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	
	<title>web site</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.min.css">
        <script src='js/jquery-1.8.2.min.js'></script>
</head>
<body>
	
<h2 class="titulo">Login</h2>
<form name="formulario" action="valida.jsp" method="get">
	
	<p>
		<label for="usuario">Usuario:</label>
		<input id="usuario" name="user" type="text">
	</p>

	<p>
		<label for="password">Password:</label>
		<input id="password" name="password" type="password">
	</p>

	<p>
		<input type="button" class="btn" onclick="revisar();" value="Entrar">
	</p>

</form>	

<script>
    
    function revisar(){
        var user = jQuery('#usuario').val();	
        var password = jQuery('#password').val();

        if(user == '' || password == ''){
              alert("Todos los campos son requeridos");
        }else{
              document.formulario.submit();
        }
    }

</script>

</body>
</html>