<%-- 
    Document   : municipio_lista
    Created on : 13-lug-2016, 19.09.30
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.dao.*" %>
<%@page import="org.ao.projecto.modelo.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Municipios</title>

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>

    <body>
        <div class="container">

            <%

                MunicipioDAO municipioDAO = new MunicipioDAO();
                List<Municipio> municipios = municipioDAO.findAll();

            %>




            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <a href="municipio_guardar.jsp" class="btn btn-info" role="button">Novo</a>
                    <h2>Lista - Municípios</h2>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Município</th>
                                <th>Provincia</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (Municipio municipio : municipios) {%>
                            <tr>
                                <td><%=municipio.getIdMunicipio()%></td>
                                <td><%=municipio.getNomeMunicipio()%></td>
                                <td><%=municipio.getProvincia()%></td>



                                <td><a href="../municipioServlet?comando=prepara_editar&id_municipio=<%=municipio.getIdMunicipio()%>"><img src="../imagens/edit.png"/></a></td>
                                <td><a href="../municipioServlet?comando=eliminar&id_municipio=<%=municipio.getIdMunicipio()%>"><img src="../imagens/delete.png"/></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div>

            
        </div>
    </body>
</html>
