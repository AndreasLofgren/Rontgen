package control;

import model.Absence;
import model.Actualcompentence;
import model.Compentences;
import model.Employee;
import model.Message;
import model.Room;
import model.Shift;
import model.Staff;
import model.Student;

/**
 *
 * @author stine Staff
 */
public class CreateShow {
    
    private Staff staff;
    private Shift shift;
    private Room room;
    private Absence absence;
    private Compentences compentence;
    private Actualcompentence actualcompentence;
    private Student student;
    private Employee employee;
    private Message message;

    public CreateShow(Staff staff, Shift shift, Room room, Absence absence, Compentences compentence, Actualcompentence actualcompentence, Student student, Employee employee, Message message) {
        this.staff = staff;
        this.shift = shift;
        this.room = room;
        this.absence = absence;
        this.compentence = compentence;
        this.actualcompentence = actualcompentence;
        this.student = student;
        this.employee = employee;
        this.message = message;
    }
    
    public void createStaff(Actualcompentence actualcompentence, Compentences compentence, Student student, Employee employee){
       
    }
    
    
}
