package handler;

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

    public CompetenceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Competence> getCompetance() {
        competenceResult = new ArrayList<>();

        try {
            String sql = "Select * From compentences";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String skill = rs.getString("skill");
                String roomId = rs.getString("roomId");

                Competence c2 = new Competence(skill, new Room(roomId));
                competenceResult.add(c2);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return competenceResult;
    }

    public void insertCompetances(String skill, Room room) {
        try {
            String sql = "INSERT INTO Compentences VALUES (" + skill + ", "
                    + room.getId() + ");";
            Statement stmnt = dbhandler.getStmt();
            stmnt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateCompetance(String newSkill, Room room,
            String uniqueSkill) {
        try {
            String sql = "UPDATE compentences SET skill=" + newSkill
                    + ",roomId=" + room.getId()+ " WHERE skill=" + uniqueSkill
                    + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }

    }
}
