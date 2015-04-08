package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;

/**
 *
 * @author stine
 */
public class RoomHandler {
    private DBHandler dbhandler;
    private ArrayList<Room> roomResult;
    
    public RoomHandler(){
        dbhandler = DBHandler.getInstance();
       
    }
    
    public ArrayList<Room> getRoom() {
        roomResult = new ArrayList<>();
        
        try{
            String sql = "Select * From room";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String typ = rs.getString("typ");
                String state = rs.getString("state");
                int minStaffAmount = rs.getInt("minStaffAmount");
                int maxStaffAmount = rs.getInt("maxStaffAmount");
                //LocalTime validFrom = rs.getObject("validFrom", validFrom<LocalTime>);
                
                Room r1 = new Room(id, typ, state, minStaffAmount, maxStaffAmount, validFrom);
                roomResult.add(r1);
            }
        }catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return roomResult;
    }
}
