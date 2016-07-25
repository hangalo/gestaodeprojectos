<%-- 
    Document   : projeto_lista
    Created on : 13-lug-2016, 19.07.45
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
        <title>Listar Projetos</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>

    <body>
        <div class="container">
            <%

                ProjetoDAO projetoDAO = new ProjetoDAO();
                List<Projeto> projetos = projetoDAO.findAll();

            %>



            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <a href="projeto_guardar.jsp" class="btn btn-info" role="button">Novo Projeto</a>
                    <h2>Lista - Projetos</h2>
                    <p><a href="../relatorioProjetoServlet?comando=imprimir_lista_projetos">Imprimir Lista de Projetos</a></p>
                    <table class=" table table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Codigo</th>
                                <th>Nome</th>
                                <th>Descrição</th>
                                <th>Custo</th>
                                <th>Financiador</th>
                                <th>Tipo</th>
                                <th colspan="2">Operações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%for (Projeto projeto : projetos) {%>
                            <tr>
                                <td><%=projeto.getIdProjecto()%></td>
                                <td><%=projeto.getCodigoProjecto()%></td>
                                <td><%=projeto.getNomeProjecto()%></td>
                                <td><%=projeto.getDescricaoProjecto()%></td>
                                <td><%=projeto.getCustoProjecto()%></td>
                                <td><%=projeto.getEntidadeFinanciadora()%></td>
                                <td><%=projeto.getTipoProjecto()%></td>

                                <td><a href="../projectoServlet?comando=prepara_editar&id_projeto=<%=projeto.getIdProjecto()%>"><img src="../imagens/edit.png" /></a></td>
                                <td><a href="../projectoServlet?comando=eliminar&id_projeto=<%=projeto.getIdProjecto()%>"><img src="../imagens/delete.png" /></a></td>
                                 <td><a href="../relatorioProjetoServlet?comando=imprimir_ficha_projeto&codigoProjeto=<%=projeto.getCodigoProjecto()%>"><img src="../imagens/print.png" /></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>

            </div>           

        </div>
    </body>
</html>
