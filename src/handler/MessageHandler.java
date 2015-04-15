/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Message;
import model.Staff;

/**
 *
 * @author stine
 */
public class MessageHandler {

    private DBHandler dbhandler;
    private ArrayList<Message> messageResult;

    private MessageHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Message> getMessage() {
        messageResult = new ArrayList<>();
        try {
            String sql = "Select * from message";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String description = rs.getString("description");
                int staffId = rs.getInt("staffId");

                Message m1 = new Message(description, new Staff(staffId));
                messageResult.add(m1);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());

        }
        return messageResult;
    }

    public void insertMesssage(String description, Staff staff) {
        try {
            String sql = "INSERT INTO Message VALUES (" + description + ", "
                    + staff.getId() + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateMessage(String newdescription, int newstaffId,
            String uniquestaffId) {
        try {
            String sql = "UPDATE Message SET description=" + newdescription
                    + ", staffId=" + newstaffId + " WHERE staffId="
                    + uniquestaffId + ";";
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

}
