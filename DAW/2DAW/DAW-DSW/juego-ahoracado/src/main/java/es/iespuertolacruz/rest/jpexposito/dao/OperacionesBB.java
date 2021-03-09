package es.iespuertolacruz.rest.jpexposito.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.DRIVER_SQLITE;
import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.JDBC_SQLITE_MEMORY_DB;


public class OperacionesBB {
    static Connection conn = null;

    /**
     * Metodo que realiza la coneccion con la BBDD
     */
    public static Connection  openConnectSQLite() {
        try {
            if (conn != null && !conn.isClosed()) {
                return conn;
            }
            Class.forName(DRIVER_SQLITE);
            conn = DriverManager.getConnection(JDBC_SQLITE_MEMORY_DB);

        } catch (Exception exception) {
            System.out.println("Se ha producido un error realizando la coneccion con la BBDD:" +exception.getMessage());
        }
        return conn;
    }

    /**
     * Metodo que finaliza la coneccion con la BBDD
     */
    public static void closeConnectSQLite() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception exception) {
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD:" +exception.getMessage());

        }

    }
}
