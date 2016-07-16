<%@page import="Modelo.Especialidade"%>
<%@page import="Modelo.DAO.EspecialidadeDAO"%>
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
                        <a class="navbar-brand" href="#"><img src="imagens/logo.png" height="30" width="150"/></a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="login.jsp">Área administrativa</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">


                
                <h2>Consultas</h2>
                <small class="text-muted">Pesquise por médicos e especialidades</small>
                <br><br>
                
                <form action="Pesquisar" method="POST">
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Nome do médico</label>
                        <input type="name" name="nome" class="form-control" id="exampleInputEmail1" placeholder="Digite o nome do médico">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Qual a sua cidade?</label>
                        <select name="cidade" id="cidade" class="form-control">
                            <option value=""></option>
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
                            <option value=""></option>
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
                    <button type="submit" class="btn btn-primary">Pesquisar</button>
                </form>
                

            </div>

        </div> <!-- /container -->



    </body>
</html>
