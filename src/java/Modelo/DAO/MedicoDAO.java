/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.DAO;

import static Modelo.DAO.Banco.getConexao;
import Modelo.Medico;
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

public class MedicoDAO {

    private Connection connection;

    public MedicoDAO() throws SQLException {
        this.connection = Banco.getConexao();
    }
    
    public void inserir(Medico c) {
        Connection conn = Banco.getConexao();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO medicos (crm, nome, endereco, bairro, email, atendePorConvenio, temClinica, webSiteBlog, IDCidade, IDEspecialidade) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getCrm());
            pstmt.setString(2, c.getNome());
            pstmt.setString(3, c.getEndereco());
            pstmt.setString(4, c.getBairro());
            pstmt.setString(5, c.getEmail());
            pstmt.setBoolean(6, c.isAtendePorConvenio());
            pstmt.setBoolean(7, c.isTemClinica());
            pstmt.setString(8, c.getSite());
            pstmt.setInt(9, c.getCidade());
            pstmt.setInt(10, c.getEspecialidade());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, null, null, pstmt);
        }
    }
    
    public Collection listar() {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "select * from medicos";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    public Collection pesquisarPorNome(String nome) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where nome LIKE '"+nome+"%';";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    
    
    
    
    public Collection pesquisarPorNomeECidade(String nome, int cidade) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where nome LIKE '"+nome+"%' and IDCidade = "+cidade+";";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    
    public Collection pesquisarCidadeEEsp(int cidade, int especialidade) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where IDCidade = "+cidade+" and IDEspecialidade = "+especialidade+";";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    public Collection pesquisarEsp(int especialidade) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where IDEspecialidade = "+especialidade+";";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    public Collection pesquisarCidade(int especialidade) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where IDCidade = "+especialidade+";";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
     public Collection pesquisarPorNomeECidadeEEsp(String nome, int cidade, int especialidade) {
        Connection conn = Banco.getConexao();
        ResultSet rs = null;
        Statement stmt = null;
        List<Medico> lista = new ArrayList();
        String sql = "Select * from medicos where nome LIKE '"+nome+"%' and IDCidade = "+cidade+" and IDEspecialidade = "+especialidade+";";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConexao(conn, rs, null, stmt);
        }
        return lista;
    }
    
    
   /*    public void alterar(Medico c) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update medicos set crm = ?, nome = ?, endereco = ?, bairro = ?, email = ?, atendePorConvenio = ?, temClinica = ?, webSiteBlog = ?, IDCidade = ?, IDEspecialidade = ? where IDMedico = ?;");
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, c.getCrm());
        stmt.setString(2, c.getNome());
        stmt.setString(3, c.getEndereco());
        stmt.setString(4, c.getBairro());
        stmt.setString(5, c.getEmail());
        stmt.setBoolean(6, c.isAtendePorConvenio());
        stmt.setBoolean(7, c.isTemClinica());
        stmt.setString(8, c.getSite());
        stmt.setInt(9, c.getCidade());
        stmt.setInt(10, c.getEspecialidade());
        stmt.setInt(11, c.getIdMedico());
        
        stmt.execute();
        stmt.close();
    }*/
    
      public void alterar(Medico c) throws SQLException {
        connection = getConexao();
        PreparedStatement stmt;
        String sql = "update medicos set crm = ?, nome = ?, endereco = ?, bairro = ?, email = ?, atendePorConvenio = ?, temClinica = ?, webSiteBlog = ?, IDCidade = ?, IDEspecialidade = ? where IDMedico = ?;";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getCrm());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getBairro());
            stmt.setString(5, c.getEmail());
            stmt.setBoolean(6, c.isAtendePorConvenio());
            stmt.setBoolean(7, c.isTemClinica());
            stmt.setString(8, c.getSite());
            stmt.setInt(9, c.getCidade());
            stmt.setInt(10, c.getEspecialidade());
            stmt.setInt(11, c.getIdMedico());
            
            
            stmt.executeUpdate();
            System.out.println("Dado atualizado com sucesso");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
