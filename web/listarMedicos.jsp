<%-- 
    Document   : listarMedicos
    Created on : 12/07/2016, 02:15:52
    Author     : camila
--%>

<%@page import="Modelo.Especialidade"%>
<%@page import="Modelo.DAO.EspecialidadeDAO"%>
<%@page import="Modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAO.CidadeDAO"%>
<%@page import="Modelo.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.DAO.MedicoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Cadê meu médico?</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        
        <%
            HttpSession sessao = request.getSession();
            String valor2 = (String)sessao.getAttribute("sessaoUsuarioNome");
            if(valor2 == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>
        
        
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="inicioAdm.jsp"><img src="imagens/logo.png" height="30" width="150"/></a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="inicioAdm.jsp">Início</a></li>
                            <li><a href="medicos.jsp">Cadastrar médico</a></li>
                            <li class="active"><a href="#">Ver médicos</a></li>
                            <li><a href="especialidades.jsp">Especialidades</a></li>
                            <li><a href="cidades.jsp">Cidades</a></li>
                            <li><a href="usuarios.jsp">Usuarios</a></li>
                          
                            
                            
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="perfil.jsp"><strong>${sessaoUsuarioNome}</strong></a></li>
                            <li><a href="Deslogar">Sair</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <h2>Gerenciamento de médicos</h2>
                <small class="text-muted">Área restrita aos administradores do sistema.</small>
                <br><br>
                
                <p>Médicos cadastrados</p>
                <br>
                <table class="table table-hover">
                    <tr>
                        <th>Nome</th>
                        <th>CRM</th>
                        <th>Endereço</th>
                        <th>Bairro</th>
                        <th>E-mail</th>
                        <th>Convenio</th>
                        <th>Clínica</th>
                        <th>Site</th>
                        <th>Cidade</th>
                        <th>Especialidade</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                    </tr>
                    <%
                        MedicoDAO dao = new MedicoDAO();
                        ArrayList<Medico> lista = (ArrayList<Medico>)dao.listar();
                        for(Medico c : lista){
                    %>
                    <tr>
                        <td><%= c.getNome() %></td>
                        <td><%= c.getCrm()%></td>
                        <td><%= c.getEndereco()%></td>
                        <td><%= c.getBairro()%></td>
                        <td><%= c.getEmail()%></td>
                        <%
                        String convenio = "Sim";
                            if(c.isAtendePorConvenio() == true){
                                convenio = "Não";
                            }
                        String clinica = "Sim";
                            if(c.isTemClinica() == true){
                                clinica = "Não";
                            }
                                
                        %>
                        <td><%=convenio%></td>
                        <td><%=clinica%></td>
                        <td><%=c.getSite() %></td>
                        <%
                            CidadeDAO daoCidade = new CidadeDAO();
                            List<Cidade> listaCidades = (List<Cidade>) daoCidade.listar();
                            String nomeCidade = null;
                            for (Cidade u : listaCidades) {
                                if(u.getIdCidade() == c.getCidade()){
                                    nomeCidade = u.getNome();
                                }
                            }
                        %>
                        <td><%=nomeCidade%></td>
                        <%
                            EspecialidadeDAO daoEspecialidade = new EspecialidadeDAO();
                            List<Especialidade> listaEspecialidades = (List<Especialidade>) daoEspecialidade.listar();
                            String nomeEspecialidade = null;
                            for (Especialidade u : listaEspecialidades) {
                                if(u.getIDEspecialidade() == c.getEspecialidade()){
                                    nomeEspecialidade = u.getNome();
                                }
                            }
                        %>
                        <td><%=nomeEspecialidade%></td>
                        <td><a href="editarMedico.jsp?nome=<%= c.getNome() %>&crm=<%= c.getCrm()%>&endereco=<%= c.getEndereco()%>&bairro=<%= c.getBairro() %>&email=<%= c.getEmail() %>&convenio=<%= c.isAtendePorConvenio() %>&clinica=<%= c.isTemClinica() %>&site=<%= c.getSite() %>&cidade=<%= c.getCidade() %>&especialidade=<%= c.getEspecialidade() %>&id=<%= c.getIdMedico() %>"><img src="imagens/editar.png" width="20" height="20"></a></td>
                        <td><a href="DeletarMedico?id=<%= c.getIdMedico() %>"><img src="imagens/deletar.png" width="20" height="20"></a></td>
                    </tr>
                    <% } %>
                </table>



            </div>

        </div> <!-- /container -->
    </body>
</html>
