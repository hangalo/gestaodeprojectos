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
import org.ao.projeto.dao.CategoriaFuncionarioDAO;
import org.ao.projeto.modelo.CategoriaFuncionario;

@WebServlet(name = "CategoriaFuncionarioServlet", urlPatterns = {"/categoriaFuncionarioServlet"})
public class CategoriaFuncionarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }
        CategoriaFuncionarioDAO categoriaFuncionarioDAO;
        CategoriaFuncionario categoriaFuncionario = new CategoriaFuncionario();
        if (comando == null || !comando.equalsIgnoreCase("principal")) {

            try {
                String idCategoria = request.getParameter("id_categoria_funcionario");
                if (idCategoria != null) {
                    categoriaFuncionario.setIdCategoria(Integer.parseInt(idCategoria));
                }
              
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            categoriaFuncionarioDAO = new CategoriaFuncionarioDAO();

            if (comando.equalsIgnoreCase("guardar")) {
                categoriaFuncionario.setNomeCategoria(request.getParameter("nome_categoria_funcionario"));
                categoriaFuncionario.setSalarioCategoria(Double.parseDouble(request.getParameter("salario_categoria_funcionario")));
                categoriaFuncionarioDAO.save(categoriaFuncionario);
                response.sendRedirect("paginas/categoria_funcionario_guardar.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                categoriaFuncionario.setIdCategoria(Integer.parseInt(request.getParameter("id_categoria_funcionario")));
                categoriaFuncionario.setNomeCategoria(request.getParameter("nome_categoria_funcionario"));
                categoriaFuncionario.setSalarioCategoria(Double.parseDouble(request.getParameter("salario_categoria_funcionario")));

                categoriaFuncionarioDAO.update(categoriaFuncionario);
                response.sendRedirect("paginas/categoria_funcionario_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                categoriaFuncionarioDAO.delete(categoriaFuncionario);
                response.sendRedirect("paginas/categoria_funcionario_listar.jsp");
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                categoriaFuncionario = categoriaFuncionarioDAO.findById(categoriaFuncionario.getIdCategoria());
                request.setAttribute("categoriaFuncionario", categoriaFuncionario);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/categoria_funcionario_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/categoria_funcionario_listar.jsp");
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
