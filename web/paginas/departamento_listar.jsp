<%-- 
    Document   : departamento_lista
    Created on : 13-lug-2016, 19.11.17
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
        <title>Listar Categorias</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>

    <body>
        <div class="container">
            <%

                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                List<Departamento> departamentos = departamentoDAO.findAll();

            %>



            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h2>Lista - Departamentos</h2>

                    <a href="departamento_guardar.jsp" class="btn btn-info" role="button">Novo</a>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Departamento</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (Departamento departamento : departamentos) {%>
                            <tr>
                                <td><%=departamento.getIdDepartamento()%></td>
                                <td><%=departamento.getNomeDepartamento()%></td>



                                <td><a href="../departamentoServlet?comando=prepara_editar&id_departamento=<%=departamento.getIdDepartamento()%>"><img src="../imagens/edit.png" /></a></td>
                                <td><a href="../departamentoServlet?comando=eliminar&id_departamento=<%=departamento.getIdDepartamento()%>"><img src="../imagens/delete.png" /></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div>


        </div>
    </body>
</html>
