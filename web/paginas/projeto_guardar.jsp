<%-- 
    Document   : projecto_registo
    Created on : 11-lug-2016, 23.46.24
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.dao.*" %>
<%@page import="org.ao.projecto.modelo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registo de Novo Projecto</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="../css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                TipoProjetoDAO tipoProjetoDAO = new TipoProjetoDAO();
                List<TipoProjeto> tipoProjetos = tipoProjetoDAO.findAll();

            %>

            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h3 style="text-align: center">Ficha de Registo de Novo Projecto</h3>
                    <br/>


                    <form class="form-horizontal" role="form" action="../projectoServlet?comando=guardar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Código:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="codigo_projecto" name="codigo_projecto"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Nome:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_projecto" name="nome_projecto"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Descrição:</label>
                            <div class="col-xs-8" >
                                <textarea class="form-control" rows="5" id="descricao_projecto" name="descricao_projecto"></textarea>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Custo:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="curso_projecto" name="curso_projecto"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Financiador:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="financiador_projecto" name="financiador_projecto"/>
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="col-xs-3 control-label">Tipo</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_tipo_projecto" name="select_tipo_projecto">
                                    <option selected="true" value="">Selecione um Funcionario</option>

                                    <% for (TipoProjeto tipoProjeto : tipoProjetos) {%>
                                    <option value="<%=tipoProjeto.getIdTipoProjecto()%>"><%=tipoProjeto.getNomeTipoProjecto()%></option>
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
