package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staff = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staff), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }

    public void insertAbsence(int id, Staff staff) {
        try {
            String sql = "INSERT INTO Absence VALUES (" + id + ", " + staff.getId() + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateAbsence(String newdayStart, String newdayEnd, int newStaffId, int uniqueStaffId) {
        try {
            String sql = "UPDATE absence SET dayStart=" + newdayStart + "dayEnd=" + newdayEnd + "staffId=" + newStaffId + "WHERE staffId =" + uniqueStaffId;
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }
}
