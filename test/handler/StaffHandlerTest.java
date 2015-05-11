/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
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
        StaffHandler sh = new StaffHandler();
        ArrayList<Staff> list = sh.getStaff();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From staff";    //Tæller elementer i absence i DB, skriver samlede antal elementer ud
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
            assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
        } catch (Exception ex) {
            fail("getStaff kaster exception: " + ex.getMessage());
            
        }
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
