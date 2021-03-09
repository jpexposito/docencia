/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.modelo.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author jpexposito
 */
public class Conexion {
    
    boolean existeTabla = false;
    
    // Nombre de la driver/bbdd/usuario/pass
    public final String JDBC_SQLITE_MEMORY_DB = "jdbc:sqlite::memory::db";
    public Connection conectBBDD = null;

    /**
     * Metodo que realiza la coneccion con la BBDD
     */
    public  Connection  openConnectSQLite() {
        try {
            if (conectBBDD != null && !conectBBDD.isClosed()) {
                return conectBBDD;
            }
            conectBBDD = DriverManager.getConnection(JDBC_SQLITE_MEMORY_DB);
            //
            if (!existeTabla) {
                crearTabla(conectBBDD);
            }
            
            /**
             * Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://servidor:3306/database",
                 "usuario",
                "password");
                conexion.setAutoCommit(false); //Pregunta porque el autoComit -> false? if/else
             */

        } catch (Exception exception) {
            // Que se bede de hacer aqui?, cambia el codigo por el adecuado
            System.out.println("Se ha producido un error realizando la coneccion con la BBDD:" +exception.getMessage());
        }
        existeTabla = true;
        return conectBBDD;
    }

    /**
     * Metodo que finaliza la coneccion con la BBDD
     */
    public void closeConnectSQLite() {

        try {
            if (conectBBDD != null) {
                conectBBDD.close();
            }
        } catch (Exception exception) {
            // Que se bede de hacer aqui?, cambia el codigo por el adecuado
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD:" +exception.getMessage());

        }
        
    }

    /**
     * Metodo que me permite crear la tabla si no existe
     */
    public void crearTabla(Connection conn) {

        String sql = "CREATE TABLE IF NOT EXISTS usuario " +
                "(dni VARCHAR(9) not NULL, " +
                " nombre VARCHAR(255), " +
                " apellidos VARCHAR(255), " +
                " PRIMARY KEY ( dni ))";

        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            existeTabla = true;
        } catch (Exception e) {
            //Que se debe de hacer aqui?. Los system.out.println no sirven, que tengo que hacer???
            System.out.println(e.getMessage());
        } finally {
            //closeConnectSQLite();
        }
    }
    
}
