package es.iespuertolacruz.rest.jpexposito.dao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.Statement;

import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.closeConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.dao.OperacionesBB.openConnectSQLite;
import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

public class InitBBDDServletContextListener implements ServletContextListener{


    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Finalizando los servicios");
    }


    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Inicializando los servicios." +
                " Creando/Verificando la BBDB del juego de Ahorcado");
        crearTablaUsuarios();
        crearTablaPeliculas();
        crearTablaPartidas();
    }

    /**
     * Metodo que me permite crear la tabla Usuarios si no existe
     */
    public static void crearTablaUsuarios() {

        try{
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(SQL_CREATE_USUARIOS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

    /**
     * Metodo que me permite crear la tabla Peliculas si no existe
     */
    public static void crearTablaPeliculas() {

        try{
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(SQL_CREATE_PELICULAS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

    /**
     * Metodo que me permite crear la tabla Peliculas si no existe
     */
    public static void crearTablaPartidas() {

        try{
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(SQL_CREATE_PARTIDAS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }
}
