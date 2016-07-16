<%-- 
    Document   : editarEspecialidade
    Created on : 11/07/2016, 20:11:48
    Author     : camila
--%>

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
                            <li class="active"><a href="especialidades.jsp">Especialidades</a></li>
                            <li><a href="cidades.jsp">Cidades</a></li>
                            <li><a href="usuarios.jsp">Usuários</a></li>
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
                <h2>Gerenciamento de especialidades</h2>
                <small class="text-muted">Área restrita aos administradores do sistema.</small>
                <br><br>
                <p>Editar especialidade</p>

                <form action="AlterarEspecialidade" method="POST">
                    <fieldset class="form-group">
                        <label for="exampleInputEmail1">Especialidade</label>
                        <input type="name" name="nome" value="${param.nome}" class="form-control" id="exampleInputEmail1" placeholder="Digite cidade">
                         <input type="hidden" name="idEspecialidade" value="${param.id}"/>
                    </fieldset>
                    
                    <%
                        
                        sessao.setAttribute("especialidadeAntiga", "");
                        String valor = (String)sessao.getAttribute("especialidadeExiste");
                        if(valor.equals("existe")) { 
                            sessao.setAttribute("especialidadeExiste", "nao");
                    %>
                    Especialidade já existe <br><br>
                    <%
                        }
                        if(valor.equals("não existe")){
                            sessao.setAttribute("especialidadeExiste", "nao");
                    %>
                    Especialidade cadastrada!<br><br>
                    <%
                        }
                        
                    %>
                    
                    
                    <button type="submit" class="btn btn-primary">Editar</button>
                </form>

                
                
                
                

            </div>

        </div> <!-- /container -->


    </body>
</html>
