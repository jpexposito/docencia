package es.iespuertolacruz.rest.jpexposito.dao;

import es.iespuertolacruz.rest.jpexposito.dao.entity.Pelicula;
import es.iespuertolacruz.rest.jpexposito.dao.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.closeConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.openConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

public class UsuariosDao {

    /**
     * Metodo que permite insertar un usuario en la tabla Usuarios.
     * @param usuario
     */
    public static void insert(Usuario usuario) {

        try{
            Connection conn = openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT_USUARIOS);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getDni());
            pstmt.setString(4, usuario.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }


    /**
     * Metodo que permite listar todas las peliculas de la BBDD
     * @param titulo Nombre de la pelicula que se va a buscar;
     * @return
     */
    public static void delete(String titulo) {
        ArrayList <Pelicula> peliculas = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = openConnectSQLite();
            pstmt = conn.prepareStatement(SQL_DELETE_PELICULA);
            pstmt.setString(1, titulo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la operacion en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }

    }

    /**
     * Metodo que permite listar todas los usuario de la BBDD
     * @param dni Dni del usuario a buscar;
     * @return
     */
    public static ArrayList <Usuario> find(String dni) {
        ArrayList <Usuario> usuarios    = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = openConnectSQLite();
            if (dni == null) {
                pstmt = conn.prepareStatement(SQL_SELECT_TODAS_PELICULA);
            } else {
                pstmt = conn.prepareStatement(SQL_SELECT_UNA_PELICULA);
                pstmt.setString(1, dni);
            }
            ResultSet resultSet = pstmt.executeQuery();
            usuarios =  resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
        return usuarios;
    }

    /**
     * Funcion que transforma un resultSet en una lista de usuarios
     * @param resultSet
     * @return
     */
    static ArrayList<Usuario> resultSetToList(ResultSet resultSet) {
        ArrayList <Usuario> peliculas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                peliculas.add(new Usuario(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());
        }
        return peliculas;
    }

}
