/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Shift;
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
public class CreateShowTest {
    
    public CreateShowTest() {
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
     * Test of createWeek method, of class CreateShow.
     */
    @org.junit.Test
    public void testCreateWeek() {
        System.out.println("createWeek");
        String startDato = "";
        CreateShow instance = new CreateShow();
        ArrayList<ArrayList<Shift>> expResult = null;
        ArrayList<ArrayList<Shift>> result = instance.createWeek(startDato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showWeek method, of class CreateShow.
     */
    @org.junit.Test
    public void testShowWeek() {
        System.out.println("showWeek");
        String monDate = "";
        String tuesDate = "";
        String wednesDate = "";
        String thursDate = "";
        String friDate = "";
        String saturDate = "";
        String sunDate = "";
        CreateShow instance = new CreateShow();
        instance.showWeek(monDate, tuesDate, wednesDate, thursDate, friDate, saturDate, sunDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
