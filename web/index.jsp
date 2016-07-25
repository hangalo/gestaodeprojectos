<%-- 
    Document   : index
    Created on : 13-lug-2016, 0.46.25
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tchoto -  Gestão de Projectos</title>
        <link rel="stylesheet" href="css/layout_home.css" type="text/css"/>
    </head>
     <body>
        <div id="contentor">
             <div id="banner">
                <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
            </div>
            <div id="menu">
                <%@include file="menus/menu_navegacao.jsp" %>
                <img src="imagens/pensador.png" alt="O pensador"/>
            </div>
            <div id="conteudo">
                
                <img src="imagens/logo.jpg" alt="Logo entrada"/>
                    
                
            </div>
            <div id="rodape">
                <%@include file="menus/rodape.jsp" %> 
              
            </div>
        </div>
    </body>
</html>
