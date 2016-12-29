/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.controlo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.ao.projeto.dao.ProjetoDAO;
import org.ao.projeto.modelo.Projeto;
import org.ao.projeto.modelo.TipoProjeto;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProjetoServlet", urlPatterns = {"/projetoServlet"})
@MultipartConfig(maxFileSize = 16177215) // tamanho maximo do ficheiro 16 MB
public class ProjetoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Part ficheiro = request.getPart("imagem");
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
                byte[] ficheiroImagem = IOUtils.toByteArray(ficheiro.getInputStream());
                projeto.setImagemProjeto(ficheiroImagem);
                projeto.setFicheiroImagemProjeto(ficheiro.getSubmittedFileName());                        
                projeto.setTipoProjeto(tipoProjeto);
                doUpload(ficheiro);
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

public void doUpload(Part part) {
        try {

            InputStream in = part.getInputStream();
            
            File f = new File("D:\\imagens_projeto\\" + part.getSubmittedFileName());
            
            //para guardar num disco de rede com IP
            // File f = new File("\\\\192.168.0.4\\public\\" + foto.getSubmittedFileName());

            /*
            PARA GUARDAR NUMA PASTA DENTRO DO PROJECTO BASTA FAZER
            String path ="/imagens_projeto";
            File f = new File(path);
            if(!f.exists()){
              f.mkdir();
            }
             */
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024 * 1024 * 100];

            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();       
            


        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
}


}
