package Modelo.DAO;

import Modelo.Especialidade;
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

public class EspecialidadeDAO {

    private Connection connection;

    public EspecialidadeDAO() throws SQLException {
        this.connection = Banco.getConexao();
    }
    
    public void inserir(Especialidade c) {
        Connection conn = Banco.getConexao();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO especialidades (nome) values(?);";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getNome());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, null, null, pstmt);
        }
    }
    
    public void alterar(Especialidade especialidade) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update especialidades set nome = ? where IDEspecialidade = ?");
        stmt.setString(1, especialidade.getNome());
        stmt.setInt(2, especialidade.getIDEspecialidade());
        stmt.execute();
        stmt.close();
    }
    
     public void remover(Especialidade especialidade) throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("delete from especialidades where IDEspecialidade = ?;");
        stmt.setInt(1, especialidade.getIDEspecialidade());
        stmt.execute();
        stmt.close();
    }
    
    
     public Collection listar() {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Especialidade> lista = new ArrayList();
        String sql = "select * from especialidades";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Especialidade c = new Especialidade(rs.getInt(1), rs.getString(2));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
     
}
