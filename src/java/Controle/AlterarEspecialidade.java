/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.DAO.EspecialidadeDAO;
import Modelo.Especialidade;
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
@WebServlet(name = "AlterarEspecialidade", urlPatterns = {"/AlterarEspecialidade"})
public class AlterarEspecialidade extends HttpServlet {

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
            out.println("<title>Servlet AlterarEspecialidade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarEspecialidade at " + request.getContextPath() + "</h1>");
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
        
        int teste = 0;
        Especialidade especialidade = new Especialidade();
        String nome = request.getParameter("nome");
        int id = Integer.parseInt(request.getParameter("idEspecialidade"));
        especialidade.setNome(nome);
        especialidade.setIDEspecialidade(id);
        
        try {
            EspecialidadeDAO dao = new EspecialidadeDAO();
            List<Especialidade> getAll = (List<Especialidade>) dao.listar();
            String nomeComparar = nome.toUpperCase();
            for (Especialidade cont : getAll) {
                String nome2 = cont.getNome().toUpperCase();
                if (nomeComparar.equals(nome2)) {
                    teste++;
                }
            }
            HttpSession sessao = request.getSession();
            
            
            if(teste > 1){
                sessao.setAttribute("especialidadeExiste", "existe");
                getServletContext().getRequestDispatcher("/especialidades.jsp").forward(request, response);
            } else {
                dao.alterar(especialidade);
                sessao.setAttribute("especialidadeExiste", "não existe");
                getServletContext().getRequestDispatcher("/especialidades.jsp").forward(request, response);
            }
            
        } catch (Exception e) {

        }
        
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
