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
public class Municipio implements Serializable{

    private static final long serialVersionUID = -7781733135837169859L;
    private Integer idMunicipio;
    private String nomeMunicipio;
    private Provincia provincia;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio, String nomeMunicipio, Provincia provincia) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.provincia = provincia;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idMunicipio);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.idMunicipio, other.idMunicipio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeMunicipio;
    }
    
    
}
