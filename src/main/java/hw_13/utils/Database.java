package hw_13.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=javaelementary";
    public static final String user = "postgres";
    public static final String password = "postgres";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
