/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.ActualCompetence;
import model.Competence;
import model.Staff;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Birgit Schæffer
 */
public class ActualCompetenceHandlerTest {
    
    public ActualCompetenceHandlerTest() {
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
     * Test of getActualCompetance method, of class ActualCompetenceHandler.
     */
    @Test
    public void testGetActualCompetance() {
        ActualCompetenceHandler ah = new ActualCompetenceHandler();
        ArrayList<ActualCompetence> list = ah.getActualCompetance();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From actualcompetence";
        try{
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
        assertEquals("Antal af elementer på listen passer ikke:",expectedResult, result);
        } catch (Exception ex){
            fail("getActualCompetence kaster exception: "+ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertActualCompetance method, of class ActualCompetenceHandler.
     */
    @Test
    public void testInsertActualCompetance() {
        System.out.println("insertActualCompetance");
        String expirationDate = "";
        Competence competence = null;
        Staff staff = null;
        ActualCompetenceHandler instance = new ActualCompetenceHandler();
        instance.insertActualCompetance(expirationDate, competence, staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAcutualCompetance method, of class ActualCompetenceHandler.
     */
    @Test
    public void testUpdateAcutualCompetance() {
        System.out.println("updateAcutualCompetance");
        String newExpirationDate = "";
        String newName = "";
        int newStaffId = 0;
        int uniqueStaffId = 0;
        ActualCompetenceHandler instance = new ActualCompetenceHandler();
        instance.updateAcutualCompetance(newExpirationDate, newName, newStaffId, uniqueStaffId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
