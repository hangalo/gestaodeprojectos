<%-- 
    Document   : provincia_lista
    Created on : 13-lug-2016, 19.10.48
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
        <title>Listar Provincias</title>

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>

    </head>

    <body>
        <div class="container">
            <%

                ProvinciaDAO provinciaDAO = new ProvinciaDAO();
                List<Provincia> provincias = provinciaDAO.findAll();

            %>



            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <a href="provincia_guardar.jsp" class="btn btn-info" role="button">Nova</a>
                    <h2>Lista - Provincias</h2>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th colspan="2">Operações</th>


                            </tr>
                        </thead>
                        <tbody>
                            <%for (Provincia provincia : provincias) {%>
                            <tr>
                                <td><%=provincia.getIdProvincia()%></td>
                                <td><%=provincia.getNomeProvincia()%></td>



                                <td><a href="../provinciaServlet?comando=prepara_editar&id_provincia=<%=provincia.getIdProvincia()%>"><img src="../imagens/edit.png" /></a></td>
                                <td><a href="../provinciaServlet?comando=eliminar&id_provincia=<%=provincia.getIdProvincia()%>"><img src="../imagens/delete.png" /></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>


                </div>

            </div>
        </div>
    </body>
</html>
