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
import org.ao.projecto.modelo.Municipio;
import org.ao.projecto.modelo.Provincia;
import org.ao.projecto.util.Conexao;

/**
 *
 * @author informatica
 */
public class MunicipioDAO implements GenericoDAO<Municipio>{
private static final String INSERIR = "INSERT INTO municipio(nome_municipio, id_provincia) VALUES(?, ?)";
    private static final String ACTUALIZAR = "UPDATE municipio SET nome_municipio=?, id_provincia=? WHERE id_municipio=?";
    private static final String ELIMINAR = "DELETE FROM municipio WHERE id_municipio = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT m.id_municipio, m.nome_municipio,p.nome_provincia FROM municipio m INNER JOIN provincia p ON m.id_provincia=p.id_provincia WHERE id_municipio =?";
    private static final String LISTAR_TUDO = "SELECT m.id_municipio, m.nome_municipio, p.nome_provincia FROM municipio m INNER JOIN provincia p ON m.id_provincia=p.id_provincia";


    public MunicipioDAO() {
          
    }
 
    @Override
    public void save(Municipio municipio) {
       PreparedStatement ps = null;
        Connection conn = null;

        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvincia().getIdProvincia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Municipio municipio) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getProvincia().getIdProvincia());
            ps.setInt(3, municipio.getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Municipio municipio) {
         PreparedStatement ps = null;
        Connection conn = null;

        if (municipio == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, municipio.getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Municipio findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Municipio municipio = new Municipio();

        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return municipio;
    }

    @Override
    public List<Municipio> findAll() {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn =  Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return municipios;
    }
    
    
     private void popularComDados(Municipio municipio, ResultSet rs) {
        try {
            municipio.setIdMunicipio(rs.getInt("m.id_municipio"));
            municipio.setNomeMunicipio(rs.getString("m.nome_municipio"));
            Provincia provincia = new Provincia();
            provincia.setNomeProvincia(rs.getString("p.nome_provincia"));
            municipio.setProvincia(provincia);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
}
