package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection con;
    private static DbConnection dbc;

    private DbConnection() {
        try {
            // Tải driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Kết nối đến cơ sở dữ liệu, điều chỉnh thông tin nếu cần
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4306/librarymanagement", "root", "long12507");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("JDBC driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect database");
        }
    }

    public static DbConnection getDatabaseConnection() {
        if (dbc == null) {
            dbc = new DbConnection();
        }
        return dbc;
    }

    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        // Kiểm tra kết nối
        DbConnection db = DbConnection.getDatabaseConnection();
        if (db.getConnection() != null) {
            System.out.println("Connected to the database successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
