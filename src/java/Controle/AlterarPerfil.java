/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.DAO.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author camila
 */
@WebServlet(name = "AlterarPerfil", urlPatterns = {"/AlterarPerfil"})
public class AlterarPerfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setIdUsuario(id);
        
        int teste = 0;
        String loginTeste = login.toUpperCase();
        HttpSession sessao = request.getSession();
            
        
        String nomesessao = (String) sessao.getAttribute("sessaoUsuarioNome");
        String loginsessao = (String) sessao.getAttribute("sessaoUsuarioLogin");
        int idsessao = Integer.parseInt((String) sessao.getAttribute("sessaoUsuarioId"));

        try {
            UsuarioDAO dao = new UsuarioDAO();
            
            if(!login.equals(loginsessao)){ // Se estiver alterando o login
            List<Usuario> getAll = (List<Usuario>) dao.listar();
            for (Usuario cont : getAll) {
                String t = cont.getLogin().toUpperCase();
                if(t.equals(loginTeste) && id !=cont.getIdUsuario()){
                    teste++;
                } 
            }
            
            if(teste >= 1){
                sessao.setAttribute("usuarioExiste", "existe");
                getServletContext().getRequestDispatcher("/editarPerfil.jsp").forward(request, response);
            } else {
                dao.alterar(usuario);
                sessao.setAttribute("sessaoUsuarioNome", nome);
                sessao.setAttribute("sessaoUsuarioSenha", senha);
                sessao.setAttribute("sessaoUsuarioLogin", login);
                sessao.setAttribute("sessaoUsuarioEmail", email);
                //sessao.setAttribute("sessaoUsuarioId", id);
                
                sessao.setAttribute("usuarioExiste", "não existe");
                getServletContext().getRequestDispatcher("/editarPerfil.jsp").forward(request, response);
            }
            
        } else {
            
            
                List<Usuario> getAll = (List<Usuario>) dao.listar();
            //int compararID = id;
            for (Usuario cont : getAll) {
                String t = cont.getLogin().toUpperCase();
                if(t.equals(loginTeste) && id ==cont.getIdUsuario()){
                    teste++;
                } 
            }
            
            
            
            
            if(teste > 1){
                sessao.setAttribute("usuarioExiste", "existe");
                getServletContext().getRequestDispatcher("/editarPerfil.jsp").forward(request, response);
            } else {
                dao.alterar(usuario);
                
                sessao.setAttribute("sessaoUsuarioNome", nome);
                sessao.setAttribute("sessaoUsuarioSenha", senha);
                sessao.setAttribute("sessaoUsuarioLogin", login);
                sessao.setAttribute("sessaoUsuarioEmail", email);
                //sessao.setAttribute("sessaoUsuarioId", id);
                
                sessao.setAttribute("usuarioExiste", "não existe");
                getServletContext().getRequestDispatcher("/editarPerfil.jsp").forward(request, response);
            }
            
                
        }
            
        } catch(SQLException ex){
            Logger.getLogger(AlterarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
