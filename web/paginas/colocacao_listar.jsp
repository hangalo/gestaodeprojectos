<%-- 
    Document   : colocacao_lista
    Created on : 13-lug-2016, 19.08.21
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.dao.*" %>
<%@page import="org.ao.projecto.modelo.*" %>
<%@page import="java.util.List" %>
<%@page import="java.text.*" %>
<%@page import="org.ao.projecto.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Categorias</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <link href="../css/layout_paginas.css" rel="stylesheet">
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

                    <a href="colocacao_guardar.jsp" class="btn btn-info" role="button">Nova Colocação</a>
                    <h2>Lista - Colocações</h2>
                    <%

                        ColocacaoDAO colocacaoDAO = new ColocacaoDAO();
                        List<Colocacao> colocacoes = colocacaoDAO.findAll();

                    %>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Projecto</th>
                                <th>Funcionário</th>
                                <th>Início</th>
                                <th>Fim</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (Colocacao colocacao : colocacoes) {%>
                            <tr>
                                <td><%=colocacao.getIdColocacao()%></td>
                                <td><%=colocacao.getProjecto()%></td>
                                <td><%=colocacao.getFuncionario()%></td>
                                <td><%=DateUtil.formataData(colocacao.getDataInicio())%></td>
                                <td><%=DateUtil.formataData(colocacao.getDataFim())%></td>


                                <td><a href="../colocacaoServlet?comando=prepara_editar&id_colocacao=<%=colocacao.getIdColocacao()%>"><img src="../imagens/edit.png" /></a></td>
                                <td><a href="../colocacaoServlet?comando=eliminar&id_colocacao=<%=colocacao.getIdColocacao()%>"><img src="../imagens/delete.png" /></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div> 

          
        </div>
    </body>
</html>
