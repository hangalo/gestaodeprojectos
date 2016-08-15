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
import org.ao.projeto.dao.MunicipioDAO;
import org.ao.projeto.modelo.Municipio;
import org.ao.projeto.modelo.Provincia;

/**
 *
 * @author informatica
 */
@WebServlet(name = "MunicipioServlet", urlPatterns = {"/municipioServlet"})
public class MunicipioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String comando = request.getParameter("comando");

        if (comando == null) {
            comando = "principal";
        }

        MunicipioDAO municipioDAO;
        Municipio municipio = new Municipio();

        if (comando == null || !comando.equalsIgnoreCase("principal")) {

            try {
                String idMunicipio = request.getParameter("id_municipio");
                if (idMunicipio != null) {
                    municipio.setIdMunicipio(Integer.parseInt(idMunicipio));
                }

              

            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter dado: " + ex.getMessage());
            }
        }

        try {

            municipioDAO = new MunicipioDAO();
       

            if (comando.equalsIgnoreCase("guardar")) {
                
                  municipio.setNomeMunicipio(request.getParameter("nome_municipio"));
                Provincia provincia = new Provincia();
                provincia.setIdProvincia(Integer.parseInt(request.getParameter("select_provincia")));
                municipio.setProvincia(provincia);
                
                municipioDAO.save(municipio);
                response.sendRedirect("paginas/municipio_guardar.jsp");
                
                } else if (comando.equalsIgnoreCase("editar")) {
                    
                municipio.setIdMunicipio(Integer.parseInt( request.getParameter("id_municipio")));
                
                municipio.setNomeMunicipio(request.getParameter("nome_municipio"));
                Provincia provincia = new Provincia();
                provincia.setIdProvincia(Integer.parseInt(request.getParameter("select_provincia")));
                municipio.setProvincia(provincia);
                municipioDAO.update(municipio);
                response.sendRedirect("paginas/municipio_listar.jsp");

            } else if (comando.equalsIgnoreCase("eliminar")) {
                municipioDAO.delete(municipio);
              
               response.sendRedirect("paginas/municipio_listar.jsp");
                
            } else if (comando.equalsIgnoreCase("prepara_editar")) {
                municipio = municipioDAO.findById(municipio.getIdMunicipio());
                request.setAttribute("municipio", municipio);
                          
                 RequestDispatcher rd = request.getRequestDispatcher("/paginas/municipio_editar.jsp");
                rd.forward(request, response);
            } else if (comando.equalsIgnoreCase("listar")) {

                response.sendRedirect("paginas/municipio_listar.jsp");
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
