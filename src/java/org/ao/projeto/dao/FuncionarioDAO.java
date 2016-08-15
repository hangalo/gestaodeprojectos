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
import org.ao.projeto.modelo.Departamento;
import org.ao.projeto.modelo.Funcionario;
import org.ao.projeto.modelo.Municipio;
import org.ao.projeto.modelo.Sexo;
import org.ao.projeto.util.Conexao;

/**
 *
 * @author informatica
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario> {

    private static final String INSERIR = "INSERT INTO funcionario (nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario, sexo_funcionario, casa_funcionario, rua_funcionario, bairrro_funcionario, distrito_funcionario, telefone_unitel, telefone_movicel, telefone_fixo, email_principal, email_alternativo, id_departamento, id_categoria, id_municipio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE funcionario  SET nome_funcionario=?, sobrenome_funcionario=?, data_nascimento_funcionario=?, sexo_funcionario=?, casa_funcionario=?, rua_funcionario=?, bairrro_funcionario=?, distrito_funcionario=?, telefone_unitel=?, telefone_movicel=?, telefone_fixo=?, email_principal=?, email_alternativo=?, id_departamento=?, id_categoria=?, id_municipio=? WHERE id_funcionario =?";
    private static final String ELIMINAR = "DELETE FROM funcionario WHERE id_funcionario =?";
    private static final String BUSCAR_POR_CODIGO = "SELECT f.id_funcionario, f.nome_funcionario, f.sobrenome_funcionario, f.data_nascimento_funcionario, f.sexo_funcionario, f.casa_funcionario, f.rua_funcionario, f.bairrro_funcionario, f.distrito_funcionario, f.telefone_unitel, f.telefone_movicel, f.telefone_fixo, f.email_principal, f.email_alternativo, d.nome_departamento, c.nome_categoria, m.nome_municipio FROM funcionario f INNER JOIN departamento d ON f.id_departamento = d.id_departamento INNER JOIN categoria_funcionario c ON f.id_categoria=c.id_categoria INNER JOIN municipio m ON f.id_municipio = m.id_municipio WHERE f.id_funcionario = ?";
    private static final String LISTAR_TUDO = "SELECT f.id_funcionario, f.nome_funcionario, f.sobrenome_funcionario, f.data_nascimento_funcionario, f.sexo_funcionario, f.casa_funcionario, f.rua_funcionario, f.bairrro_funcionario, f.distrito_funcionario, f.telefone_unitel, f.telefone_movicel, f.telefone_fixo, f.email_principal, f.email_alternativo, d.nome_departamento, c.nome_categoria, m.nome_municipio FROM funcionario f INNER JOIN departamento d ON f.id_departamento = d.id_departamento INNER JOIN categoria_funcionario c ON f.id_categoria=c.id_categoria INNER JOIN municipio m ON f.id_municipio = m.id_municipio";

    public FuncionarioDAO() {

    }

    @Override
    public void save(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setDate(3, new java.sql.Date(funcionario.getDataNascimentoFuncionario().getTime()));
            ps.setString(4, funcionario.getSexo().getAbreviatura());
            ps.setString(5, funcionario.getCasaFuncionario());
            ps.setString(6, funcionario.getRuaFuncionario());
            ps.setString(7, funcionario.getBairroFuncionario());
            ps.setString(8, funcionario.getDistritoFuncionario());
            ps.setString(9, funcionario.getTelefoneUnitel());
            ps.setString(10, funcionario.getTelefoneMovicel());
            ps.setString(11, funcionario.getTelefoneFixo());
            ps.setString(12, funcionario.getEmailPrincipal());
            ps.setString(13, funcionario.getEmailAlternativo());
            ps.setInt(14, funcionario.getDepartamento().getIdDepartamento());
            ps.setInt(15, funcionario.getCategoriaFuncionario().getIdCategoria());
            ps.setInt(16, funcionario.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getSobrenomeFuncionario());
            ps.setDate(3, new java.sql.Date(funcionario.getDataNascimentoFuncionario().getTime()));
            ps.setString(4, funcionario.getSexo().getAbreviatura());
            ps.setString(5, funcionario.getCasaFuncionario());
            ps.setString(6, funcionario.getRuaFuncionario());
            ps.setString(7, funcionario.getBairroFuncionario());
            ps.setString(8, funcionario.getDistritoFuncionario());
            ps.setString(9, funcionario.getTelefoneUnitel());
            ps.setString(10, funcionario.getTelefoneMovicel());
            ps.setString(11, funcionario.getTelefoneFixo());
            ps.setString(12, funcionario.getEmailPrincipal());
            ps.setString(13, funcionario.getEmailAlternativo());
            ps.setInt(14, funcionario.getDepartamento().getIdDepartamento());
            ps.setInt(15, funcionario.getCategoriaFuncionario().getIdCategoria());
            ps.setInt(16, funcionario.getMunicipio().getIdMunicipio());
            ps.setInt(17, funcionario.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (funcionario == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, funcionario.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Funcionario findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return funcionarios;
    }

    private void popularComDados(Funcionario funcionario, ResultSet rs) {
        try {
            funcionario.setIdFuncionario(rs.getInt("f.id_funcionario"));
            funcionario.setNomeFuncionario(rs.getString("f.nome_funcionario"));
            funcionario.setSobrenomeFuncionario(rs.getString("f.sobrenome_funcionario"));
            funcionario.setDataNascimentoFuncionario(rs.getDate("f.data_nascimento_funcionario"));
            funcionario.setSexo(Sexo.getAbreviatura(rs.getString("f.sexo_funcionario")));
            funcionario.setCasaFuncionario(rs.getString("f.casa_funcionario"));
            funcionario.setRuaFuncionario(rs.getString("f.rua_funcionario"));
            funcionario.setBairroFuncionario(rs.getString("f.bairrro_funcionario"));
            funcionario.setDistritoFuncionario(rs.getString("f.distrito_funcionario"));
            funcionario.setTelefoneUnitel(rs.getString("f.telefone_unitel"));
            funcionario.setTelefoneMovicel(rs.getString("f.telefone_movicel"));
            funcionario.setTelefoneFixo(rs.getString("f.telefone_fixo"));
            funcionario.setEmailPrincipal(rs.getString("f.email_principal"));
            funcionario.setEmailAlternativo(rs.getString("f.email_alternativo"));
            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("d.nome_departamento"));
            funcionario.setDepartamento(departamento);
            CategoriaFuncionario categoriaFuncionario = new CategoriaFuncionario();
            categoriaFuncionario.setNomeCategoria(rs.getString("c.nome_categoria"));
            funcionario.setCategoriaFuncionario(categoriaFuncionario);
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("m.nome_municipio"));
            funcionario.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
