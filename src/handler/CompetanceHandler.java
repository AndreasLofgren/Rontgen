package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Competance;
import model.Room;

/**
 *
 * @author stine
 */
public class CompetanceHandler {

    private DBHandler dbhandler;
    private ArrayList<Competance> competanceResult;

    private CompetanceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Competance> getCompetance() {
        competanceResult = new ArrayList<>();

        try {
            String sql = "Select * From compentences";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String skill = rs.getString("skill");
                int roomId = rs.getInt("roomId");

                Competance c2 = new Competance(skill, new Room(roomId));
                competanceResult.add(c2);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return competanceResult;
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

    public void updateCompetance(String newSkill, int newRoomId,
            String uniqueSkill) {
        try {
            String sql = "UPDATE compentences SET skill=" + newSkill
                    + ",roomId=" + newRoomId + " WHERE skill=" + uniqueSkill
                    + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }

    }
}
