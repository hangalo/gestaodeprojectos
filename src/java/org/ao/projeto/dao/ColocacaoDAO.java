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
import org.ao.projeto.modelo.Colocacao;
import org.ao.projeto.modelo.Funcionario;
import org.ao.projeto.modelo.Projeto;
import org.ao.projeto.util.Conexao;

/**
 *
 * @author informatica
 */
public class ColocacaoDAO implements GenericoDAO<Colocacao> {

    private static final String INSERIR = "INSERT INTO colocacao (id_funcionario, id_projeto, data_inicio, data_fim) VALUES (?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE colocacao SET id_funcionario =?, id_projeto=?, data_inicio =?, data_fim=? WHERE id_colocacao =?";
    private static final String ELIMINAR = "DELETE FROM colocacao WHERE id_colocacao =?";
    private static final String BUSCAR_POR_CODIGO = " SELECT c.id_colocacao, f.nome_funcionario, f.sobrenome_funcionario, p.codigo_projeto, p.nome_projeto, c.data_inicio, c.data_fim FROM colocacao c INNER JOIN funcionario f ON c.id_funcionario = f.id_funcionario  INNER JOIN projeto p ON c.id_projeto = p.id_projeto WHERE id_colocacao = ?";
    private static final String LISTAR_TUDO = " SELECT c.id_colocacao, f.nome_funcionario, f.sobrenome_funcionario, p.codigo_projeto, p.nome_projeto, c.data_inicio, c.data_fim FROM colocacao c INNER JOIN funcionario f ON c.id_funcionario = f.id_funcionario  INNER JOIN projeto p ON c.id_projeto = p.id_projeto";

    

    public ColocacaoDAO() {
      
    }

    @Override
    public void save(Colocacao colocacao) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (colocacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, colocacao.getFuncionario().getIdFuncionario());
            ps.setInt(2, colocacao.getProjecto().getIdProjeto());
            ps.setDate(3, new java.sql.Date(colocacao.getDataInicio().getTime()));
            ps.setDate(4, new java.sql.Date(colocacao.getDataFim().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Colocacao colocacao) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (colocacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, colocacao.getFuncionario().getIdFuncionario());
            ps.setInt(2, colocacao.getProjecto().getIdProjeto());
            ps.setDate(3, new java.sql.Date(colocacao.getDataInicio().getTime()));
            ps.setDate(4, new java.sql.Date(colocacao.getDataFim().getTime()));
            ps.setInt(5, colocacao.getIdColocacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Colocacao colocacao) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (colocacao == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, colocacao.getIdColocacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Colocacao findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Projeto projeto = new Projeto();
        Colocacao colocacao = new Colocacao();

        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(colocacao, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return colocacao;
    }

    @Override
    public List<Colocacao> findAll() {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Colocacao> colocacaos = new ArrayList<>();
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Colocacao colocacao = new Colocacao();
                popularComDados(colocacao, rs);
                colocacaos.add(colocacao);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return colocacaos;
    }

    
    private void popularComDados(Colocacao colocacao, ResultSet rs) {
        try {
           colocacao.setIdColocacao(rs.getInt("c.id_colocacao"));
           Funcionario funcionario = new Funcionario();
           funcionario.setNomeFuncionario(rs.getString("f.nome_funcionario"));
           funcionario.setSobrenomeFuncionario(rs.getString("f.sobrenome_funcionario"));
           colocacao.setFuncionario(funcionario);
           Projeto projeto = new Projeto();
           projeto.setCodigoProjeto(rs.getString("p.codigo_projeto"));
           projeto.setNomeProjeto(rs.getString("p.nome_projeto"));
           colocacao.setProjecto(projeto);
           colocacao.setDataInicio(rs.getDate("c.data_inicio"));
           colocacao.setDataFim(rs.getDate("c.data_fim"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
}
