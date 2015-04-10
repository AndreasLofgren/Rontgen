

package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Staff;

/**
 *
 * @author stine
 */
public class StaffHandler {
    
    private DBHandler dbhandler;
    private ArrayList<Staff> staffResult;
    
    private StaffHandler(){
        dbhandler = DBHandler.getInstance();
    }
    
    public ArrayList<Staff> getStaff(){
        staffResult = new ArrayList<>();
        
        try{
            String sql = "Select * From staff";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String nickname = rs.getString("nickname");
                
                
                Staff s1 = new Staff(id, firstName, lastName, nickname);
                staffResult.add(s1);
                
            }
        }catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return staffResult;
    }
    
    public void insertStaff(int id, String firstname, String lastname, String nickname){
        try {
        String sql = "INSERT INTO Staff VALUES("+id+", "+firstname+", "+lastname+","+nickname+";";
        Statement stmt = dbhandler.getStmt();
        stmt.executeUpdate(sql);
        
        } catch (SQLException ex){
            System.out.println("SQLException" + ex);
        }
    }
    
    public void updateStaff(int newId, String newfirstName, String newlastName, String newnickname, String uniqueId) {
        try {
        String sql = "UPDATE Staff SET Id=" + newId + ",firstName=" + newfirstName + ",lastName=" + newlastName + ",nickname=" + newnickname + " WHERE Id=" + uniqueId + ";";
        Statement stmt = dbhandler.getStmt();
        stmt.executeUpdate(sql);
        
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }
}

