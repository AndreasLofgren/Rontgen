package handler;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Competence;
import model.Room;

/**
 *
 * @author stine
 */
public class CompetenceHandler {

    private DBHandler dbhandler;
    private ArrayList<Competence> competenceResult;

    /**
     *
     * @throws FileNotFoundException
     */
    public CompetenceHandler() throws FileNotFoundException {
        dbhandler = DBHandler.getInstance();
    }

    /**
     *
     * @return
     */
    public ArrayList<Competence> getCompetance() {
        competenceResult = new ArrayList<>();
        String sql = "Select * From competence";
        try {

            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String skill = rs.getString("navn");
                int roomId = rs.getInt("roomId");

                Competence c1 = new Competence(id, skill, new Room(roomId));
                competenceResult.add(c1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return competenceResult;
    }

    /**
     *
     * @param competence
     */
    public void insertCompetances(Competence competence) {
        String sql = " INSERT INTO Compentences VALUES (" + competence.getId()
                + ", " + competence.getName() + ", " + competence.getRoom().getId()
                + ")";
        try {
            Statement stmnt = dbhandler.getStmt();
            stmnt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    /**
     *
     * @param competence
     * @param id
     */
    public void updateCompetance(Competence competence, int id) {
        String sql = " UPDATE compentences SET id = " + competence.getId()
                + ", name = " + competence.getName() + " , roomId = "
                + competence.getRoom().getId() + " WHERE skill=" + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
