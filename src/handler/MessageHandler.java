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

    public MessageHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public ArrayList<Message> getMessage() {
        messageResult = new ArrayList<>();
        String sql = "Select * from message";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String description = rs.getString("description");
                int staffId = rs.getInt("staffId");

                Message m1 = new Message(description, new Staff(staffId));
                messageResult.add(m1);
            }

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());

        }
        return messageResult;
    }

    public void insertMesssage(Message message) {
        String sql = "INSERT INTO Message VALUES (" + message.getDescription()
                + ", " + message.getStaff().getId() + ")";
        try {
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

    public void updateMessage(Message message, int id) {
        String sql = " UPDATE Message SET description = " + message.getDescription()
                + " , staffId = " + message.getStaff().getId() + " WHERE id ="
                + id;
        try {

            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex);
        }
    }

}
