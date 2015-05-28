package handler;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Staff;

/**
 *
 * @author stine
 */
public class StaffHandler {

    private DBHandler dbhandler;
    private ArrayList<Staff> staffResult;

    /**
     *
     * @throws FileNotFoundException
     */
    public StaffHandler() throws FileNotFoundException {
        dbhandler = DBHandler.getInstance();
    }

    /**
     *
     * @return
     */
    public ArrayList<Staff> getStaff() {
        staffResult = new ArrayList<>();
        String sql = "Select * From staff";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String nickname = rs.getString("nickname");

                Staff s1 = new Staff(id, firstName, lastName, nickname);
                staffResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return staffResult;
    }

    /**
     *
     * @param date
     * @return
     */
    public ArrayList<Staff> getStaffForToday(String date) {
        staffResult = new ArrayList<>();
        String sql = "select * from staff where id NOT IN (select staffId from absence where dayEnd = null OR dayEnd = " + date + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String nickname = rs.getString("nickname");

                Staff s1 = new Staff(id, firstName, lastName, nickname);
                staffResult.add(s1);

            }
        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return staffResult;
    }

    /**
     *
     * @param staff
     */
    public void insertStaff(Staff staff) {
        String sql = "INSERT INTO Staff VALUES(" + staff.getId() + ", " + staff.getFirstName()
                + ", " + staff.getLastName() + "," + staff.getNickname() + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    /**
     *
     * @param staff
     * @param id
     */
    public void updateStaff(Staff staff, int id) {
        String sql = " UPDATE Staff SET Id = " + staff.getId() + " , firstName = "
                + staff.getFirstName() + " , lastName = " + staff.getLastName() + " , nickname = "
                + staff.getNickname() + " WHERE id = " + id;
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }
}
