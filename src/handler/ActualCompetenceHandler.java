package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ActualCompetence;
import model.Competence;
import model.Staff;

/**
 *
 * @author stine
 */
public class ActualCompetenceHandler {

    private DBHandler dbhandler;
    private ArrayList<ActualCompetence> actualCompetanceResult;

    public ActualCompetenceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<ActualCompetence> getActualCompetance() {
        actualCompetanceResult = new ArrayList<>();
        try {
            String sql = "Select * from actualcompentence";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String expirationDate = rs.getString("expirationDate");

                String navn = rs.getString("navn");
                int staffId = rs.getInt("staffId");

                ActualCompetence a1 = new ActualCompetence(expirationDate,
                        new Competence(navn), new Staff(staffId));
                actualCompetanceResult.add(a1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return actualCompetanceResult;
    }

    public void insertActualCompetance(String expirationDate,
            Competence competence, Staff staff) {
        try {
            String sql = "INSERT INTO ActualCompentence VALUES ("
                    + expirationDate + ", " + competence.getSkill() + ", "
                    + staff.getId() + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateAcutualCompetance(String newExpirationDate,
            String newName, int newStaffId, int uniqueStaffId) {
        try {
            String sql = "UPDATE actualcCompentence SET skill="
                    + newExpirationDate + ",roomId=" + newName + ", staffId="
                    + newStaffId + " WHERE skill=" + uniqueStaffId + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }
}
