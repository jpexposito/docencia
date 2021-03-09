package es.iespuertolacruz.rest.jpexposito.modelo.dao;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import es.iespuertolacruz.rest.jpexposito.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static es.iespuertolacruz.rest.jpexposito.modelo.dao.Conectar.*;


public class AlumnosDAO {


    private static void initBBDD() {
        crearTabla();
    }

    /**
     * Metodo encargado de realizar la inservicio de un alumno en la BBDD.
     * @param alumno
     */
    public static void insert(Alumno alumno) {
        initBBDD();
        String sql = "INSERT INTO alumnos (dni, nombre, apellido, nota) VALUES(?,?,?,?)";

        try{
            Connection conn = openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, alumno.getDni());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getApellidos());
            pstmt.setInt(4, alumno.getNota());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

    /**
     * Funcion encargada de realizar la busqueda de un alumno en la BBDD a traves de la clave primaria
     * @param dni
     * @return
     */
    public static Alumno find(String dni) {
        initBBDD();
        ArrayList<Alumno> alumnos = null;
        String sql = "Select * from alumnos where dni= ?";

        try{
            Connection conn = openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dni);

            ResultSet resultSet = pstmt.executeQuery();
            alumnos =  resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
        if (alumnos != null) {
            return alumnos.get(0);
        } else return null;
    }

    /**
     * Funcion que transforma un resultSet en una lista de alumnos
     * @param resultSet
     * @return
     */
    static ArrayList<Alumno> resultSetToList(ResultSet resultSet) {
        ArrayList <Alumno> alumnos = new ArrayList<>();

        try {
            while (resultSet.next()) {
                alumnos.add(new Alumno(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

        }


        return alumnos;
    }
}
