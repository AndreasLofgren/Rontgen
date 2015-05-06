package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;

/**
 *
 * @author stine
 */
public class RoomHandler {

    private DBHandler dbhandler;
    private ArrayList<Room> roomResult;

    public RoomHandler() {
        dbhandler = DBHandler.getInstance();

    }

    public ArrayList<Room> getRoom() {
        roomResult = new ArrayList<>();

        try {
            String sql = "Select * From room";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String typ = rs.getString("typ");
                String state = rs.getString("state");
                int minStaffAmount = rs.getInt("minStaffAmount");
                int maxStaffAmount = rs.getInt("maxStaffAmount");
                String validFrom = rs.getString("validFrom");

                Room r1 = new Room(id, typ, state, minStaffAmount,
                        maxStaffAmount, validFrom);
                roomResult.add(r1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return roomResult;
    }

    public void insertRoom(String id, String type, String status,
            int minStaffAmount, int maxStaffAmount, String validFrom) {
        try {
            String sql = "INSERT INTO Room VALUES (" + id + "), (" + type
                    + "), (" + status + "), (" + minStaffAmount + "), ("
                    + maxStaffAmount + "), (" + validFrom + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateRoom(String newRoomId, String newTyp, String newState,
            int newMinStaffAmount, int newMaxStaffAmount, String newValidFrom,
            int uniqueId) {
        try {
            String sql = "UPDATE room SET id=" + newRoomId + "typ=" + newTyp
                    + "state=" + newState + "minStaffAmount="
                    + newMinStaffAmount + "maxStaffAmount=" + newMaxStaffAmount
                    + "validFrom=" + newValidFrom + "WHERE id=" + uniqueId + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }
}
