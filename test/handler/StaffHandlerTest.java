/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.ArrayList;
import model.Staff;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class StaffHandlerTest {
    
    public StaffHandlerTest() {
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
     * Test of getStaff method, of class StaffHandler.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        StaffHandler instance = new StaffHandler();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.getStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertStaff method, of class StaffHandler.
     */
    @Test
    public void testInsertStaff() {
        System.out.println("insertStaff");
        int id = 0;
        String firstname = "";
        String lastname = "";
        String nickname = "";
        StaffHandler instance = new StaffHandler();
        instance.insertStaff(id, firstname, lastname, nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStaff method, of class StaffHandler.
     */
    @Test
    public void testUpdateStaff() {
        System.out.println("updateStaff");
        int newId = 0;
        String newfirstName = "";
        String newlastName = "";
        String newnickname = "";
        String uniqueId = "";
        StaffHandler instance = new StaffHandler();
        instance.updateStaff(newId, newfirstName, newlastName, newnickname, uniqueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
