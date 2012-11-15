<%
   if(session.getAttribute("usuario")==null){
       response.sendRedirect("login.jsp");
   }
%>