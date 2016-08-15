/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.controlo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ao.projeto.dao.ProjetoDAO;
import org.ao.projeto.modelo.Projeto;
import org.ao.projeto.modelo.TipoProjeto;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProjetoServlet", urlPatterns = {"/projetoServlet"})
public class ProjetoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comando = request.getParameter("comando");
        
        if (comando == null) {
            comando = "principal";
        }
        
        ProjetoDAO projetoDAO;
        Projeto projeto = new Projeto();
        
        if (comando == null || !comando.equalsIgnoreCase("principal")) {
            
            try {
                String idProjeto = request.getParameter("id_projeto");
                if (idProjeto != null) {
                    projeto.setIdProjeto(Integer.parseInt(idProjeto));
                }
                
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }
        
        try {
            
            projetoDAO = new ProjetoDAO();
            if (comando.equalsIgnoreCase("guardar")) {
                projeto.setCodigoProjeto(request.getParameter("codigo_projeto"));
                projeto.setNomeProjeto(request.getParameter("nome_projeto"));
                projeto.setDescricaoProjeto(request.getParameter("descricao_projeto"));
                projeto.setCustoProjeto(Double.parseDouble(request.getParameter("curso_projeto")));
                projeto.setEntidadeFinanciadora(request.getParameter("financiador_projeto"));
                TipoProjeto tipoProjeto = new TipoProjeto();
                tipoProjeto.setIdTipoProjeto(Integer.parseInt(request.getParameter("select_tipo_projeto")));
                projeto.setTipoProjeto(tipoProjeto);
                projetoDAO.save(projeto);
                response.sendRedirect("paginas/projeto_guardar.jsp");
                
            } else if (comando.equalsIgnoreCase("editar")) {
                projetoDAO = new ProjetoDAO();
                projeto.setIdProjeto(Integer.parseInt(request.getParameter("id_projeto")));
                projeto.setCodigoProjeto(request.getParameter("codigo_projeto"));
                projeto.setNomeProjeto(request.getParameter("nome_projeto"));
                projeto.setDescricaoProjeto(request.getParameter("descricao_projeto"));
                projeto.setCustoProjeto(Double.parseDouble(request.getParameter("curso_projeto")));
                projeto.setEntidadeFinanciadora(request.getParameter("financiador_projeto"));
                TipoProjeto tipoProjeto = new TipoProjeto();
                tipoProjeto.setIdTipoProjeto(Integer.parseInt(request.getParameter("select_tipo_projeto")));
                projeto.setTipoProjeto(tipoProjeto);
                
                projetoDAO.update(projeto);
                System.out.println("Atualizado com sucesso");
                response.sendRedirect("paginas/projeto_listar.jsp");
                
            } else if (comando.equalsIgnoreCase("eliminar")) {
                projetoDAO.delete(projeto);
                response.sendRedirect("paginas/projeto_listar.jsp");
                
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                projeto = projetoDAO.findById(projeto.getIdProjeto());
                request.setAttribute("projeto", projeto);
                
                RequestDispatcher rd = request.getRequestDispatcher("paginas/projeto_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {
                
                response.sendRedirect("paginas/projeto_listar.jsp");
            } else if (comando.equalsIgnoreCase("principla")) {
                response.sendRedirect("/index.jsp");
            }
            
        } catch (IOException | ServletException ex) {
            System.err.println("Erro na leitura dos dados: " + ex.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
