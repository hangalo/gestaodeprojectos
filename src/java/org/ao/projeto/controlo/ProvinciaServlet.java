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
import org.ao.projeto.dao.ProvinciaDAO;
import org.ao.projeto.modelo.Provincia;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProvinciaServlet", urlPatterns = {"/provinciaServlet"})
public class ProvinciaServlet extends HttpServlet {

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

        ProvinciaDAO provinciaDAO;
        Provincia provincia = new Provincia();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {

            try {
                String idProvincia = request.getParameter("id_provincia");
                if (idProvincia != null) {
                    provincia.setIdProvincia(Integer.parseInt(idProvincia));
                }

            

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            provinciaDAO = new ProvinciaDAO();

            if (comando.equalsIgnoreCase("guardar")) {
               
                 provincia.setNomeProvincia(request.getParameter("nome_provincia"));
                provinciaDAO.save(provincia);
              response.sendRedirect("paginas/provincia_listar.jsp");

            } else if (comando.equalsIgnoreCase("editar")) {
                provincia.setIdProvincia(Integer.parseInt(request.getParameter("id_provincia")));
                provincia.setNomeProvincia(request.getParameter("nome_provincia"));
                provinciaDAO.update(provincia);
               response.sendRedirect("paginas/provincia_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                provinciaDAO.delete(provincia);
                 response.sendRedirect("paginas/provincia_listar.jsp");
                
            
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                provincia = provinciaDAO.findById(provincia.getIdProvincia());
                request.setAttribute("provincia", provincia);
                RequestDispatcher rd = request.getRequestDispatcher("/paginas/provincia_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/provincia_listar.jsp");
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
