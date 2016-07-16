package Modelo.DAO;

import Modelo.Cidade;
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

public class CidadeDAO {
    
    
    private Connection connection;

    public CidadeDAO() throws SQLException {
        this.connection = Banco.getConexao();
    }
    

    public void inserir(Cidade c) {
        Connection conn = Banco.getConexao();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO cidades (nome) values(?);";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getNome());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, null, null, pstmt);
        }
    }
    
    
    public void alterarLivro(Cidade cidade) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update cidades set nome = ? where IDCidade = ?");
        stmt.setString(1, cidade.getNome());
        stmt.setInt(2, cidade.getIdCidade());
        stmt.execute();
        stmt.close();
    }
    
    
    public void remover(Cidade cidade) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("delete from cidades where IDCidade = ?;");
        stmt.setInt(1, cidade.getIdCidade());
        stmt.execute();
        stmt.close();
    }
    
    
    
    public Collection listar() {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Cidade> lista = new ArrayList();
        String sql = "select * from cidades";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cidade c = new Cidade(rs.getInt(1), rs.getString(2));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }

}
