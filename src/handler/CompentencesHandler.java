package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Compentences;
import model.Room;

/**
 *
 * @author stine
 */
public class CompentencesHandler {

    private DBHandler dbhandler;
    private ArrayList<Compentences> compentencesResult;

    private CompentencesHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Compentences> getCompentences() {
        compentencesResult = new ArrayList<>();

        try {
            String sql = "Select * From compentences";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String skill = rs.getString("skill");
                int roomId = rs.getInt("roomId");

                Compentences c2 = new Compentences(skill, new Room(roomId));
                compentencesResult.add(c2);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return compentencesResult;
    }

    public void insertCompentences(String skill, Room room) {
        try {
            String sql = "INSERT INTO Compentences VALUES (" + skill + ", " + room.getId() + ");";
            Statement stmnt = dbhandler.getStmt();
            stmnt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateCompentence(String newSkill, int newRoomId, String uniqueSkill) {
        try {
            String sql = "UPDATE compentences SET skill=" + newSkill + ",roomId=" + newRoomId + " WHERE skill=" + uniqueSkill + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }

    }
}
