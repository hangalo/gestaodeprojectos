<%-- 
    Document   : projeto_registo
    Created on : 11-lug-2016, 23.46.24
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projeto.modelo.*" %>
<%@page import="org.ao.projeto.dao.*" %>
<%@page import="java.util.List" %>
<%@page import="org.ao.projeto.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar de Colocação em Projecto</title>
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
                    <h3 style="text-align: center">Ficha de Registo de Colocação</h3>
                    <br/>
                    <%

                        Colocacao colocacao = (Colocacao) request.getAttribute("colocacao");
                        ProjetoDAO projetoDAO = new ProjetoDAO();
                        List<Projeto> projetos = projetoDAO.findAll();
                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                        List<Funcionario> funcionarios = funcionarioDAO.findAll();

                    %>
                    <form class="form-horizontal" role="form" action="./colocacaoServlet?comando=editar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="id_colocacao" name="id_colocacao" value="<%=colocacao.getIdColocacao()%>" readonly="readonly"/>
                            </div>
                        </div>               


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Funcionario:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_funcionario_colocacao" name="select_funcionario_colocacao">
                                    <option selected="true" value="">Selecione um Funcionario</option>

                                    <% for (Funcionario funcionario : funcionarios) {%>
                                    <option value="<%=funcionario.getIdFuncionario()%>"><%=funcionario.getNomeFuncionario() + " " + funcionario.getSobrenomeFuncionario()%></option>
                                    <%
                                        }
                                    %>

                                </select>

                            </div>                 
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Projecto:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_projeto_colocacao" name="select_projeto_colocacao">
                                    <option selected="true" value="">Selecione um Projecto</option>

                                    <% for (Projeto projeto : projetos) {%>
                                    <option value="<%=projeto.getIdProjeto()%>"><%=projeto.getNomeProjeto()%></option>
                                    <%
                                        }
                                    %>

                                </select>

                            </div>                 
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Início:</label>
                            <div class="col-xs-5" >
                                <input type="date"  class="form-control" id="inicio_colocacao" name="inicio_colocacao" value="<%= DateUtil.formataData(colocacao.getDataInicio())%>" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Fim:</label>
                            <div class="col-xs-5" >
                                <input type="date"  class="form-control" id="fim_colocacao" name="fim_colocacao" value="<%= DateUtil.formataData(colocacao.getDataFim())%>"/>
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
