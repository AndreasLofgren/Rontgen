package handler;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author stine
 */
public class EmployeeHandler {

    private DBHandler dbhandler;
    private ArrayList<Employee> employeeResult;

    /**
     *
     * @throws FileNotFoundException
     */
    public EmployeeHandler() throws FileNotFoundException {
        dbhandler = DBHandler.getInstance();
    }

    /**
     *
     * @return
     */
    public ArrayList<Employee> getEmployee() {
        employeeResult = new ArrayList<>();
        String sql = "Select * From employee LEFT JOIN Occupation ON employee.ocupationId = occupation.id";
        try {
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int tlf = rs.getInt("tlf");
                int mobil = rs.getInt("mobil");
                String mail = rs.getString("mail");
                String occupation = rs.getString("occupation");

                Employee e1 = new Employee(id, tlf, mobil, mail, occupation);
                employeeResult.add(e1);
            }

        } catch (SQLException ex) {
            System.out.println(sql);
            System.out.println("SQLException" + ex.getMessage());
        }
        return employeeResult;
    }
}
