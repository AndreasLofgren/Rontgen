package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine
 */
public class ShiftHandler {

    private DBHandler dbhandler;
    private ArrayList<Shift> shiftResult;

    public ShiftHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Shift> getShift() {
        shiftResult = new ArrayList<>();

        try {
            String sql = "Select * from shift";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                String roomId = rs.getString("roomId");

                Shift s1 = new Shift(id, date, shiftStart, shiftEnd, comment,
                        new Staff(staffId), new Room(roomId));
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public ArrayList<Shift> getShift(String day) {
        shiftResult = new ArrayList<>();

        try {
            String sql = "Select * from shift WHERE dates = " + day + ";";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                String roomId = rs.getString("roomId");

                Shift s1 = new Shift(id, date, shiftStart, shiftEnd, comment,
                        new Staff(staffId), new Room(roomId));
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public ArrayList<Shift> getShift(String dayStart, String dayEnd) {
        shiftResult = new ArrayList<>();
        String sql = "Select * from shift WHERE shiftStart >= '" + dayStart + "' AND shiftEnd <= '" + dayEnd + "';";
        try {

            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                String roomId = rs.getString("roomId");

                Shift s1 = new Shift(id, date, shiftStart, shiftEnd, comment,
                        new Staff(staffId), new Room(roomId));
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public void insertShift(int id, String date, String shiftStart,
            String shiftEnd, Staff staff, Room room) {
        try {
            String sql = "INSERT INTO Shift VALUES (" + id + ", " + date + ", "
                    + shiftStart + ", " + shiftEnd + ", " + staff.getId() + ", "
                    + room.getId() + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateShift(String newId, String newDate, String newShiftStart,
            String newShiftEnd, int newStaffId, String newRoomId, int uniqueId) {
        try {
            String sql = " UPDATE shift SET id=" + newId + " , date=" + newDate
                    + ", " + " shiftStart=" + newShiftStart + " , shiftEnd="
                    + newShiftEnd + ", " + "staffId=" + newStaffId + " , roomId="
                    + newRoomId + " WHERE id=" + uniqueId + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);
        }
    }
}
