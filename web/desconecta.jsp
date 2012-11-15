<%
   }catch(Exception ex){
       System.out.println("error conectando :s");
   }finally{
       if(con!=null){
           con.close();
       }
   }
%>