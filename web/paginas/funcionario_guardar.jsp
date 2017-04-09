<%-- 
    Document   : funcionario_registo
    Created on : 13-lug-2016, 19.08.45
    Author     : informatica
--%>


<%@page import="org.ao.projeto.modelo.Sexo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.ao.projecto.modelo.*" %>
<%@page import="org.ao.projecto.dao.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registo de Colocação em Projecto</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">
        <link href="./css/layout_paginas.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%

                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                List<Departamento> departamentos = departamentoDAO.findAll();

                CategoriaFuncionarioDAO categoriaFuncionarioDAO = new CategoriaFuncionarioDAO();
                List<CategoriaFuncionario> categoriaFuncionarios = categoriaFuncionarioDAO.findAll();

                MunicipioDAO municipioDAO = new MunicipioDAO();
                List<Municipio> municipios = municipioDAO.findAll();

            %>

            <div id="contentor">
                <div id="banner">
                    <a href="../index.jsp" class="btn btn-info" role="button">Home</a>
                    <h1 style="text-align: center">Tchoto - Gestão de Projectos</h1>
                </div>

                <div id="conteudo">
                    <h3 style="text-align: center">Ficha de Registo de Colocação</h3>
                    <br/>


                    <form class="form-horizontal" role="form" action="../funcionarioServlet?comando=guardar" method="POST">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Nome:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="nome_funcionario" name="nome_funcionario" placeholder="Nome:"/>
                            </div>
                            <label class="col-xs-2 control-label">Sobrenome:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="sobrenome_funcionario" name="sobrenome_funcionario" placeholder="Sobrenome:"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Nascimento:</label>
                            <div class="col-xs-5" >
                                <input type="date"  class="form-control" id="data_nascimento" name="data_nascimento" placeholder="dd/MM/yyyy"/>
                            </div>
                        </div>




                        <div class="form-group">
                            <label class="col-xs-3 control-label">Sexo:</label>
                            <div class="col-xs-5" >

                                <% for (Sexo sexo : Sexo.values()) {%>
                                <input type="radio" name="sexo" value="<%=sexo.getAbreviatura()%>"><%=sexo.getExtensao()%>
                                <%
                                    }
                                %>
                            </div>                 
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">N.º Casa:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="casa_funcionario" name="casa_funcionario" placeholder="Nº Casa:"/>
                            </div>
                            <label class="col-xs-2 control-label">Rua:</label>
                            <div class="col-xs-4" >
                                <input type="text"  class="form-control" id="rua_funcionario" name="rua_funcionario" placeholder="Rua:"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Bairro:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="bairro_funcionario" name="bairro_funcionario" placeholder="Bairro:"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Distrito:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="distrito_funcionario" name="distrito_funcionario" placeholder="Distrito:"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Telefone Unitel:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="telefone_unitel_funcionario" name="telefone_unitel_funcionario" placeholder="Telefone da Unitel:"/>
                            </div>
                            <label class="col-xs-3 control-label">Telefone Movicel:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="telefone_movicel_funcionario" name="telefone_movicel_funcionario" placeholder="Telefone da Movicel:"/>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-xs-3 control-label">Telefone Fixo:</label>
                            <div class="col-xs-5" >
                                <input type="text"  class="form-control" id="telefone_fixo_funcionario" name="telefone_fixo_funcionario" placeholder="Telefone Fixo:"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Email principal:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="email_principal_funcionario" name="email_principal_funcionario" placeholder="Email Principal:"/>
                            </div>
                            <label class="col-xs-2 control-label">Email Alterntivo:</label>
                            <div class="col-xs-3" >
                                <input type="text"  class="form-control" id="email_alternativo_funcionario" name="email_alternativo_funcionario" placeholder="Email alternativo:"/>
                            </div>

                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Departamento:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_departamento_funcionario" name="select_departamento_funcionario">
                                    <option selected="true" value="">Selecione um Projecto</option>

                                    <% for (Departamento departamento : departamentos) {%>
                                    <option value="<%=departamento.getIdDepartamento()%>"><%=departamento.getNomeDepartamento()%></option>
                                    <%
                                        }
                                    %>
                                </select>

                            </div>                 
                        </div>



                        <div class="form-group">
                            <label class="col-xs-3 control-label">Categoria:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_categoria_funcionario" name="select_categoria_funcionario">
                                    <option selected="true" value="">Selecione um Projecto</option>

                                    <% for (CategoriaFuncionario categoria : categoriaFuncionarios) {%>
                                    <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNomeCategoria()%></option>
                                    <%
                                        }
                                    %>
                                </select>

                            </div>                 
                        </div>       


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Municipio:</label>
                            <div class="col-xs-5" >
                                <select class="form-control" id="select_municipio_funcionario" name="select_municipio_funcionario">
                                    <option selected="true" value="">Selecione um Projecto</option>

                                    <% for (Municipio municipio : municipios) {%>
                                    <option value="<%=municipio.getIdMunicipio()%>"><%=municipio.getNomeMunicipio()%></option>
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
