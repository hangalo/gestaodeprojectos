/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ao.projecto.modelo;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Departamento implements Serializable{
    private Integer idDepartamento;
    private String nomeDepartamento;

    public Departamento() {
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idDepartamento);
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.idDepartamento, other.idDepartamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  this.nomeDepartamento;
    }

   
    
}
