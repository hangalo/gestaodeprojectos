/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ao.projeto.modelo.Projeto;
import org.ao.projeto.modelo.TipoProjeto;
import org.ao.projeto.util.Conexao;

/**
 *
 * @author informatica
 */
public class ProjetoDAO implements GenericoDAO<Projeto> {

    private static final String INSERIR = "INSERT INTO projeto(codigo_projeto, nome_projeto, descricao_projeto, custo_projeto, entidade_financiadora, imagem_projeto, ficheiro_imagem_projeto, id_tipo_projeto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE projeto SET codigo_projeto = ?, nome_projeto = ?, descricao_projeto = ?, custo_projeto = ?, entidade_financiadora = ?, id_tipo_projeto = ? WHERE id_projeto = ?";
    private static final String ELIMINAR = "DELETE FROM projeto WHERE id_projeto = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT p.id_projeto, p.codigo_projeto, p.nome_projeto, p.descricao_projeto, p.custo_projeto, p.entidade_financiadora,  t.nome_tipo_projeto FROM projeto p INNER JOIN tipo_projeto t ON p.id_tipo_projeto = t.id_tipo_projeto WHERE p.id_projeto = ?";
    private static final String LISTAR_TUDO = "SELECT p.id_projeto, p.codigo_projeto, p.nome_projeto, p.descricao_projeto, p.custo_projeto, p.entidade_financiadora, t.nome_tipo_projeto, p.imagem_projeto, p.ficheiro_imagem_projeto FROM projeto p INNER JOIN tipo_projeto t ON p.id_tipo_projeto = t.id_tipo_projeto";
    private static final String BUSCAR_IMAGEM_POR_CODIGO = "SELECT p.id_projeto, p.codigo_projeto, p.nome_projeto, p.descricao_projeto, p.custo_projeto, p.entidade_financiadora, t.nome_tipo_projeto, p.imagem_projeto, p.ficheiro_imagem_projeto FROM projeto p INNER JOIN tipo_projeto t ON p.id_tipo_projeto = t.id_tipo_projeto WHERE p.id_projeto = ?";

    public ProjetoDAO() {

    }

    @Override
    public void save(Projeto projeto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projeto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, projeto.getCodigoProjeto());
            ps.setString(2, projeto.getNomeProjeto());
            ps.setString(3, projeto.getDescricaoProjeto());
            ps.setDouble(4, projeto.getCustoProjeto());
            ps.setString(5, projeto.getEntidadeFinanciadora());
            ps.setBytes(6, projeto.getImagemProjeto());
            ps.setString(7, projeto.getFicheiroImagemProjeto());
            ps.setInt(8, projeto.getTipoProjeto().getIdTipoProjeto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Projeto projeto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projeto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, projeto.getCodigoProjeto());
            ps.setString(2, projeto.getNomeProjeto());
            ps.setString(3, projeto.getDescricaoProjeto());
            ps.setDouble(4, projeto.getCustoProjeto());
            ps.setString(5, projeto.getEntidadeFinanciadora());
            ps.setInt(6, projeto.getTipoProjeto().getIdTipoProjeto());
            ps.setInt(7, projeto.getIdProjeto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Projeto projeto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projeto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, projeto.getIdProjeto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Projeto findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Projeto projeto = new Projeto();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(projeto, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return projeto;
    }

    @Override
    public List<Projeto> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Projeto> projetos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Projeto projeto = new Projeto();
                popularComDados(projeto, rs);
                projetos.add(projeto);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return projetos;
    }

    public byte[] recuperarImagem(Integer id) {
        byte[] imagem = null;
        PreparedStatement ps;
        Connection conn = null;
        ResultSet rs;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_IMAGEM_POR_CODIGO);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                imagem = rs.getBytes("p.imagem_projeto");
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }

        return imagem;
    }

    private void popularComDados(Projeto projeto, ResultSet rs) {
        try {
            projeto.setIdProjeto(rs.getInt("p.id_projeto"));
            projeto.setCodigoProjeto(rs.getString("p.codigo_projeto"));
            projeto.setNomeProjeto(rs.getString("p.nome_projeto"));
            projeto.setDescricaoProjeto(rs.getString("p.descricao_projeto"));
            projeto.setCustoProjeto(rs.getDouble("p.custo_projeto"));
            projeto.setEntidadeFinanciadora(rs.getString("p.entidade_financiadora"));
            TipoProjeto tipoProjecto = new TipoProjeto();
            tipoProjecto.setNomeTipoProjeto(rs.getString("t.nome_tipo_projeto"));
            projeto.setTipoProjeto(tipoProjecto);
            projeto.setImagemProjeto(rs.getBytes("p.imagem_projeto"));
            projeto.setFicheiroImagemProjeto(rs.getString("p.ficheiro_imagem_projeto"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
