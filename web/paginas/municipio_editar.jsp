<%-- 
    Document   : municipio_registo
    Created on : 13-lug-2016, 19.09.43
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.modelo.*" %>
<%@page import="org.ao.projecto.dao.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Registar - Municipio</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">

            <%
                Municipio municipio = (Municipio) request.getAttribute("municipio");

                ProvinciaDAO provinciaDAO = new ProvinciaDAO();
                List<Provincia> provincias = provinciaDAO.findAll();

            %>        



            <div id="contentor">
                <div id="banner">
                    <a href="./index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">

                    <h3 style="text-align: center">Alterar - Municipio</h3>
                    <br/>


                    <form class="form-horizontal" role="form" action="./municipioServlet?comando=editar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Id:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="id_municipio" name="id_municipio" value="<%=municipio.getIdMunicipio()%>" readonly="readonly"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Município:</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="nome_municipio" name="nome_municipio" value="<%=municipio.getNomeMunicipio()%>"/>
                            </div>                   
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Provincia:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_funcionario_colocacao" name="select_provincia">
                                    <option selected="true" value="">Selecione um Funcionario</option>

                                    <% for (Provincia provincia : provincias) {%>
                                    <option value="<%=provincia.getIdProvincia()%>"><%=provincia.getNomeProvincia()%></option>
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
