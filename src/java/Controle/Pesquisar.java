/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.DAO.MedicoDAO;
import Modelo.DAO.UsuarioDAO;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camila
 */
@WebServlet(name = "Pesquisar", urlPatterns = {"/Pesquisar"})
public class Pesquisar extends HttpServlet {

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
            out.println("<title>Servlet Pesquisar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Pesquisar at " + request.getContextPath() + "</h1>");
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


        
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String especialidade = request.getParameter("especialidade");

        try {
            //Pesquisar só por nome
            if (!nome.equals("") && cidade.equals("") && especialidade.equals("")) {
                MedicoDAO dao = new MedicoDAO();
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarPorNome(nome);
                request.setAttribute("medicos", getAll2);  
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } else if(!nome.equals("") && !cidade.equals("") && especialidade.equals("")){
                MedicoDAO dao = new MedicoDAO();
                int c = Integer.parseInt(cidade);
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarPorNomeECidade(nome, c);
                request.setAttribute("medicos", getAll2); 
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } else if(!nome.equals("") && !cidade.equals("") && !especialidade.equals("")){
                MedicoDAO dao = new MedicoDAO();
                int c = Integer.parseInt(cidade);
                int e = Integer.parseInt(especialidade);
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarPorNomeECidadeEEsp(nome, c, e);
                request.setAttribute("medicos", getAll2); 
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } else if(nome.equals("") && !cidade.equals("") && !especialidade.equals("")){
                MedicoDAO dao = new MedicoDAO();
                int c = Integer.parseInt(cidade);
                int e = Integer.parseInt(especialidade);
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarCidadeEEsp(c, e);
                request.setAttribute("medicos", getAll2); 
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } else if(nome.equals("") && cidade.equals("") && !especialidade.equals("")){
                MedicoDAO dao = new MedicoDAO();
                int e = Integer.parseInt(especialidade);
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarEsp(e);
                request.setAttribute("medicos", getAll2); 
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } else if(nome.equals("") && !cidade.equals("") && especialidade.equals("")){
                MedicoDAO dao = new MedicoDAO();
                int c = Integer.parseInt(cidade);
                List<Medico> getAll2 = (List<Medico>) dao.pesquisarCidade(c);
                request.setAttribute("medicos", getAll2); 
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
            } 
            
            
            
        } catch (SQLException ex) {

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
