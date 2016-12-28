<%-- 
    Document   : categoria_funcionario_lista
    Created on : 13-lug-2016, 19.12.47
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projeto.dao.*" %>
<%@page import="org.ao.projeto.modelo.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Categorias</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>

    <body>
        <%

            CategoriaFuncionarioDAO categoriaFuncionarioDAO = new CategoriaFuncionarioDAO();

            List<CategoriaFuncionario> categorias = categoriaFuncionarioDAO.findAll();

        %>

        <div class="container">

            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>

                </div>

                <div id="conteudo">
                    <a href="categoria_funcionario_guardar.jsp" class="btn btn-info" role="button">Novo</a>

                    <h2>Lista  - Categorias de Funcionário</h2>


                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Categoria</th>
                                <th>Salario</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (CategoriaFuncionario categoria : categorias) {%>
                            <tr>
                                <td><%=categoria.getIdCategoria()%></td>
                                <td><%=categoria.getNomeCategoria()%></td>
                                <td><%=categoria.getSalarioCategoria()%></td>


                                <td><a href="../categoriaFuncionarioServlet?comando=prepara_editar&id_categoria_funcionario=<%=categoria.getIdCategoria()%>"><img src="../imagens/edit.png" /></a></td>
                                <td><a href="../categoriaFuncionarioServlet?comando=eliminar&id_categoria_funcionario=<%=categoria.getIdCategoria()%>"><img src="../imagens/delete.png" /></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div>
           
        </div>
    </body>
</html>
