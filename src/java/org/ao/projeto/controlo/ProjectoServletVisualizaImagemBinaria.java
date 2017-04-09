/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.controlo;


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
        
        byte[] imagem = projetoDAO.recuperarImagem(idImagem);

        if (imagem == null) {
            imagem = carregarImagemPadrao();
        }
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imagem);
        outputStream.flush();
               
        
    }

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
    }// </editor-fold>

    

}
