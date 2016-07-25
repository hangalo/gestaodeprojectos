/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projecto.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Colocacao implements Serializable{
    private Integer idColocacao;
    private Funcionario funcionario;
    private Projeto projecto;
    private Date dataInicio;
    private Date dataFim;
    private Double numeroHoras;
    
    

    public Colocacao() {
    }

    public Integer getIdColocacao() {
        return idColocacao;
    }

    public void setIdColocacao(Integer idColocacao) {
        this.idColocacao = idColocacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Projeto getProjecto() {
        return projecto;
    }

    public void setProjecto(Projeto projecto) {
        this.projecto = projecto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Double getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idColocacao);
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
        final Colocacao other = (Colocacao) obj;
        if (!Objects.equals(this.idColocacao, other.idColocacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.projecto.toString() +" "+this.funcionario.toString();
    }
    
    
    
}
