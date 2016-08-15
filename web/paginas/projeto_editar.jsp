<%-- 
    Document   : projeto_registo
    Created on : 11-lug-2016, 23.46.24
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projeto.dao.*" %>
<%@page import="org.ao.projeto.modelo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Projecto</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">




            <%
                Projeto projeto = (Projeto) request.getAttribute("projeto");

                TipoProjetoDAO tipoProjetoDAO = new TipoProjetoDAO();
                List<TipoProjeto> tipoProjetos = tipoProjetoDAO.findAll();

            %>
            <div id="contentor">
                <div id="banner">
                    <a href="./index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h3 style="text-align: center">Editar Projecto</h3>
                    <br/>
                    <form class="form-horizontal" role="form" action="./projetoServlet?comando=editar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="id_projeto" name="id_projeto" value="<%=projeto.getIdProjeto()%>" readonly="readonly"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Código:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="codigo_projeto" name="codigo_projeto" value="<%=projeto.getCodigoProjeto()%>"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Nome:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_projeto" name="nome_projeto" value="<%=projeto.getNomeProjeto()%>"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Descrição:</label>
                            <div class="col-xs-8" >
                                <textarea class="form-control" rows="5" id="descricao_projeto" name="descricao_projeto" value="<%=projeto.getDescricaoProjeto()%>" ></textarea>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Custo:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="curso_projeto" name="curso_projeto" value="<%=projeto.getCustoProjeto()%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Financiador:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="financiador_projeto" name="financiador_projeto" value="<%=projeto.getEntidadeFinanciadora()%>"/>
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="col-xs-3 control-label">Tipo</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_tipo_projeto" name="select_tipo_projeto">
                                    <option selected="true" value="">Selecione um Funcionario</option>

                                    <% for (TipoProjeto tipoProjeto : tipoProjetos) {%>
                                    <option value="<%=tipoProjeto.getIdTipoProjeto()%>"><%=tipoProjeto.getNomeTipoProjeto()%></option>
                                    <%
                                        }
                                    %>


                                </select>

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
