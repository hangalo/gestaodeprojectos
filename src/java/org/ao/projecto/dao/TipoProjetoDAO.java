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
import org.ao.projecto.modelo.TipoProjeto;
import org.ao.projecto.util.Conexao;

/**
 *
 * @author informatica
 */
public class TipoProjetoDAO implements GenericoDAO<TipoProjeto>{
    private static final String INSERIR = "INSERT INTO tipo_projecto (nome_tipo_projecto) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE tipo_projecto SET nome_tipo_projecto =? WHERE id_tipo_projecto =?";
    private static final String ELIMINAR = "DELETE FROM tipo_projecto WHERE id_tipo_projecto =?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_tipo_projecto, nome_tipo_projecto FROM tipo_projecto WHERE id_tipo_projecto = ?";
    private static final String LISTAR_TUDO = "SELECT id_tipo_projecto, nome_tipo_projecto FROM tipo_projecto";


    public TipoProjetoDAO() {
        
    }
 
 
 
    

    @Override
    public void save(TipoProjeto tipoProjecto) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (tipoProjecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoProjecto.getNomeTipoProjecto());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(TipoProjeto tipoProjecto) {
      PreparedStatement ps = null;
        Connection conn = null;

        if (tipoProjecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, tipoProjecto.getNomeTipoProjecto());
            ps.setInt(2, tipoProjecto.getIdTipoProjecto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(TipoProjeto tipoProjecto) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (tipoProjecto == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoProjecto.getIdTipoProjecto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public TipoProjeto findById(Integer id) {
      PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        TipoProjeto tipoProjecto = new TipoProjeto();

        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tipoProjecto, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return tipoProjecto;
    }

    @Override
    public List<TipoProjeto> findAll() {
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<TipoProjeto> tipoProjectos = new ArrayList<>();
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoProjeto tipoProjecto = new TipoProjeto();
                popularComDados(tipoProjecto, rs);
                tipoProjectos.add(tipoProjecto);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return tipoProjectos;
    }
        
    private void popularComDados(TipoProjeto tipoProjecto, ResultSet rs) {
        try {
         tipoProjecto.setIdTipoProjecto(rs.getInt("id_tipo_projecto"));
         tipoProjecto.setNomeTipoProjecto(rs.getString("nome_tipo_projecto"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
    
}
