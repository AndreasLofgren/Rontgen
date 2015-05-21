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
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int expectedResult = rs.getInt(1);
                assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
            }
        } catch (Exception ex) {
            fail("getActualCompetence kaster exception: " + ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

}
