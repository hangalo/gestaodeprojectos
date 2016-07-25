<%-- 
    Document   : menu_navegacao
    Created on : 13-lug-2016, 0.44.53
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu de Navegação</title>
    </head>
    <body>
        
        <fieldset>
            <legend>Operações</legend>
        <ul>
            <li> <a href="./paginas/projeto_listar.jsp" >Projetos</a></li>
            <li><a href="./paginas/colocacao_listar.jsp" >Colocações</a></li>
            <li><a href="./paginas/funcionario_listar.jsp" >Funcionarios</a></li>
         
        </ul>
        </fieldset>
        <fieldset>
            <legend>Administração</legend>
            <ul>
                <li><a href="./paginas/tipo_projeto_listar.jsp" >Tipo de projetos</a></li>
                <li><a href="./paginas/categoria_funcionario_listar.jsp" >Categoria de Funcionários</a></li>
                <li><a href="./paginas/departamento_listar.jsp" >Departamentos</a></li>
                <li><a href="./paginas/municipio_listar.jsp" >Municipios</a></li>
                <li><a href="./paginas/provincia_listar.jsp" >Provincias</a></li>
            </ul>
        </fieldset>
    </body>
</html>
