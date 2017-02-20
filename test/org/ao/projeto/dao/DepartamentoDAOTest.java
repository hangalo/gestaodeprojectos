/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.dao;

import java.util.List;
import org.ao.projeto.modelo.Departamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author informatica
 */
public class DepartamentoDAOTest {
    
   

   
    @Test
    public void testSave() {
        System.out.println("save");
        Departamento departamento = new Departamento();
        departamento.setNomeDepartamento("Higiene");
        
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.save(departamento);
       
    }

 
    @Test
    public void testUpdate() {
        System.out.println("update");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(2);
        departamento.setNomeDepartamento("Higiene e Limpeza");
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.update(departamento);
      
    }


    @Test
    public void testDelete() {
        System.out.println("delete");
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(2);// é necessario que ja exista um departamento de codigo numero 2
        DepartamentoDAO instance = new DepartamentoDAO();
        instance.delete(departamento);
      
    }

   
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id =1;
        DepartamentoDAO instance = new DepartamentoDAO();
        Departamento result = instance.findById(id);
        assertTrue(result!=null);
      
    }

  
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DepartamentoDAO instance = new DepartamentoDAO();
        
        List<Departamento> result = instance.findAll();
        assertTrue(result.size()>0);
       
    }
    
}
