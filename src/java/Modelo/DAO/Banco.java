package Modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
    
    public static Connection conn = null;

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Projeto_BD", "root", "camila");
        } catch (ClassNotFoundException exc) {
            System.out.println("Error ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Problemas ao abrir a conexao com o banco");
        }
        return conn;
    }

    public static void closeConexao(Connection conn, ResultSet rs, PreparedStatement pstmt, Statement stmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    
}
