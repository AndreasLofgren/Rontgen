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

    /**
     *
     * @throws FileNotFoundException
     */
    public DBHandler() throws FileNotFoundException {
        String[] params = loadFromFile();
        for (String param : params) {
            System.out.println(param);
        }
        startForbindelse(params);

    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     */
    public static DBHandler getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new DBHandler();
        }
        return instance;
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     */
    public String[] loadFromFile() throws FileNotFoundException {
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
            throw new FileNotFoundException("Database.ini filen kunne ikke findes. Den skal ligge i dist-mappen.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bound: " + e.getMessage());
            throw new ArrayIndexOutOfBoundsException("Der mangler parametre i database.ini filen");
        } catch (ArrayStoreException e) {
            System.out.println("Wrong object: " + e.getMessage());
            throw e;
        }
        return params;
    }

    /**
     *
     * @param parameter
     */
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

    /**
     *
     * @return
     */
    public Statement getStmt() {
        return stmt;
    }

}
