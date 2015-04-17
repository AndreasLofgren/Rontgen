package handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author stine
 */
public class DBHandler {

    private static DBHandler instance;
    private Statement stmt;

    public DBHandler() {
        String[] params = loadFromFile();
        for (String param : params) {
            System.out.println(param);
        }
        startForbindelse(params);

    }

    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler();
        }
        return instance;
    }

    public String[] loadFromFile() {
        String filename = "Database.ini";
        Scanner textScan;
        String[] params = new String[5];

        System.out.print("Loading: " + filename + "...");
        try {
            File file = new File(filename);
            textScan = new Scanner(file);

            int count = 0;

            while (textScan.hasNextLine() && count < 5) {
                params[count] = textScan.nextLine().trim();
                count++;
            }

            textScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bound: " + e.getMessage());
        } catch (ArrayStoreException e) {
            System.out.println("Wrong object: " + e.getMessage());
        }
        return params;
    }

    public void startForbindelse(String[] parameter) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            String url = "jdbc:mysql://" + parameter[0] + ":" + parameter[1]
                    + "/" + parameter[2];
            System.out.println("url: " + url);
            conn = DriverManager.getConnection(url, parameter[3], parameter[4]);
            stmt = conn.createStatement();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found" + ex.getLocalizedMessage());
        }
    }

    public Statement getStmt() {
        return stmt;
    }

}
