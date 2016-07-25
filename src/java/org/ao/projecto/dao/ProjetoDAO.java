/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ao.projecto.modelo.Projeto;
import org.ao.projecto.modelo.TipoProjeto;
import org.ao.projecto.util.Conexao;

/**
 *
 * @author informatica
 */
public class ProjetoDAO implements GenericoDAO<Projeto> {

    private static final String INSERIR = "INSERT INTO projecto(codigo_projecto, nome_projecto, descricao_projecto, custo_projecto, entidade_financiadora, id_tipo_projecto) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE projecto SET codigo_projecto = ?, nome_projecto = ?, descricao_projecto = ?, custo_projecto = ?, entidade_financiadora = ?, id_tipo_projecto = ? WHERE id_projecto = ?";
    private static final String ELIMINAR = "DELETE FROM projecto WHERE id_projecto = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT p.id_projecto, p.codigo_projecto, p.nome_projecto, p.descricao_projecto, p.custo_projecto, p.entidade_financiadora,  t.nome_tipo_projecto FROM projecto p INNER JOIN tipo_projecto t ON p.id_tipo_projecto = t.id_tipo_projecto WHERE p.id_projecto = ?";
    private static final String LISTAR_TUDO = "SELECT p.id_projecto, p.codigo_projecto, p.nome_projecto, p.descricao_projecto, p.custo_projecto, p.entidade_financiadora, t.nome_tipo_projecto FROM projecto p INNER JOIN tipo_projecto t ON p.id_tipo_projecto = t.id_tipo_projecto";

   

    public ProjetoDAO() {
       
    }

    @Override
    public void save(Projeto projecto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, projecto.getCodigoProjecto());
            ps.setString(2, projecto.getNomeProjecto());
            ps.setString(3, projecto.getDescricaoProjecto());
            ps.setDouble(4, projecto.getCustoProjecto());
            ps.setString(5, projecto.getEntidadeFinanciadora());
            ps.setInt(6, projecto.getTipoProjecto().getIdTipoProjecto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Projeto projecto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
             ps.setString(1, projecto.getCodigoProjecto());
            ps.setString(2, projecto.getNomeProjecto());
            ps.setString(3, projecto.getDescricaoProjecto());
            ps.setDouble(4, projecto.getCustoProjecto());
            ps.setString(5, projecto.getEntidadeFinanciadora());
            ps.setInt(6, projecto.getTipoProjecto().getIdTipoProjecto());
            ps.setInt(7, projecto.getIdProjecto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Projeto projecto) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (projecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, projecto.getIdProjecto());
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
        Projeto projecto = new Projeto();

        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(projecto, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return projecto;
    }

    @Override
    public List<Projeto> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Projeto> projectos = new ArrayList<>();
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Projeto projecto = new Projeto();
                popularComDados(projecto, rs);
                projectos.add(projecto);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return projectos;
    }

    private void popularComDados(Projeto projecto, ResultSet rs) {
        try {
            projecto.setIdProjecto(rs.getInt("p.id_projecto"));
            projecto.setCodigoProjecto(rs.getString("p.codigo_projecto"));
            projecto.setNomeProjecto(rs.getString("p.nome_projecto"));
            projecto.setDescricaoProjecto(rs.getString("p.descricao_projecto"));
            projecto.setCustoProjecto(rs.getDouble("p.custo_projecto"));
            projecto.setEntidadeFinanciadora(rs.getString("p.entidade_financiadora"));
            TipoProjeto tipoProjecto = new TipoProjeto();
            tipoProjecto.setNomeTipoProjecto(rs.getString("t.nome_tipo_projecto"));
            projecto.setTipoProjecto(tipoProjecto);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
