
<%@page import="Modelo.Cidade"%>
<%@page import="Modelo.DAO.CidadeDAO"%>
<%@page import="Modelo.Especialidade"%>
<%@page import="Modelo.DAO.EspecialidadeDAO"%>
<%@page import="Modelo.Medico"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
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

                <h2>Resultado da consulta</h2>
                <small class="text-muted">Abaixo segue a lista com o resultado da pesquisa</small>
                <br>
                <br>
                
                <table class="table table-hover">
                    <tr>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Site</th>
                        <th>Especialidade</th>
                        <th>Endereco</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Atende por convênio</th>
                        <th>Tem clínica</th>
                        
                    </tr>
                    
                    <%
                            List<Medico> lista = (List<Medico>)request.getAttribute("medicos");
                            for (Medico c : lista) {
                        %>
                    <tr>
                        
                        <td><%= c.getNome() %></td>
                        <td><%= c.getEmail()%></td>
                        <td><%= c.getSite() %></td>
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
                        <td><%= nomeEspecialidade %></td>
                        <td><%= c.getEndereco() %></td>
                        <td><%= c.getBairro() %></td>
                        <%
                            CidadeDAO daoCidade = new CidadeDAO();
                            List<Cidade> listaCidades = (List<Cidade>) daoCidade.listar();
                            String nomeCidade = null;
                            for (Cidade u : listaCidades) {
                                if(u.getIdCidade()== c.getCidade()){
                                    nomeCidade = u.getNome();
                                }
                            }
                        %>
                        
                        <td><%= nomeCidade %></td>
                        <%
                            String conv = "Sim";
                            boolean convenio = c.isAtendePorConvenio();
                            if(convenio == true){
                                conv = "Não";
                            }
                        %>
                        <td><%= conv %></td>
                        <%
                            String cli = "Sim";
                            boolean clinica = c.isTemClinica();
                            if(clinica == true){
                                cli = "Não";
                            }
                        %>
                        <td><%= cli %></td>
                        
                        
                    </tr>
                    
                        
                        
                        <%
                            }
                        %>
                    
                </table>
                
                
                

            </div>

        </div> <!-- /container -->



    </body>
</html>
