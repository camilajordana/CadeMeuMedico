package Modelo.DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    
    private Connection connection;

    public UsuarioDAO() throws SQLException {
        this.connection = Banco.getConexao();
    }
    
    
    public Collection listar() {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Usuario> lista = new ArrayList();
        String sql = "Select * from usuarios";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Usuario c = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    
    
   
    
    
    
    public void inserir(Usuario c) {
        Connection conn = Banco.getConexao();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO usuarios (nome, login, senha, email) values (?, ?, ?, ?);";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getLogin());
            pstmt.setString(3, c.getSenha());
            pstmt.setString(4, c.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, null, null, pstmt);
        }
    }
    
    
    public void alterar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update usuarios set nome = ?, login = ?, senha = ?, email = ? where IDUsuario = ?");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getLogin());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, usuario.getEmail());
        stmt.setInt(5, usuario.getIdUsuario());
        stmt.execute();
        stmt.close();
    }
    
    
    
    public void remover(Usuario usuario) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("delete from usuarios where IDUsuario = ?;");
        stmt.setInt(1, usuario.getIdUsuario());
        stmt.execute();
        stmt.close();
    }
    
    
    

}
