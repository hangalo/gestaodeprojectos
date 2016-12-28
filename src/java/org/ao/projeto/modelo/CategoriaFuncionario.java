/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class CategoriaFuncionario implements Serializable{

    private static final long serialVersionUID = 3557517947011313577L;

   
    private Integer idCategoria;
    private String nomeCategoria;
    private Double salarioCategoria;

    public CategoriaFuncionario() {
    }

    public CategoriaFuncionario(Integer idCategoria, String nomeCategoria, Double salarioCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.salarioCategoria = salarioCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Double getSalarioCategoria() {
        return salarioCategoria;
    }

    public void setSalarioCategoria(Double salarioCategoria) {
        this.salarioCategoria = salarioCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idCategoria);
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
        final CategoriaFuncionario other = (CategoriaFuncionario) obj;
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeCategoria;
    }
    
    
    
}
