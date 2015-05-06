/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class AbsenceTest {
    
    public AbsenceTest() {
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
     * Test of getStaff method, of class Absence.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        Absence instance = null;
        Staff expResult = null;
        Staff result = instance.getStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaff method, of class Absence.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");
        Staff staff = null;
        Absence instance = null;
        instance.setStaff(staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayStart method, of class Absence.
     */
    @Test
    public void testGetDayStart() {
        System.out.println("getDayStart");
        Absence instance = null;
        String expResult = "";
        String result = instance.getDayStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayStart method, of class Absence.
     */
    @Test
    public void testSetDayStart() {
        System.out.println("setDayStart");
        String dayStart = "";
        Absence instance = null;
        instance.setDayStart(dayStart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayEnd method, of class Absence.
     */
    @Test
    public void testGetDayEnd() {
        System.out.println("getDayEnd");
        Absence instance = null;
        String expResult = "";
        String result = instance.getDayEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayEnd method, of class Absence.
     */
    @Test
    public void testSetDayEnd() {
        System.out.println("setDayEnd");
        String dayEnd = "";
        Absence instance = null;
        instance.setDayEnd(dayEnd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
