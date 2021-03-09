package es.iespuertolacruz.rest.jpexposito.utils;

public class RestServiceUtils {
    public static final String ESTADO_SERVICIO  = "Estado servicio ";
    public static final String OK = " Ok";
    public static final String ERROR = " Error";
    public static final String ELEMENTO_EXISTE = " El elemento existe en la BBDD";
    public static final String JDBC_SQLITE_MEMORY_DB = "jdbc:sqlite::memory::ahorcado.db";
    public static final String DRIVER_SQLITE = "org.sqlite.JDBC";


    public static final String SQL_CREATE_USUARIOS = "CREATE TABLE IF NOT EXISTS" +
            " usuarios (email VARCHAR(255) not NULL, " +
            " nombre VARCHAR(255), " +
            " dni VARCHAR(9), " +
            " password VARCHAR(255), " +
            " PRIMARY KEY ( dni ))";

    public static final String SQL_INSERT_USUARIOS = "INSERT INTO usuarios " +
            "(nombre, password, dni, email) VALUES(?,?,?,?)";

    public static final String SQL_CREATE_PELICULAS = "CREATE TABLE IF NOT EXISTS" +
            " peliculas (titulo VARCHAR(255) not NULL, " +
            " anio INTEGER not NULL, " +
            " director String not NULL, " +
            " actores VARCHAR(255) not NULL, " +
            " poster VARCHAR(255) not NULL, " +
            " imagenes VARCHAR(255) not NULL, " +
            " PRIMARY KEY ( titulo ))";

    public static final String SQL_INSERT_PELICULA = "INSERT INTO peliculas (titulo, anio, director, actores," +
            "poster, imagenes) VALUES(?,?,?,?,?,?)";

    public static final String SQL_DELETE_PELICULA = "delete from peliculas where titulo= ?";
    public static final String SQL_SELECT_TODAS_PELICULA = "Select * from peliculas";
    public static final String SQL_SELECT_UNA_PELICULA = "Select * from peliculas where titulo= ?";

    public static final String SQL_CREATE_PARTIDAS = "CREATE TABLE IF NOT EXISTS" +
            " partida (nombre VARCHAR(255) not NULL, " +
            " ganadas INTEGER not NULL, " +
            " jugadas INTEGER not NULL, " +
            " dni VARCHAR(9), " +
            " PRIMARY KEY ( nombre ))";

    public static final String SQL_INSERT_PARTIDA = "INSERT INTO partidas (nombre, ganadas," +
            " dni, jugadas) VALUES(?,?,?,?,?)";

    public static final String SQL_DELETE_PARTIDA = "delete from partida where dni= ?";
    public static final String SQL_SELECT_TODAS_PARTIDA = "Select * from partida";
    public static final String SQL_SELECT_UNA_PARTIDA = "Select * from partida where titulo= ?";
    public static final String SQL_UPDATE_PARTIDA = "update partida set ganadas = ?, set jugadas = ? where dni= ?";



}