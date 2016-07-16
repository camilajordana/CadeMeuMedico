<%@page import="Modelo.Especialidade"%>
<%@page import="Modelo.DAO.EspecialidadeDAO"%>
<%@page import="Modelo.Cidade"%>
<%@page import="Modelo.DAO.CidadeDAO"%>
<%@page import="Modelo.Medico"%>
<%@page import="java.util.List"%>
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
                            <li class="active"><a href="#">Cadastrar médico</a></li>
                            <li><a href="listarMedicos.jsp">Ver médicos</a></li>
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
                <p>Cadastro de médicos</p>

                <form action="CadastrarMedico" method="POST">
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Nome</label>
                        <input type="name" name="nome" class="form-control" id="exampleInputEmail1" placeholder="Digite nome" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">CRM</label>
                        <input type="name" name="crm" class="form-control" id="exampleInputEmail1" placeholder="Digite CRM" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Endereço</label>
                        <input type="name" name="endereco" class="form-control" id="exampleInputEmail1" placeholder="Digite endereço" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Bairro</label>
                        <input type="name" name="bairro" class="form-control" id="exampleInputEmail1" placeholder="Digite bairro" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">E-mail</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Digite e-mail" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Atende por convênio</label>
                        <div class="radio">
                            <label>
                                <input type="radio" name="convenio" id="sim" value="sim" checked>
                                Sim
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="convenio" id="nao" value="nao">
                                Não
                            </label>
                        </div>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Tem clínica?</label>
                        <div class="radio">
                            <label>
                                <input type="radio" name="clinica" id="sim" value="sim" checked>
                                Sim
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="clinica" id="nao" value="nao">
                                Não
                            </label>
                        </div>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Site (URL)</label>
                        <input type="name" name="site" class="form-control" id="exampleInputEmail1" placeholder="Digite URL" required="">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Cidade</label>
                        <select name="cidade" id="cidade" class="form-control">
                            <%

                                CidadeDAO dao2 = new CidadeDAO();
                                List<Cidade> getAll2 = (List<Cidade>) dao2.listar();

                                for (Cidade c : getAll2) {

                            %>
                            <option value="<%=c.getIdCidade()%>"><%= c.getNome()%></option>
                            <%
                                }
                            %>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Especialidade</label>
                        <select name="especialidade" class="form-control">
                            <%
                                EspecialidadeDAO dao = new EspecialidadeDAO();
                                List<Especialidade> getAll = (List<Especialidade>) dao.listar();

                                for (Especialidade c : getAll) {

                            %>
                            <option value="<%=c.getIDEspecialidade()%>"> <%= c.getNome()%></option>
                            <%
                                }
                            %>
                        </select>
                    </fieldset>





                    <%
                        String valor = (String) sessao.getAttribute("medicoExiste");
                        if (valor.equals("existe")) {
                            sessao.setAttribute("medicoExiste", "nao");
                    %>
                    Médico já existe <br><br>
                    <%
                        }
                        if (valor.equals("não existe")) {
                            sessao.setAttribute("medicoExiste", "nao");
                    %>
                    Médico cadastrado!<br><br>
                    <%
                        }

                    %>


                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>

                <br>
                <hr>
                <br>





            </div>

        </div> <!-- /container -->



    </body>
</html>
