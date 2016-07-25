<%-- 
    Document   : provincia_registo
    Created on : 13-lug-2016, 19.10.59
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar - Província</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">

            <%
                Provincia provincia = (Provincia) request.getAttribute("provincia");
            %>

            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">

                    <h3 style="text-align: center">Editar - Província</h3>
                    <br/>

                    <form class="form-horizontal" role="form" action="./provinciaServlet?comando=editar" method="POST">
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="id_provincia" name="id_provincia" value="<%=provincia.getIdProvincia()%>" readonly="readonly"/>
                            </div>                   
                        </div>



                        <div class="form-group">
                            <label class="col-xs-3 control-label">Nome:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_provincia" name="nome_provincia" value="<%=provincia.getNomeProvincia()%>"/>
                            </div>                   
                        </div>




                        <div class="col-md-4 col-md-offset-2">
                            <button type="submit" class="btn btn-primary" >Guardar</button>
                            <button type="reset" class="btn btn-primary" >Home</button>
                        </div>
                    </form>

                </div>
            </div>          
        </div>
    </body>
</html>
