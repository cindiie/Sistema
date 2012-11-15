<%-- 
    Document   : index
    Created on : Nov 12, 2012, 6:15:41 PM
    Author     : davidblanco
--%>
<%@ include file= "../conecta.jsp"%> 
<%@ page import="java.util.ArrayList"%>

<jsp:useBean id="Usuario" scope="page" class="conexion.Usuarios"/>
<jsp:useBean id="UsuarioLista" scope="page" class="conexion.UsuariosLista"/>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../bootstrap/css/bootstrap-responsive.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema</title>
        <%
            String usuarioId = request.getParameter("usuarioId");
            
            if(usuarioId!=null){
                Usuario.setUsuarioId(usuarioId);
                Usuario.delete(con);
            }
        
            ArrayList<conexion.Usuarios> usuarios = UsuarioLista.getList(con);
        %>
    </head>
    <body>
        <h1>Lista de Usuario</h1>
        
        <table class="table table-bordered">
            <tr>
                <th>Accion</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Password</th>
            </tr>
        <%
            for(conexion.Usuarios usuario : usuarios){
        %>
            <tr>
                <td><i class="icon-pencil"></i> <i onclick="eliminar('<%=usuario.getUsuarioId()%>');" class="icon-remove"></i> </td>
                <td><%=usuario.getNombre() %></td>
                <td><%=usuario.getUsuario() %></td>
                <td><%=usuario.getPassword() %></td>
            </tr>
        <%
            }
        %>
        </table>
        
    </body>
    
    <script src='../js/jquery-1.8.2.min.js'></script>
    <script>
        function eliminar(usuarioId){
            if(confirm("Estas seguro que deseas eliminar este registro?")){
                location.href="eliminar.jsp?usuarioId="+usuarioId;
            }
        }
    </script>
</html>

<%@ include file= "../desconecta.jsp"%> 