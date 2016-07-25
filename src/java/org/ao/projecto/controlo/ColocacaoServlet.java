/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projecto.controlo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ao.projecto.dao.ColocacaoDAO;
import org.ao.projecto.modelo.Colocacao;
import org.ao.projecto.modelo.Funcionario;
import org.ao.projecto.modelo.Projeto;
import org.ao.projecto.util.DateUtil;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ColocacaoServlet", urlPatterns = {"/colocacaoServlet"})
public class ColocacaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        ColocacaoDAO colocacaoDAO;
        Colocacao colocacao = new Colocacao();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {

            try {
                String idColocacao = request.getParameter("id_colocacao");
                if (idColocacao != null) {
                    colocacao.setIdColocacao(Integer.parseInt(idColocacao));
                }
               
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            colocacaoDAO = new ColocacaoDAO();
          

            if (comando.equalsIgnoreCase("guardar")) {
                
               
                Projeto projecto = new Projeto();
                Funcionario funcionario = new Funcionario();
                projecto.setIdProjecto(Integer.parseInt(request.getParameter("select_projecto_colocacao")));
                funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("select_funcionario_colocacao")));
                colocacao.setProjecto(projecto);
                colocacao.setFuncionario(funcionario);
                colocacao.setDataInicio(DateUtil.strToDate(request.getParameter("inicio_colocacao")));
                colocacao.setDataFim(DateUtil.strToDate(request.getParameter("fim_colocacao")));
                colocacaoDAO.save(colocacao);
               response.sendRedirect("paginas/colocacao_guardar.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                Projeto projecto = new Projeto();
                Funcionario funcionario = new Funcionario();
                colocacao.setIdColocacao(Integer.parseInt(request.getParameter("id_colocacao")));
                projecto.setIdProjecto(Integer.parseInt(request.getParameter("select_projecto_colocacao")));
                funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("select_funcionario_colocacao")));
                colocacao.setProjecto(projecto);
                colocacao.setFuncionario(funcionario);
                colocacao.setDataInicio(DateUtil.strToDate(request.getParameter("inicio_colocacao")));
                colocacao.setDataFim(DateUtil.strToDate(request.getParameter("fim_colocacao")));
                colocacaoDAO.update(colocacao);
              response.sendRedirect("paginas/colocacao_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                colocacaoDAO.delete(colocacao);
              response.sendRedirect("paginas/colocacao_listar.jsp");
              
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                colocacao = colocacaoDAO.findById(colocacao.getIdColocacao());
                request.setAttribute("colocacao", colocacao);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/colocacao_editar.jsp");
                rd.forward(request, response);
                
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/colocacao_listar.jsp");
            } else if (comando.equalsIgnoreCase("principla")) {
                response.sendRedirect("/index.jsp");
            }
          
        } catch (IOException | ServletException ex) {
            System.err.println("Erro na leitura dos dados: " + ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
