
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Actualcompentence;
import model.Staff;

/**
 *
 * @author stine
 */
public class ActualCompentenceHandler {
    private DBHandler dbhandler;
    private ArrayList<Actualcompentence> actualcompentenceResult;
    
    private ActualCompentenceHandler(){
        dbhandler = DBHandler.getInstance();
    }
    
    public ArrayList<Actualcompentence> getActualcompentence(){
        actualcompentenceResult = new ArrayList<>();
        try {
            String sql = "Select * from actualcompentence";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                //LocalTime expirationDate = rs.getObject("expirationDate", expirationDate<LocalTime>);
                String navn = rs.getString("navn");
                int staff = rs.getInt("staffId");
                
                Actualcompentence a1 = new Actualcompentence(expirationDate, navn, new Staff(staff));
                actualcompentenceResult.add(a1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        return actualcompentenceResult;
    }
}
