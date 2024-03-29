package sqliteDemo;

import java.sql.*;

public class DbOperations {
    private Connection con;

    public DbOperations(String dbUrl) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        this.con = DriverManager.getConnection(dbUrl);
    }

    public void insertData(String name, int age, String city) throws SQLException {
        String qry = "INSERT INTO users (NAME, AGE, CITY) VALUES (?, ?, ?)";
        try (PreparedStatement st = con.prepareStatement(qry)) {
            st.setString(1, name);
            st.setInt(2, age);
            st.setString(3, city);
            st.executeUpdate();
        }
    }

    public void updateData(int id, String name, int age, String city) throws SQLException {
        String qry = "UPDATE users SET NAME=?, AGE=?, CITY=? WHERE ID=?";
        try (PreparedStatement st = con.prepareStatement(qry)) {
            st.setString(1, name);
            st.setInt(2, age);
            st.setString(3, city);
            st.setInt(4, id);
            st.executeUpdate();
        }
    }

    public void deleteData(int id) throws SQLException {
        String qry = "DELETE FROM users WHERE ID=?";
        try (PreparedStatement st = con.prepareStatement(qry)) {
            st.setInt(1, id);
            st.executeUpdate();
        }
    }

    public ResultSet getAllData() throws SQLException {
        String qry = "SELECT ID, NAME, AGE, CITY FROM users";
        Statement stmt = con.createStatement();
        return stmt.executeQuery(qry);
    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}
