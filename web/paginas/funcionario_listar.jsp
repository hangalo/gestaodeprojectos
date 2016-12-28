<%-- 
    Document   : funcionario_lista
    Created on : 13-lug-2016, 19.08.56
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
        <title>Listar dos Funcionarios</title>

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
                <a href="funcionario_guardar.jsp" class="btn btn-info" role="button">Novo</a>
                 <h2>Lista - Funcionários</h2>
            <%

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                List<Funcionario> funcionarios = funcionarioDAO.findAll();

            %>
            <table class=" table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>Categoria</th>
                        <th>Departamento</th>
                        <th>Telefone Unitel</th>
                        <th>Telefone Movicel</th>
                        <th>Email</th>
                          <th colspan="2">Operações</th>


                    </tr>
                </thead>
                <tbody>
                    <%for (Funcionario funcionario : funcionarios) {%>
                    <tr>
                        <td><%=funcionario.getIdFuncionario()%></td>
                        <td><%=funcionario.getNomeFuncionario()%></td>
                        <td><%=funcionario.getSobrenomeFuncionario()%></td>
                        <td><%=funcionario.getCasaFuncionario()%></td>
                        <td><%=funcionario.getDepartamento()%></td>
                        <td><%=funcionario.getTelefoneUnitel()%></td>
                        <td><%=funcionario.getTelefoneMovicel()%></td>
                        <td><%=funcionario.getEmailPrincipal()%></td>

                        <td><a href="../funcionarioServlet?comando=prepara_editar&id_funcionario=<%=funcionario.getIdFuncionario()%>"><img src="../imagens/edit.png" /></a></td>
                        <td><a href="../funcionarioServlet?comando=eliminar&id_funcionario=<%=funcionario.getIdFuncionario()%>"><img src="../imagens/delete.png" /></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
               
            </div>
            
        </div>
            
          
           
        </div>
    </body>
</html>
