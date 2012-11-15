/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author davidblanco
 */
public class Conecta {
    public Connection conn(){ 
            String connectString = "jdbc:postgresql://localhost:5432/taller/"; 
            String user = "postgres"; // usuario postgres
            String password = "postgres"; // password 
            Connection Conn = null;		
            try{
                //System.out.println("ACA postgres dir...");
                Class.forName("org.postgresql.Driver");// el nombre de nuestro driver Postgres.
                //Hacemos la conexion.
                Conn = DriverManager.getConnection(connectString, user, password);
            }catch(Exception e){
                    System.out.println("No es posible conectarse... Error - aca.conectar.Conectar|conPostgres|:");
                    e.printStackTrace();
            }		
            return Conn;
    }
}
