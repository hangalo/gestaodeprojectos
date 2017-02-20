/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.controlo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ao.projeto.dao.ProjetoDAO;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProjectoServletVisualizaImagemBinaria", urlPatterns = {"/projectoServletVisualizaImagemBinaria/*"})
public class ProjectoServletVisualizaImagemBinaria extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("image/jpg; image/png");
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
      

        int idImagem = Integer.parseInt(request.getParameter("idImagem"));
        System.out.println(">>>>>>>>>>"+idImagem);

        byte[] imagem = projetoDAO.recuperarImagem(idImagem);

        if (imagem == null) {
            imagem = carregarImagemPadrao();
        }
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imagem);
        outputStream.flush();
         /*
        BufferedInputStream input = null;
        BufferedOutputStream output= null;
        
        try{
        input = new BufferedInputStream(new ByteArrayInputStream(imagem));
        output = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[8192];
        int length;
        while((length = input.read(buffer))>0){
        output.write(buffer, 0, length);
        }
        
        }catch(IOException ex){
            System.out.println("Erro ao ler e escrever as imagens");
        }finally{
        if(output!=null)
            try{
            output.close();
            }catch(IOException ignore){
            }
        if(input !=null)
             try{
            input.close();
            }catch(IOException ignore){
            }
        
        }*/
        
        
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

    private byte[] carregarImagemPadrao() throws IOException {
        String caminho = getServletContext().getRealPath("/imagens/");
        byte byteArray[] = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(caminho, "imagem_padrao.jpg"));
            int numeroBytes = fileInputStream.available();
            byteArray = new byte[numeroBytes];
            fileInputStream.read(byteArray);

        } catch (IOException ex) {
        } finally {
            fileInputStream.close();
        }
        return byteArray;
    }

}
