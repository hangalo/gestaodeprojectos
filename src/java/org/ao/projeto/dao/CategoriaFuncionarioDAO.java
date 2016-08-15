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
import org.ao.projeto.modelo.CategoriaFuncionario;
import org.ao.projeto.util.Conexao;

/**
 *
 * @author informatica
 */
public class CategoriaFuncionarioDAO implements GenericoDAO<CategoriaFuncionario> {

    private static final String INSERIR = "INSERT INTO categoria_funcionario(nome_categoria, salario_categoria) VALUES (?, ?)";
    private static final String ACTUALIZAR = "UPDATE categoria_funcionario SET nome_categoria=?, salario_categoria =? WHERE id_categoria =?";
    private static final String ELIMINAR = "DELETE FROM categoria_funcionario WHERE id_categoria =?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_categoria, nome_categoria, salario_categoria FROM categoria_funcionario WHERE id_categoria =?";
    private static final String LISTAR_TUDO = "SELECT id_categoria, nome_categoria, salario_categoria FROM categoria_funcionario";
   

    public CategoriaFuncionarioDAO() {
        
    }

    @Override
    public void save(CategoriaFuncionario categoriaFuncionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (categoriaFuncionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, categoriaFuncionario.getNomeCategoria());
            ps.setDouble(2, categoriaFuncionario.getSalarioCategoria());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(CategoriaFuncionario categoriaFuncionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (categoriaFuncionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, categoriaFuncionario.getNomeCategoria());
            ps.setDouble(2, categoriaFuncionario.getSalarioCategoria());
            ps.setInt(3, categoriaFuncionario.getIdCategoria());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(CategoriaFuncionario categoriaFuncionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (categoriaFuncionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoriaFuncionario.getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public CategoriaFuncionario findById(Integer id) {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        CategoriaFuncionario categoriaFuncionario = new CategoriaFuncionario();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(categoriaFuncionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return categoriaFuncionario;
    }

    @Override
    public List<CategoriaFuncionario> findAll() {
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<CategoriaFuncionario> categoriaFuncionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaFuncionario categoriaFuncionario = new CategoriaFuncionario();
                popularComDados(categoriaFuncionario, rs);
                categoriaFuncionarios.add(categoriaFuncionario);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return categoriaFuncionarios;
    }

    private void popularComDados(CategoriaFuncionario categoriaFuncionario, ResultSet rs) {
        try {
            categoriaFuncionario.setIdCategoria(rs.getInt("id_categoria"));
            categoriaFuncionario.setNomeCategoria(rs.getString("nome_categoria"));
            categoriaFuncionario.setSalarioCategoria(rs.getDouble("salario_categoria"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
