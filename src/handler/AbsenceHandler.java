package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import model.Absence;
import model.Staff;

/**
 *
 * @author stine
 */
public class AbsenceHandler {

    private DBHandler dbhandler;
    private ArrayList<Absence> absenceResult;

    private AbsenceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Absence> getAbsence() {
        absenceResult = new ArrayList<>();
        try {
            String sql = "Select * From absence";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
//                LocalTime dayStart = rs.getObject("dayStart", dayStart<LocalTime>);
//                LocalTime dayEnd = rs.getObject("dayEnd", dayEnd<LocalTime>);
                int staff = rs.getInt("staffId");
                
                Absence a1 = new Absence(dayStart, dayEnd, new Staff(staff));
                        
                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }
    
    public void updateAbsence(String newdayStart, String newdayEnd, int newStaffId, int uniqueStaffId){
        try {
        String sql = "UPDATE absence SET dayStart=" + newdayStart + "dayEnd="+ newdayEnd + "staffId=" + newStaffId +"WHERE staffId =" + uniqueStaffId;
        Statement stmt = dbhandler.getStmt();
        stmt.executeUpdate(sql);
        
         } catch (SQLException ex) {
             System.out.println("SQLException" + ex);
         }
    }
}
