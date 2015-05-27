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

    public AbsenceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    // Henter alle data fra Absence tabellen, omformer til Absence-obj og returnerer en liste med objekterne
    public ArrayList<Absence> getAbsence() {
        absenceResult = new ArrayList<>();
        String sql = "Select * From absence";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staffId = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staffId), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }

    public ArrayList<Absence> getAbsence(String firstDay, String lastDay) {
        absenceResult = new ArrayList<>();
        String sql = "Select * From absence where dayStart >= '" + firstDay
                + "' and dayEnd <= '" + lastDay;
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staffId = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staffId), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException " + ex.getMessage());
        }

        return absenceResult;
    }

    public ArrayList<Absence> getCurrentAbsence() {
        absenceResult = new ArrayList<>();
        String sql = "Select * From absence where dayEnd = null OR dayEnd = curdate()";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staffId = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staffId), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }

    public void insertAbsence(Absence absence) {
        String sql = "INSERT INTO Absence VALUES (" + absence.getDayStart()
                + ", " + absence.getDayEnd() + ", " + absence.getStaff().getId()
                + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    public void updateAbsence(Absence absence, int id) {
        String sql = " UPDATE absence SET dayStart=" + absence.getDayStart()
                + " dayEnd=" + absence.getDayEnd() + " staffId="
                + absence.getStaff().getId() + " WHERE id =" + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
