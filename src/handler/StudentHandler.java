
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author stine
 */
public class StudentHandler {
    
    private DBHandler dbhandler;
    private ArrayList<Student> studentResult;
    
    private StudentHandler(){
        dbhandler = DBHandler.getInstance();
    }
    
    public ArrayList<Student> getStudent(){
        studentResult = new ArrayList<>();
        
        try{
            String sql = "Select * From student";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int module = rs.getInt("module");
                int id = rs.getInt("id");
                
                Student s1 = new Student(module, id);
                studentResult.add(s1);
            }
        }catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return studentResult;
    }
}
