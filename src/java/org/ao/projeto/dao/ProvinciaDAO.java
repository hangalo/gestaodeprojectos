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
import org.ao.projeto.modelo.Provincia;
import org.ao.projeto.util.Conexao;

/**
 *
 * @author informatica
 */
public class ProvinciaDAO implements GenericoDAO<Provincia>{
    
    private static final String INSERIR = "INSERT INTO provincia(nome_provincia) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE provincia SET nome_provincia = ? WHERE id_provincia = ?";
    private static final String ELIMINAR = "DELETE FROM provincia WHERE id_provincia = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_provincia, nome_provincia FROM provincia WHERE id_provincia =?";
    private static final String LISTAR_TUDO = "SELECT id_provincia, nome_provincia FROM provincia";
 

    public ProvinciaDAO() {
        
    }
 
 

    @Override
    public void save(Provincia provincia) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (provincia == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
           conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, provincia.getNomeProvincia());           
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Provincia provincia) {
      PreparedStatement ps = null;
      Connection conn=null;
        System.out.println("org.ao.projecto.dao.ProvinciaDAO.update()");
        if (provincia == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
           conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, provincia.getNomeProvincia());
            ps.setInt(2, provincia.getIdProvincia());
            System.out.println("Id trazido: ====>>>"+provincia.getIdProvincia());
            ps.executeUpdate();
            System.out.println("Actualizado com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Provincia provincia) {
        PreparedStatement ps = null;
        Connection conn= null;

        if (provincia == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
          conn= Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, provincia.getIdProvincia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Provincia findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn  = null;
        ResultSet rs = null;
        Provincia provincia = new Provincia();

        try {
          conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(provincia, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return provincia;
    }

    @Override
    public List<Provincia> findAll() {
        PreparedStatement ps = null;
        Connection conn = Conexao.getConnection();
        ResultSet rs = null;
        List<Provincia> provincias = new ArrayList<>();
        try {
           // conn = this.conn;
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia provincia = new Provincia();
                popularComDados(provincia, rs);
                provincias.add(provincia);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return provincias;
    }
    
    
    
    private void popularComDados(Provincia provincia, ResultSet rs) {
        try {
           
          provincia.setIdProvincia(rs.getInt("id_provincia"));
          provincia.setNomeProvincia(rs.getString("nome_provincia"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
}
