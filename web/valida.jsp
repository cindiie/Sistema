
<%@ include file= "conecta.jsp"%> 

<jsp:useBean id="Usuario" scope="page" class="conexion.Usuarios"/>

<%

    String usuario = request.getParameter("user");// variable de usuario
    String password = request.getParameter("password");// variable de password
    
    Usuario.selectUsuario(con, usuario);
    
    if(!Usuario.getPassword().equals("") && Usuario.getPassword().equals(password)){//validar usuario
        session.setAttribute("usuario", usuario);//subir a session usuario
        
        response.sendRedirect("index.jsp");// mandar al sistema
    }else{
        response.sendRedirect("login.jsp");// regresar al login
    }
    
%>

<%@ include file= "desconecta.jsp"%> 