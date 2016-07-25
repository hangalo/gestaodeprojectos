/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projecto.relatorios;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.ao.projecto.util.Conexao;

@WebServlet(name = "RelatorioProjetoServlet", urlPatterns = {"/relatorioProjetoServlet"})
public class RelatorioProjetoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection conn;

        ServletOutputStream servletOutputStream = response.getOutputStream();

        File caminhoRelatorioSemParametros = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/projetos_lista.jasper"));
        File caminhoRelatorioComParametros = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/relatorios/projeto_ficha.jasper"));
        byte[] bytes;

        String comando = request.getParameter("comando");

        if (comando.equalsIgnoreCase("imprimir_lista_projetos")) {

            try {
                conn = Conexao.getConnection();
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorioSemParametros.getPath(), new HashMap(), conn);
                conn.close();
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();

            } catch (IOException | JRException | SQLException ex) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());

            }

        } else if (comando.equalsIgnoreCase("imprimir_ficha_projeto")) {
            
            String codigoProjeto = request.getParameter("codigoProjeto");
            HashMap hashMap = new HashMap();
            hashMap.put("codigoProjeto", codigoProjeto);

            try {
                conn = Conexao.getConnection();
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorioComParametros.getPath(), hashMap, conn);
                conn.close();
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();

            } catch (IOException | JRException | SQLException ex) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());

            }

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
