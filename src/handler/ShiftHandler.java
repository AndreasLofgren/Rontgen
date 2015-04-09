package handler;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import model.Room;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine
 */
public class ShiftHandler {

    private DBHandler dbhandler;
    private ArrayList<Shift> shiftResult;

    private ShiftHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Shift> getShift() {
        shiftResult = new ArrayList<>();

        try {
            String sql = "Select * from shift";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("dayStart");
                String shiftEnd = rs.getString("dayEnd");
                int staff = rs.getInt("staffId");
                int room = rs.getInt("roomId");
               
                
                Shift s1 = new Shift(id, date, shiftStart, shiftEnd, new Staff(staff), new Room(room));
                shiftResult.add(s1);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }
    
    public void insertShift(int id, LocalTime date, LocalTime shiftStart, LocalTime shiftEnd, Staff staff, Room room) {
        try {
        String sql = "INSERT INTO Shift VALUES ("+id+", "+date+", "+shiftStart+", "+shiftEnd+", "+staff.getId()+", "+room.getId()+");";
        Statement stmt = dbhandler.getStmt();
        stmt.executeUpdate(sql);
        
        } catch (SQLException ex) {
            System.out.println("SQLException"+ex);
        }
    }
}
