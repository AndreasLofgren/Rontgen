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
    private ArrayList<String> stringResult;

    public RoomHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Room> getRoom() {
        roomResult = new ArrayList<>();
        String sql = "Select * From room";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String state = rs.getString("state");
                int minStaffAmount = rs.getInt("minStaffAmount");
                int maxStaffAmount = rs.getInt("maxStaffAmount");
                String validFrom = rs.getString("validFrom");

                Room r1 = new Room(id, name, type, state, minStaffAmount,
                        maxStaffAmount, validFrom);
                roomResult.add(r1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return roomResult;
    }

    public ArrayList<String> getRoomType() {
        stringResult = new ArrayList<>();
        String sql = "select distinct(type) from room";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String type = rs.getString("type");

                String s1 = type;
                stringResult.add(s1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return stringResult;
    }

    public ArrayList<String> getRoomStatus() {
        stringResult = new ArrayList<>();
        String sql = "select distinct(status) from room";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String status = rs.getString("status");

                String s1 = status;
                stringResult.add(s1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return stringResult;
    }

    public void insertRoom(Room room) {
        String sql = "INSERT INTO Room VALUES (" + room.getName() + ", "
                + room.getType() + ", " + room.getStatus() + ", "
                + room.getMinStaffAmount() + ", " + room.getMaxStaffAmount()
                + ", " + room.getValidFrom() + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    public void updateRoom(Room room, int id) {
        String sql = "UPDATE room SET name=" + room.getName() + " typ="
                + room.getType() + " state=" + room.getStatus()
                + " minStaffAmount=" + room.getMinStaffAmount()
                + " maxStaffAmount=" + room.getMaxStaffAmount() + " validFrom="
                + room.getValidFrom() + " WHERE id=" + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
