<%@ include file= "conecta.jsp"%> 
<%@ include file= "seguro.jsp"%> 

<jsp:useBean id="usuario" scope="page" class="conexion.Usuarios"/>

<%-- 
    Document   : index
    Created on : Oct 8, 2012, 5:46:10 PM
    Author     : davidblanco
--%>
<%

    //conexion.Usuarios usuario = new conexion.Usuarios();
    //usuario.setNombre("INVITADO");
    //usuario.setPassword("123");
    //usuario.setUsuario("guest");
    
    //usuario.insert(con);

    //conexion.Usuarios usuario = new conexion.Usuarios();
    //usuario.setUsuarioId("2");
    //usuario.setNombre("INVITADO");
    //usuario.setPassword("12345");
    //usuario.setUsuario("guest");
    
    //usuario.update(con);

    //conexion.Usuarios usuario = new conexion.Usuarios();
    //usuario.setUsuarioId("2");
    //usuario.delete(con);

    //conexion.Usuarios usuario = new conexion.Usuarios();
    //usuario.select(con, "1");
    
    //System.out.println(usuario.getNombre());
    //System.out.println(usuario.getPassword());
    //System.out.println(usuario.getUsuario());
    
%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.min.css">
        <title>Sistema</title>      
    </head>
    <body>
        <h1>Bienvenidos</h1>
        <p>
            <a href="usuarios">Usuarios</a>
        </p>
        <p>
            <a href="salir.jsp">salir</a>
        </p>
    </body>
    
    <script src='js/jquery-1.8.2.min.js'></script>
</html>


<%@ include file= "desconecta.jsp"%> 