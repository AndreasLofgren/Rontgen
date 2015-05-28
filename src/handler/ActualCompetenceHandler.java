package handler;

import java.io.FileNotFoundException;
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

    /**
     *
     * @throws FileNotFoundException
     */
    public ActualCompetenceHandler() throws FileNotFoundException {
        dbhandler = DBHandler.getInstance();
    }

    /**
     *
     * @return
     */
    public ArrayList<ActualCompetence> getActualCompetance() {
        actualCompetanceResult = new ArrayList<>();
        String sql = "Select * from actualcompetence";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String expirationDate = rs.getString("expirationDate");
                int competenceId = rs.getInt("competenceId");
                int staffId = rs.getInt("staffId");

                ActualCompetence a1 = new ActualCompetence(expirationDate,
                        new Competence(competenceId), new Staff(staffId));

                actualCompetanceResult.add(a1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return actualCompetanceResult;
    }

    /**
     *
     * @param id
     * @return
     */
    public ArrayList<ActualCompetence> getActualCompetance(int id) {
        actualCompetanceResult = new ArrayList<>();
        String sql = "Select * from actualcompetence where staffId = " + id;
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String expirationDate = rs.getString("expirationDate");
                int competenceId = rs.getInt("competenceId");
                int staffId = rs.getInt("staffId");

                ActualCompetence a1 = new ActualCompetence(expirationDate,
                        new Competence(competenceId), new Staff(staffId));
                actualCompetanceResult.add(a1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return actualCompetanceResult;
    }

    /**
     *
     * @param aComp
     */
    public void insertActualCompetance(ActualCompetence aComp) {
        String sql = " INSERT INTO ActualCompentence VALUES ("
                + aComp.getExpirationDate() + ", " + aComp.getCompetance().getId()
                + ", " + aComp.getStaff().getId() + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    /**
     *
     * @param aComp
     * @param id
     */
    public void updateAcutualCompetance(ActualCompetence aComp, int id) {
        String sql = " UPDATE actualcCompentence SET expirationDate = "
                + aComp.getExpirationDate() + " , competenceId = "
                + aComp.getCompetance().getId() + " , staffId = "
                + aComp.getStaff().getId() + " WHERE id= " + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
