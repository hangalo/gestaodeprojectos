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
public class Projeto implements Serializable {

    private Integer idProjecto;
    private String codigoProjecto;
    private String nomeProjecto;
    private String descricaoProjecto;
    private Double custoProjecto;
    private String entidadeFinanciadora;
    private TipoProjeto tipoProjecto;

    public Projeto() {
    }

   

    public Integer getIdProjecto() {
        return idProjecto;
    }

    public void setIdProjecto(Integer idProjecto) {
        this.idProjecto = idProjecto;
    }

    public String getCodigoProjecto() {
        return codigoProjecto;
    }

    public void setCodigoProjecto(String codigoProjecto) {
        this.codigoProjecto = codigoProjecto;
    }

    public String getNomeProjecto() {
        return nomeProjecto;
    }

    public void setNomeProjecto(String nomeProjecto) {
        this.nomeProjecto = nomeProjecto;
    }

    public String getDescricaoProjecto() {
        return descricaoProjecto;
    }

    public void setDescricaoProjecto(String descricaoProjecto) {
        this.descricaoProjecto = descricaoProjecto;
    }

    public Double getCustoProjecto() {
        return custoProjecto;
    }

    public void setCustoProjecto(Double custoProjecto) {
        this.custoProjecto = custoProjecto;
    }

    public String getEntidadeFinanciadora() {
        return entidadeFinanciadora;
    }

    public void setEntidadeFinanciadora(String entidadeFinanciadora) {
        this.entidadeFinanciadora = entidadeFinanciadora;
    }

    
    
    public TipoProjeto getTipoProjecto() {
        return tipoProjecto;
    }

    public void setTipoProjecto(TipoProjeto tipoProjecto) {
        this.tipoProjecto = tipoProjecto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idProjecto);
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
        final Projeto other = (Projeto) obj;
        if (!Objects.equals(this.idProjecto, other.idProjecto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.codigoProjecto +" "+this.nomeProjecto;
    }

    
    
    
}
