
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Actualcompentence;
import model.Compentences;
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
               String expirationDate = rs.getString("expirationDate");
                String navn = rs.getString("navn");
                int staff = rs.getInt("staffId");
                
                Actualcompentence a1 = new Actualcompentence(expirationDate, new Compentences(navn), new Staff(staff));
                actualcompentenceResult.add(a1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        return actualcompentenceResult;
    }
    
    public void insertActualCompentence(String expirationDate, Compentences compentence, Staff staff) {
        try {
            String sql = "INSERT INTO ActualCompentence VALUES ("+expirationDate+", "+compentence.getSkill()+", "+staff.getId()+");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);
            
        } catch (SQLException ex){
            System.out.println("SQLException"+ex);
        }
    }
    
}
