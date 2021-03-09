
package es.iespuertodelacruz.jpexposito.modelo.jdbc.dao;

import es.iespuertodelacruz.jpexposito.exception.UsuarioExisteException;
import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpexposito
 */
public class UsuarioDao extends Conexion {
    
    String tabla = "Usuario";
    
    String sqlInsertar = "Insert into "+tabla+" values(?,?,?)";
    String sqlModificar = "Update "+tabla+"  set nombre='?', apellidos='?'"
            + " where dni='?'";
    String sqlTodos = "Select * from "+tabla+"";
    String sqlBuscar = "Select * from "+tabla+" where dni= ? ";
    String sqlEliminar = "Delete from "+tabla+" where dni= ? ";

    /**
     * Metoro que realiza la insercion dentro de la BBDD
     * @param usuario

     */
    public void insertar(Usuario usuario) throws UsuarioExisteException {

        try{
            PreparedStatement pstmt = null;
            pstmt = openConnectSQLite().prepareStatement(sqlInsertar);
            pstmt.setString(1,usuario.getDni());
            pstmt.setString(2,usuario.getNombre());
            pstmt.setString(3,usuario.getApellido());
            pstmt.executeUpdate();
           
        } catch (Exception e) {
            throw new UsuarioExisteException("El usuario con dni:"+ usuario.getDni() + ", existe en la BBDD");
        } finally {
            closeConnectSQLite();
        }  
    }
    
    public void modificar() {
        try {
            
        } catch (Exception e) {
            
        } finally {
            
        }
        
    }
    
    public void eliminar(String dni) {
        
        try{
            PreparedStatement pstmt = null;
            pstmt = openConnectSQLite().prepareStatement(sqlEliminar);
            pstmt.setString(1,dni);
            pstmt.execute();
        } catch (Exception e) {
            //Que se debe de hacer aqui?. Los system.out.println no sirven, que tengo que hacer???
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }  
        
    }
    
    public Usuario buscar(String dni) {
        ArrayList<Usuario> usuarios = null;
        try{
            PreparedStatement pstmt = null;
            pstmt = openConnectSQLite().prepareStatement(sqlBuscar);
            pstmt.setString(1,dni);
            ResultSet resultSet = pstmt.executeQuery();
            usuarios = resultSetToList(resultSet);
        } catch (Exception e) {
            //Que se debe de hacer aqui?. Los system.out.println no sirven, que tengo que hacer???
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }  
        if (usuarios != null && usuarios.size() > 0) {
            return usuarios.get(0);
        } else return null;
        
    }
    
    public ArrayList<Usuario> buscarTodos() {
        ArrayList<Usuario> usuarios = null;
        try{
            PreparedStatement pstmt = null;
            pstmt = openConnectSQLite().prepareStatement(sqlTodos);
            ResultSet resultSet = pstmt.executeQuery();
            usuarios = resultSetToList(resultSet);
        } catch (Exception e) {
            //Que se debe de hacer aqui?. Los system.out.println no sirven, que tengo que hacer???
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }
        
        //TODO: Que debería hacer aquí
        if (usuarios != null && usuarios.size() > 0) {
            return usuarios;
        } else return new ArrayList<Usuario>();
        
    }
    
    /**
     * Funcion que transforma un resultSet en una lista de usuarios
     * @param resultSet
     * @return
     */
    static ArrayList<Usuario> resultSetToList(ResultSet resultSet) {
        ArrayList <Usuario> usuarios = new ArrayList<>();

        try {
            while (resultSet.next()) {
                usuarios.add(new Usuario(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

        }
        return usuarios;
    }
    
    
}
