
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
                            <li><a href="cidades.jsp">Cidades</a></li>
                            <li><a href="usuarios.jsp">Usuarios</a></li>
                          
                            
                            
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="#"><strong>${sessaoUsuarioNome}</strong></a></li>
                            <li><a href="Deslogar">Sair</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a p -->
            <div class="jumbotron">
                
                <h2>Informações pessoais</h2>
                <small class="text-muted">Área restrita ao dono dessa conta.</small>
                <br><br>
         
                
                
                <form action="editarPerfil.jsp" method="POST">
                    <p>Nome: ${sessaoUsuarioNome}</p>
                    <p>Login: ${sessaoUsuarioLogin}</p>
                    <p>E-mail: ${sessaoUsuarioEmail}</p>
                    
                    <button type="submit" class="btn btn-primary">Editar perfil</button>
                    <br><br>
                    <a href="DeletarPerfil">Deletar Perfil</a>
                    
                </form>
                
                


            </div>

        </div> <!-- /container -->



    </body>
</html>
