<%-- 
    Document   : categoria_funcionario_registo
    Created on : 13-lug-2016, 19.12.29
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Registar - Categoria de Funcionario</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
           
            <div id="contentor">
             <div id="banner">
                  <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
            </div>
            
            <div id="conteudo">
                <h3 style="text-align: center">Registar - Categoria de Funcionário</h3>
                    <br/>

                    <form class="form-horizontal" role="form" action="../categoriaFuncionarioServlet?comando=guardar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Categoria:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_categoria_funcionario" name="nome_categoria_funcionario"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Salário:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="salario_categoria_funcionario" name="salario_categoria_funcionario"/>
                            </div>                   
                        </div>


                        <div class="col-md-4 col-md-offset-2">
                            <button type="submit" class="btn btn-primary" >Guardar</button>

                        </div>
                    </form>
               
            </div>
            
        </div>
            
            
            
                    


                </div>

            

           
       
    </body>
</html>
