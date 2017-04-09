/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.dao;

import java.util.List;
import org.ao.projeto.modelo.Funcionario;
import org.ao.projeto.modelo.Sexo;
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
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class FuncionarioDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO instance = new FuncionarioDAO();
        
        funcionario.setSexo(Sexo.getAbreviatura("M"));
        instance.save(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class FuncionarioDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Funcionario funcionario = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.update(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FuncionarioDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Funcionario funcionario = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.delete(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class FuncionarioDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        Funcionario expResult = null;
        Funcionario result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class FuncionarioDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        FuncionarioDAO instance = new FuncionarioDAO();
        List<Funcionario> expResult = null;
        List<Funcionario> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
