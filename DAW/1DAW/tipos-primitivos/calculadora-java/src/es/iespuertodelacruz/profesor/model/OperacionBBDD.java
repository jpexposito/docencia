package es.iespuertodelacruz.profesor.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OperacionBBDD {
    

    public static void insert(double numero1, double numero2, char operador, double resultado) {
        
        String sql = "INSERT INTO auditoria (numero1, numero2, operador, resultado) VALUES(?,?,?,?)";

        try{
            Connection conn = ConecionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, numero1);
            pstmt.setDouble(2, numero2);
            pstmt.setString(3, String.valueOf(operador));
            pstmt.setDouble(4, resultado);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {

            ConecionInicioBBDD.closeConnectSQLite();
        }
    }
}
