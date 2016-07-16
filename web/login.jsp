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
                            <li><a href="index.jsp">Consultas</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">


                <h3 class="text-center">
                    Área administrativa
                </h3>
                <form  action="Logar" method="POST" role="form">
                    <div class="form-group">

                        <label for="exampleInputEmail1">
                            Login
                        </label>
                        <input type="name" name="login" class="form-control" id="exampleInputEmail1" required="" />
                    </div>
                    <div class="form-group">

                        <label for="exampleInputPassword1">
                            Senha
                        </label>
                        <input type="password" name="senha" class="form-control" id="exampleInputPassword1" required="" />
                    </div>
                    
                    <div class="checkbox">

                    </div> 
                    <button type="submit" class="btn btn-default">
                        Entrar
                    </button>
                </form>

            </div>

        </div> <!-- /container -->



    </body>
</html>
