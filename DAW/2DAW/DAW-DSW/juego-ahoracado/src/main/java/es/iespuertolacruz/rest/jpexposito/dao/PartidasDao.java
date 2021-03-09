package es.iespuertolacruz.rest.jpexposito.dao;

import es.iespuertolacruz.rest.jpexposito.dao.entity.Partida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.closeConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.openConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

public class PartidasDao {

    /**
     * Metodo que permite insertar una pelicula en la tabla Pelicula.
     * @param partida
     */
    public static void insert(Partida partida) {

        String sql = "INSERT INTO alumnos (dni, nombre, apellido, nota) VALUES(?,?,?,?)";

        try{
            Connection conn = openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT_PARTIDA);
            pstmt.setString(1, partida.getDni());
            pstmt.setInt(2, partida.getGanadas());
            pstmt.setInt(2, partida.getJugadas());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }


    /**
     * Metodo que permite listar todas las peliculas de la BBDD
     * @param dni Nombre de la pelicula que se va a buscar;
     * @return
     */
    public static void delete(String dni) {
        ArrayList <Partida> peliculas = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = openConnectSQLite();
            pstmt = conn.prepareStatement(SQL_DELETE_PARTIDA);
            pstmt.setString(1, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la operacion en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }

    }

    /**
     * Metodo que permite listar todas las peliculas de la BBDD
     * @param dni Nombre de la pelicula que se va a buscar;
     * @return Lista de partidas realizadas
     */
    public static ArrayList <Partida> find(String dni) {
        ArrayList <Partida> partidas = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = openConnectSQLite();
            if (dni == null) {
                pstmt = conn.prepareStatement(SQL_SELECT_TODAS_PARTIDA);
            } else {
                pstmt = conn.prepareStatement(SQL_SELECT_UNA_PARTIDA);
                pstmt.setString(1, dni);
            }
            ResultSet resultSet = pstmt.executeQuery();
            partidas =  resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
        return partidas;
    }

    /**
     * Funcion que transforma un resultSet en una lista de alumnos
     * @param resultSet
     * @return
     */
    static ArrayList<Partida> resultSetToList(ResultSet resultSet) {
        ArrayList <Partida> partidas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                partidas.add(new Partida(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());
        }
        return partidas;
    }

}
