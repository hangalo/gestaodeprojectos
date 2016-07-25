<%-- 
    Document   : categoria_funcionario_registo
    Created on : 13-lug-2016, 19.12.29
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.modelo.CategoriaFuncionario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Editar- Categoria de Funcionario</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">

            <div id="contentor">
                <div id="banner">
                    <a href="./index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h3 style="text-align: center">Editar - Categoria de Funcionário</h3>
                    <br/>

                    <%
                        CategoriaFuncionario categoriaFuncionario = (CategoriaFuncionario) request.getAttribute("categoriaFuncionario");

                    %>
                    <form class="form-horizontal" role="form" action="./categoriaFuncionarioServlet?comando=editar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="id_categoria_funcionario" name="id_categoria_funcionario" value="<%=categoriaFuncionario.getIdCategoria()%>" readonly="readonly"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Categoria:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_categoria_funcionario" name="nome_categoria_funcionario" value="<%=categoriaFuncionario.getNomeCategoria()%>"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Salário:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="salario_categoria_funcionario" name="salario_categoria_funcionario" value="<%=categoriaFuncionario.getSalarioCategoria()%>"/>
                            </div>                   
                        </div>


                        <div class="col-md-4 col-md-offset-2">
                            <button type="submit" class="btn btn-primary" >Atualizar</button>

                        </div>
                    </form>

                </div>

            </div>            

          
        </div>
    </body>
</html>
