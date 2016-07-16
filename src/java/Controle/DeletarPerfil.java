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
import java.util.List;
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
@WebServlet(name = "DeletarPerfil", urlPatterns = {"/DeletarPerfil"})
public class DeletarPerfil extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeletarPerfil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeletarPerfil at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        
        HttpSession sessao = request.getSession();
        int id = Integer.parseInt((String) sessao.getAttribute("sessaoUsuarioId"));
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> getAll = (List<Usuario>) dao.listar();
            for (Usuario cont : getAll) {
                if (id == cont.getIdUsuario()) {
                    dao.remover(usuario);
                    sessao.setAttribute("sessaoUsuarioNome", null);
                    sessao.setAttribute("sessaoUsuarioSenha", null);
                    sessao.setAttribute("sessaoUsuarioLogin", null);
                    sessao.setAttribute("sessaoUsuarioEmail", null);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            
            
            
            getServletContext().getRequestDispatcher("/cidades.jsp").forward(request, response);
            
        } catch (Exception e) {

        }
        
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
