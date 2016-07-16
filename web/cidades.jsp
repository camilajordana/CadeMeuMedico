<%-- 
    Document   : cidades
    Created on : 11/07/2016, 08:02:07
    Author     : camila
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAO.CidadeDAO"%>
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
                            <li><a href="listarMedicos.jsp">Ver médicos</a></li>
                            <li><a href="especialidades.jsp">Especialidades</a></li>
                            <li class="active"><a href="#">Cidades</a></li>
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
                <h2>Gerenciamento de cidades</h2>
                <small class="text-muted">Área restrita aos administradores do sistema.</small>
                <br><br>
                <p>Cadastro de cidades</p>

                <form action="CadastrarCidade" method="POST">
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Cidade</label>
                        <input type="name" name="nome" class="form-control" id="exampleInputEmail1" placeholder="Digite cidade">
                    </fieldset>
                    
                    <%
                        String valor = (String)sessao.getAttribute("cidadeExiste");
                        if(valor.equals("existe")) { 
                            sessao.setAttribute("cidadeExiste", "nao");
                    %>
                    Cidade já existe <br><br>
                    <%
                        }
                        if(valor.equals("não existe")){
                            sessao.setAttribute("cidadeExiste", "nao");
                    %>
                    Cidade cadastrada!<br><br>
                    <%
                        }
                        
                    %>
                    
                    
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>

                <br>
                <hr>
                <br>
                
                <p>Cidades cadastradas</p>
                <br>
                <table class="table table-hover">
                    <tr>
                        <th>Cidade</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                    </tr>
                    <%
                        CidadeDAO dao = new CidadeDAO();
                        ArrayList<Cidade> lista = (ArrayList<Cidade>)dao.listar();
                        for(Cidade c : lista){
                    %>
                    <tr>
                        <td WIDTH="900"><%= c.getNome() %></td>
                        <td><a href="editarCidade.jsp?nome=<%= c.getNome() %>&id=<%= c.getIdCidade()%>"><img src="imagens/editar.png" width="20" height="20"></a></td>
                        <td><a href="DeletarCidade?id=<%= c.getIdCidade() %>"><img src="imagens/deletar.png" width="20" height="20"></a></td>
                    </tr>
                    <% } %>
                </table>
                
                

            </div>

        </div> <!-- /container -->


    </body>
</html>
