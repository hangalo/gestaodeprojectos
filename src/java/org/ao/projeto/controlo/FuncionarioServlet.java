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
import org.ao.projeto.dao.FuncionarioDAO;
import org.ao.projeto.modelo.CategoriaFuncionario;
import org.ao.projeto.modelo.Departamento;
import org.ao.projeto.modelo.Funcionario;
import org.ao.projeto.modelo.Municipio;
import org.ao.projeto.modelo.Sexo;
import org.ao.projeto.util.DateUtil;

/**
 *
 * @author informatica
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        FuncionarioDAO funcionarioDAO;
        Funcionario funcionario = new Funcionario();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {

            try {
                String idFuncionario = request.getParameter("id_funcionario");
                if (idFuncionario != null) {
                    funcionario.setIdFuncionario(Integer.parseInt(idFuncionario));
                }

               

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            funcionarioDAO = new FuncionarioDAO();
          

            if (comando.equalsIgnoreCase("guardar")) {
                funcionario.setNomeFuncionario(request.getParameter("nome_funcionario"));
                funcionario.setSobrenomeFuncionario(request.getParameter("sobrenome_funcionario"));
                funcionario.setDataNascimentoFuncionario(DateUtil.strToDate(request.getParameter("data_nascimento")));
                funcionario.setSexo(Sexo.getAbreviatura(request.getParameter("sexo")));
                System.out.println("Valor Sexo"+funcionario.getSexo().getExtensao());
                funcionario.setCasaFuncionario(request.getParameter("casa_funcionario"));
                funcionario.setRuaFuncionario(request.getParameter("rua_funcionario"));
                funcionario.setBairroFuncionario(request.getParameter("bairro_funcionario"));
                funcionario.setDistritoFuncionario(request.getParameter("distrito_funcionario"));
                funcionario.setTelefoneUnitel(request.getParameter("telefone_unitel_funcionario"));
                funcionario.setTelefoneMovicel(request.getParameter("telefone_movicel_funcionario"));
                funcionario.setTelefoneFixo(request.getParameter("telefone_fixo_funcionario"));
                funcionario.setEmailPrincipal(request.getParameter("email_principal_funcionario"));
                funcionario.setEmailAlternativo(request.getParameter("email_alternativo_funcionario"));
                Departamento departamento = new Departamento();
                departamento.setIdDepartamento(Integer.parseInt(request.getParameter("select_departamento_funcionario")));
                funcionario.setDepartamento(departamento);
                CategoriaFuncionario categoriaFuncionario = new CategoriaFuncionario();
                categoriaFuncionario.setIdCategoria(Integer.parseInt(request.getParameter("select_categoria_funcionario")));
                funcionario.setCategoriaFuncionario(categoriaFuncionario);
                Municipio municipio = new Municipio();
                municipio.setIdMunicipio(Integer.parseInt(request.getParameter("select_municipio_funcionario")));
                funcionario.setMunicipio(municipio);
                funcionarioDAO.save(funcionario);
               response.sendRedirect("paginas/funcionario_guardar.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                
                
                
              
                funcionarioDAO.update(funcionario);
              response.sendRedirect("paginas/funcionario_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                funcionarioDAO.delete(funcionario);
                response.sendRedirect("paginas/funcionario_listar.jsp");
                
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                funcionario = funcionarioDAO.findById(funcionario.getIdFuncionario());
                request.setAttribute("funcionario", funcionario);
                RequestDispatcher rd = request.getRequestDispatcher("paginas/funcionario_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/funcionario_listar.jsp");
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
