<%-- 
    Document   : tipo_projeto_registo
    Created on : 13-lug-2016, 19.10.29
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projeto.modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar tipo de projeto</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                TipoProjeto tipoProjeto = (TipoProjeto) request.getAttribute("tipoProjeto");
            %>
            <div id="contentor">
                <div id="banner">
                    <a href="./index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h3 style="text-align: center">Alterar de tipo de projeto</h3>
                    <br/>


                    <form class="form-horizontal" role="form" action="./tipoProjetoServlet?comando=editar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-5" >
                                <input type="date"  class="form-control" id="id_tipo_projeto" name="id_tipo_projeto" value="<%=tipoProjeto.getIdTipoProjeto()%>"  readonly="readonly"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Tipo:</label>
                            <div class="col-xs-5" >
                                <input type="date"  class="form-control" id="nome_tipo_projeto" name="nome_tipo_projeto" value="<%=tipoProjeto.getNomeTipoProjeto()%>"/>
                            </div>
                        </div>



                        <div class="col-md-4 col-md-offset-2">
                            <button type="submit" class="btn btn-primary" >Guardar</button>

                        </div>
                    </form>

                </div>
            </div>
          
        </div>

</html>
