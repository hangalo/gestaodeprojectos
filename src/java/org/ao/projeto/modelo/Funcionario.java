/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Funcionario implements Serializable{
    private Integer idFuncionario;
    private String nomeFuncionario;
    private String sobrenomeFuncionario;
    private Date dataNascimentoFuncionario;
    private Sexo sexo;
    private String casaFuncionario;
    private String ruaFuncionario;
    private String bairroFuncionario;
    private String distritoFuncionario;
    private String telefoneUnitel;
    private String telefoneMovicel;
    private String telefoneFixo;
    private String emailPrincipal;
    private String emailAlternativo;
    private Departamento departamento;
    private CategoriaFuncionario categoriaFuncionario;
    private Municipio municipio;

    public Funcionario() {
    }

   /* Metodos setters e gettes omitidos*/
    
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return sobrenomeFuncionario;
    }

    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public Date getDataNascimentoFuncionario() {
        return dataNascimentoFuncionario;
    }

    public void setDataNascimentoFuncionario(Date dataNascimentoFuncionario) {
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCasaFuncionario() {
        return casaFuncionario;
    }

    public void setCasaFuncionario(String casaFuncionario) {
        this.casaFuncionario = casaFuncionario;
    }

    public String getRuaFuncionario() {
        return ruaFuncionario;
    }

    public void setRuaFuncionario(String ruaFuncionario) {
        this.ruaFuncionario = ruaFuncionario;
    }

    public String getBairroFuncionario() {
        return bairroFuncionario;
    }

    public void setBairroFuncionario(String bairroFuncionario) {
        this.bairroFuncionario = bairroFuncionario;
    }

    public String getDistritoFuncionario() {
        return distritoFuncionario;
    }

    public void setDistritoFuncionario(String distritoFuncionario) {
        this.distritoFuncionario = distritoFuncionario;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
    }

    public String getTelefoneMovicel() {
        return telefoneMovicel;
    }

    public void setTelefoneMovicel(String telefoneMovicel) {
        this.telefoneMovicel = telefoneMovicel;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public CategoriaFuncionario getCategoriaFuncionario() {
        return categoriaFuncionario;
    }

    public void setCategoriaFuncionario(CategoriaFuncionario categoriaFuncionario) {
        this.categoriaFuncionario = categoriaFuncionario;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.idFuncionario, other.idFuncionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeFuncionario + " " + this.sobrenomeFuncionario;
    }

  
    
    
   
}
