package handler;

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
    
    public EmployeeHandler(){
        dbhandler = DBHandler.getInstance();
    }
    
    public ArrayList<Employee> getEmployee(){
        employeeResult = new ArrayList<>();
        
         try {
            String sql = "Select * From employee";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
        while(rs.next()) {
            int id = rs.getInt("id");
            int tlf = rs.getInt("tlf");
            int mobil = rs.getInt("mobil");
            String mail = rs.getString("mail");
            String occupation = rs.getString("occupation");
            
            Employee e1 = new Employee(id, tlf, mobil, mail, occupation );
            employeeResult.add(e1);
        }
            
         }catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return employeeResult;
    }
}
