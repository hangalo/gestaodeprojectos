/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.projeto.dao;

import java.util.List;
import org.ao.projeto.modelo.Projeto;
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
public class ProjetoDAOTest {
    
    public ProjetoDAOTest() {
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
     * Test of save method, of class ProjetoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Projeto projeto = new Projeto();
        ProjetoDAO instance = new ProjetoDAO();
      
    }

    /**
     * Test of update method, of class ProjetoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Projeto projeto = null;
        ProjetoDAO instance = new ProjetoDAO();
        instance.update(projeto);
       
    }

    /**
     * Test of delete method, of class ProjetoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Projeto projeto = null;
        ProjetoDAO instance = new ProjetoDAO();
        instance.delete(projeto);
        
    }

    /**
     * Test of findById method, of class ProjetoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        ProjetoDAO instance = new ProjetoDAO();
        Projeto expResult = null;
        Projeto result = instance.findById(id);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of findAll method, of class ProjetoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ProjetoDAO instance = new ProjetoDAO();
        List<Projeto> expResult = null;
        List<Projeto> result = instance.findAll();
        assertEquals(expResult, result);
      
    }
    
}
