/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author davidblanco
 */
public class Usuarios {
    
    private String usuarioId;
    private String usuario;
    private String password;
    private String nombre;

    public Usuarios() {
        this.usuarioId  = "";
        this.usuario    = "";
        this.password   = "";
        this.nombre     = "";
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public boolean insert(Connection conn) throws Exception{
        boolean ok = false;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO USUARIOS(USUARIO, PASSWORD, NOMBRE) "
                    + " VALUES( ?, ?, ?) ");
            ps.setString(1, this.usuario);
            ps.setString(2, this.password);
            ps.setString(3, this.nombre);
            
            if( ps.executeUpdate() == 1){
                ok = true;
            }
            
        }catch(Exception ex){
            System.out.println("Error - conexion.Usuarios|insert|:"+ex);
        }finally{
            if (ps!=null){
                ps.close();
            }
        }
        return ok;
    }
    
    public boolean update(Connection conn) throws Exception{
        boolean ok = false;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE USUARIOS  "
                    + " SET USUARIO = ?, PASSWORD = ?, NOMBRE = ? WHERE USUARIO_ID = ? ");
            ps.setString(1, this.usuario);
            ps.setString(2, this.password);
            ps.setString(3, this.nombre);
            ps.setInt(4, Integer.parseInt(this.usuarioId));
            
            if( ps.executeUpdate() == 1){
                ok = true;
            }
        }catch(Exception ex){
            System.out.println("Error - conexion.Usuarios|update|:"+ex);
        }finally{
            if (ps!=null){
                ps.close();
            }
        }
        return ok;
    }
    
    public boolean delete(Connection conn) throws Exception{
        boolean ok = false;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM USUARIOS WHERE USUARIO_ID = ? ");
            ps.setInt(1, Integer.parseInt(this.usuarioId));
            
            if( ps.executeUpdate() == 1){
                ok = true;
            }
        }catch(Exception ex){
            System.out.println("Error - conexion.Usuarios|delete|:"+ex);
        }finally{
            if (ps!=null){
                ps.close();
            }
        }
        return ok;
    }
    
    public void selectReg(ResultSet rs) throws Exception{
            usuarioId 	= rs.getString("USUARIO_ID");
            usuario 	= rs.getString("USUARIO");
            password 	= rs.getString("PASSWORD");
            nombre 	= rs.getString("NOMBRE");
    }
    
    public void select(Connection con, String usuarioId) throws Exception{
            PreparedStatement   ps = null;
            ResultSet           rs = null;
            try{
                    ps = con.prepareStatement("SELECT USUARIO_ID, USUARIO, PASSWORD, NOMBRE FROM USUARIOS"
                            + " WHERE USUARIO_ID = ? "); 
                    ps.setInt(1,Integer.parseInt(usuarioId));
                    rs = ps.executeQuery();

                    if(rs.next()){
                        selectReg(rs);
                    }
            }catch(Exception ex){
                    System.out.println("Error - conexion.Usuarios|select|: "+ex);
            }finally{
                    if (rs!=null) {
                        rs.close();
                    }
                    if (ps!=null) {
                        ps.close();
                    }
            }
    }
    
    public void selectUsuario(Connection con, String usuario) throws Exception{
            PreparedStatement   ps = null;
            ResultSet           rs = null;
            try{
                    ps = con.prepareStatement("SELECT USUARIO_ID, USUARIO, PASSWORD, NOMBRE FROM USUARIOS"
                            + " WHERE USUARIO = ? "); 
                    ps.setString(1, usuario);
                    rs = ps.executeQuery();

                    if(rs.next()){
                        selectReg(rs);
                    }
            }catch(Exception ex){
                    System.out.println("Error - conexion.Usuarios|selectUsuario|: "+ex);
            }finally{
                    if (rs!=null) {
                        rs.close();
                    }
                    if (ps!=null) {
                        ps.close();
                    }
            }
    }
    
    
}
