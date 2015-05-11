/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;
import model.Shift;
import model.Staff;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stine
 */
public class ShiftHandlerTest {

    public ShiftHandlerTest() {
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
     * Test of getShift method, of class ShiftHandler.
     */
    @Test
    public void testGetShift_0args() {
        ShiftHandler sh1 = new ShiftHandler();
        ArrayList<Shift> list = sh1.getShift();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From shift";    //Tæller elementer i absence i DB, skriver samlede antal elementer ud
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
            assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
        } catch (Exception ex) {
            fail("getShift kaster exception: " + ex.getMessage());
        }
    }

    /**
     * Test of getShift method, of class ShiftHandler.
     */
    @Test
    public void testGetShift_String() {
        ShiftHandler sh2 = new ShiftHandler();
        String date = "2015-01-12";
        ArrayList<Shift> list = sh2.getShift(date);
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From shift WHERE dates = " + date;
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
            assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
        } catch (Exception ex) {
            fail("getShift kaster exception: " + ex.getMessage());
        }
    }

    /**
     * Test of getShift method, of class ShiftHandler.
     */
    @Test
    public void testGetShift_String_String() {
        ShiftHandler sh3 = new ShiftHandler();
        String shiftStart = "2015-10-10";
        String shiftEnd = "2015-10-12";
        ArrayList<Shift> list = sh3.getShift(shiftStart, shiftEnd);
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From shift WHERE shiftStart >= " + shiftStart + " AND shiftEnd <=" + shiftEnd + ";";
        try{
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
        assertEquals("Antal af elementer på listen passer ikke:",expectedResult, result);       // assertpEquals - sammeligner
        } catch (Exception ex){
            fail("getShift kaster exception: "+ex.getMessage());
        }
    }

    /**
     * Test of insertShift method, of class ShiftHandler.
     */
    @Test
    public void testInsertShift() {
        System.out.println("insertShift");
        int id = 0;
        String date = "";
        String shiftStart = "";
        String shiftEnd = "";
        Staff staff = null;
        Room room = null;
        ShiftHandler instance = new ShiftHandler();
        instance.insertShift(id, date, shiftStart, shiftEnd, staff, room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateShift method, of class ShiftHandler.
     */
    @Test
    public void testUpdateShift() {
        System.out.println("updateShift");
        String newId = "";
        String newDate = "";
        String newShiftStart = "";
        String newShiftEnd = "";
        int newStaffId = 0;
        String newRoomId = "";
        int uniqueId = 0;
        ShiftHandler instance = new ShiftHandler();
        instance.updateShift(newId, newDate, newShiftStart, newShiftEnd, newStaffId, newRoomId, uniqueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
