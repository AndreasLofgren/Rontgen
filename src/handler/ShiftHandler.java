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
        String sql = "Select * from shift";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                int roomId = rs.getInt("roomId");

                Shift s1 = new Shift(id, type, date, shiftStart, shiftEnd,
                        new Staff(staffId), new Room(roomId), comment);
                shiftResult.add(s1);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public ArrayList<Shift> getShiftById(int sId) {
        shiftResult = new ArrayList<>();
        String sql = "Select * from shift WHERE staffId = " + sId;
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                int roomId = rs.getInt("roomId");

                Shift s1 = new Shift(id, type, date, shiftStart, shiftEnd,
                        new Staff(staffId), new Room(roomId), comment);
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public ArrayList<Shift> getShiftByDate(String day) {
        shiftResult = new ArrayList<>();
        String sql = "Select * from shift WHERE dates = " + day;
        try {

            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                int roomId = rs.getInt("roomId");

                Shift s1 = new Shift(id, type, date, shiftStart, shiftEnd,
                        new Staff(staffId), new Room(roomId), comment);
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public ArrayList<Shift> getShiftByType(String shiftType) {
        shiftResult = new ArrayList<>();
        String sql = "Select * from shift WHERE type = " + shiftType;
        try {

            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String date = rs.getString("dates");
                String shiftStart = rs.getString("shiftStart");
                String shiftEnd = rs.getString("shiftEnd");
                String comment = rs.getString("comments");
                int staffId = rs.getInt("staffId");
                int roomId = rs.getInt("roomId");

                Shift s1 = new Shift(id, type, date, shiftStart, shiftEnd,
                        new Staff(staffId), new Room(roomId), comment);
                shiftResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }

        return shiftResult;
    }

    public void insertShift(Shift shift) {
        String sql = "INSERT INTO Shift (type, date, shiftStart, shiftEnd, comment, staffId, roomId) "
                + "VALUES (" + shift.getType() + ", " + shift.getDate() + ", "
                + shift.getShiftStart() + ", " + shift.getShiftEnd() + ", "
                + ", " + shift.getComment() + ", " + shift.getStaff().getId()
                + ", " + shift.getRoom().getId() + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    public void updateShift(Shift shift, int id) {
        String sql = " UPDATE shift SET type = " + shift.getType()
                + " , date = " + shift.getDate() + ", " + " shiftStart = "
                + shift.getShiftStart() + " , shiftEnd = "
                + shift.getShiftEnd() + ", " + "staffId = "
                + shift.getStaff().getId() + " , roomId = "
                + shift.getRoom().getId() + " WHERE id=" + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException " + ex);
        }
    }
}
