/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author davidblanco
 */
public class UsuariosLista {
    
    public ArrayList<Usuarios> getList(Connection conn) throws SQLException{
		
            ArrayList<Usuarios> lista           = new ArrayList<Usuarios>();
            Statement st 			= conn.createStatement();
            ResultSet rs 			= null;
            String comando                      = "";

            try{
                    comando = " SELECT * FROM USUARIOS "; 

                    rs = st.executeQuery(comando);
                    while (rs.next()){
                           Usuarios objeto = new Usuarios();
                           objeto.selectReg(rs);
                           
                           lista.add(objeto);
                    }

            }catch(Exception ex){
                    System.out.println("Error - conexion.UsuariosLista|getList|:"+ex);
            }finally{
                    if (rs!=null){
                        rs.close();
                    }
                    if (st!=null){
                        st.close();
                    }
            }
            return lista;
    }
    
}
