package es.iespuertolacruz.rest.jpexposito.dao;

import es.iespuertolacruz.rest.jpexposito.dao.entity.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.closeConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.openConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

public class PeliculasDao {

    /**
     * Metodo que permite insertar una pelicula en la tabla Pelicula.
     * @param pelicula
     */
    public static void insert(Pelicula pelicula) {

        String sql = "INSERT INTO alumnos (dni, nombre, apellido, nota) VALUES(?,?,?,?)";

        try{
            Connection conn = openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT_PELICULA);
            pstmt.setString(1, pelicula.getTitulo());
            pstmt.setInt(2, pelicula.getAnio());
            pstmt.setString(3, pelicula.getDirector());
            pstmt.setString(4, pelicula.getActores());
            pstmt.setString(5, pelicula.getPoster());
            pstmt.setString(6, pelicula.getImagenes());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

    /**
     * Funcion que retorna una pelicula aleatoria de la BBDD
     * @return
     */
    public static Pelicula aleatorio() {
        Pelicula pelicula = null;
        ArrayList<Pelicula> peliculas = find(null);
        if (peliculas.size() > 0) {
            int aleatorio = (int) (Math.random()*peliculas.size());
            pelicula = peliculas.get(aleatorio);
        }
        return pelicula;
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
     * Metodo que permite listar todas las peliculas de la BBDD
     * @param titulo Nombre de la pelicula que se va a buscar;
     * @return
     */
    public static ArrayList <Pelicula> find(String titulo) {
        ArrayList <Pelicula> peliculas = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = openConnectSQLite();
            if (titulo == null) {
                pstmt = conn.prepareStatement(SQL_SELECT_TODAS_PELICULA);
            } else {
                pstmt = conn.prepareStatement(SQL_SELECT_UNA_PELICULA);
                pstmt.setString(1, titulo);
            }
            ResultSet resultSet = pstmt.executeQuery();
            peliculas =  resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
        return peliculas;
    }

    /**
     * Funcion que transforma un resultSet en una lista de alumnos
     * @param resultSet
     * @return
     */
    static ArrayList<Pelicula> resultSetToList(ResultSet resultSet) {
        ArrayList <Pelicula> peliculas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                peliculas.add(new Pelicula(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());
        }
        return peliculas;
    }

}
