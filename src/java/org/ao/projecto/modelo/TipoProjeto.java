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
public class TipoProjeto implements Serializable{
    private Integer idTipoProjecto;
    private String nomeTipoProjecto;

    public TipoProjeto() {
    }

    public Integer getIdTipoProjecto() {
        return idTipoProjecto;
    }

    public void setIdTipoProjecto(Integer idTipoProjecto) {
        this.idTipoProjecto = idTipoProjecto;
    }

    public String getNomeTipoProjecto() {
        return nomeTipoProjecto;
    }

    public void setNomeTipoProjecto(String nomeTipoProjecto) {
        this.nomeTipoProjecto = nomeTipoProjecto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idTipoProjecto);
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
        final TipoProjeto other = (TipoProjeto) obj;
        if (!Objects.equals(this.idTipoProjecto, other.idTipoProjecto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeTipoProjecto;
    }
   
    
}
