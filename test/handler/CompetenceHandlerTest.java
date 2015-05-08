/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Competence;
import model.Room;
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
public class CompetenceHandlerTest {
    
    public CompetenceHandlerTest() {
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
     * Test of getCompetance method, of class CompetenceHandler.
     */
    @Test
    public void testGetCompetance() {
        CompetenceHandler ch = new CompetenceHandler();
        ArrayList<Competence> list = ch.getCompetance();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From Competence";
        try{
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
            assertEquals("Antal af elementer passer ikke: ", expectedResult, result);
        } catch (Exception ex){
            fail("getCompetence kaster exception: "+ ex.getMessage());
        }
    }

    /**
     * Test of insertCompetances method, of class CompetenceHandler.
     */
    @Test
    public void testInsertCompetances() {
        System.out.println("insertCompetances");
        String skill = "";
        Room room = null;
        CompetenceHandler instance = new CompetenceHandler();
        instance.insertCompetances(skill, room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompetance method, of class CompetenceHandler.
     */
    @Test
    public void testUpdateCompetance() {
        System.out.println("updateCompetance");
        String newSkill = "";
        Room room = null;
        String uniqueSkill = "";
        CompetenceHandler instance = new CompetenceHandler();
        instance.updateCompetance(newSkill, room, uniqueSkill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
