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

    public void insertRoom(Room room) {
        String sql = "INSERT INTO Room VALUES (" + room.getId() + "), ("
                + room.getType() + "), (" + room.getStatus() + "), ("
                + room.getMinStaffAmount() + "), (" + room.getMaxStaffAmount()
                + "), (" + room.getValidFrom() + ");";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    public void updateRoom(Room room, int uniqueId) {
        String sql = "UPDATE room SET id=" + room.getId() + " typ="
                + room.getType() + " state=" + room.getStatus()
                + " minStaffAmount=" + room.getMinStaffAmount()
                + " maxStaffAmount=" + room.getMaxStaffAmount() + " validFrom="
                + room.getValidFrom() + " WHERE id=" + uniqueId + ";";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
