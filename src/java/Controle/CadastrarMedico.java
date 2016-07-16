/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.DAO.MedicoDAO;
import Modelo.Medico;
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
@WebServlet(name = "CadastrarMedico", urlPatterns = {"/CadastrarMedico"})
public class CadastrarMedico extends HttpServlet {

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
            out.println("<title>Servlet CadastrarMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarMedico at " + request.getContextPath() + "</h1>");
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
        
        boolean existe = false;
        Medico medico = new Medico();
        String nome = request.getParameter("nome");
        String crm = request.getParameter("crm");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String email = request.getParameter("email");
        String convenio2 = request.getParameter("convenio");
        String clinica2 = request.getParameter("clinica");
        String site = request.getParameter("site");
        String cidade2 = request.getParameter("cidade");
        String especialidade2 = request.getParameter("especialidade");
        
        boolean convenio;
        boolean clinica;
        
        int cidade = Integer.parseInt(cidade2);
        int especialidade = Integer.parseInt(especialidade2);
        
        if(convenio2.equals("Sim")){
            convenio = true;
        } else {
            convenio = false;
        }
        
        if(clinica2.equals("Sim")){
            clinica = true;
        } else {
            clinica = false;
        }
        
        medico.setNome(nome);
        medico.setCrm(crm);
        medico.setEndereco(endereco);
        medico.setBairro(bairro);
        medico.setEmail(email);
        medico.setAtendePorConvenio(convenio);
        medico.setTemClinica(clinica);
        medico.setSite(site);
        medico.setCidade(cidade);
        medico.setEspecialidade(especialidade);
        
        try {
            MedicoDAO dao = new MedicoDAO();
            List<Medico> getAll = (List<Medico>) dao.listar();
            String crmComparar = crm.toUpperCase();
            for (Medico cont : getAll) {
                String crm2 = cont.getCrm().toUpperCase();
                if (crmComparar.equals(crm2)) {
                    existe = true;
                }
            }
            HttpSession sessao = request.getSession();
            
            
            if(existe == true){
                sessao.setAttribute("medicoExiste", "existe");
                getServletContext().getRequestDispatcher("/medicos.jsp").forward(request, response);
            } else {
                dao.inserir(medico);
                sessao.setAttribute("medicoExiste", "não existe");
                getServletContext().getRequestDispatcher("/medicos.jsp").forward(request, response);
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
