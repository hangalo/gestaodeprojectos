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
public class TipoProjeto implements Serializable{
    private Integer idTipoProjeto;
    private String nomeTipoProjeto;

    public TipoProjeto() {
    }

    public Integer getIdTipoProjeto() {
        return idTipoProjeto;
    }

    public void setIdTipoProjeto(Integer idTipoProjeto) {
        this.idTipoProjeto = idTipoProjeto;
    }

    public String getNomeTipoProjeto() {
        return nomeTipoProjeto;
    }

    public void setNomeTipoProjeto(String nomeTipoProjeto) {
        this.nomeTipoProjeto = nomeTipoProjeto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idTipoProjeto);
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
        if (!Objects.equals(this.idTipoProjeto, other.idTipoProjeto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeTipoProjeto;
    }
   
    
}
