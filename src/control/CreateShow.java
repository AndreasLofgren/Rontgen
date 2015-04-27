package control;

import handler.ShiftHandler;
import java.util.ArrayList;
import model.Absence;
import model.ActualCompetence;
import model.Competence;
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
    private Competence competance;
    private ActualCompetence actualCompetance;
    private Student student;
    private Employee employee;
    private Message message;

    public CreateShow(Staff staff, Shift shift, Room room, Absence absence,
            Competence competance, ActualCompetence actualCompetance,
            Student student, Employee employee, Message message) {
        this.staff = staff;
        this.shift = shift;
        this.room = room;
        this.absence = absence;
        this.competance = competance;
        this.actualCompetance = actualCompetance;
        this.student = student;
        this.employee = employee;
        this.message = message;
    }

    public void createWeek() {

    }

    public void showWeek(String monDate, String tuesDate, String wednesDate,
            String thursDate, String friDate, String saturDate, String sunDate) {
        
        ArrayList<Shift> monday = showDay(monDate);

        ArrayList<Shift> tuesday = showDay(tuesDate);

        ArrayList<Shift> wednesday = showDay(wednesDate);
        
        ArrayList<Shift> thursday = showDay(thursDate);
        
        ArrayList<Shift> friday = showDay(friDate);
        
        ArrayList<Shift> saturday = showDay(saturDate);
        
        ArrayList<Shift> sunday = showDay(sunDate);
        
        ArrayList<ArrayList<Shift>> week = new ArrayList<>();

        week.add(monday);
        week.add(tuesday);
        week.add(wednesday);
        week.add(thursday);
        week.add(friday);
        week.add(saturday);
        week.add(sunday);

        //sort by room and insert in weekplan.
        insertInRooms(week);
        
    }
    
    
    private ArrayList<Shift> showDay(String date) {
        ArrayList<Shift> day = new ArrayList<>();
        ShiftHandler sh = new ShiftHandler();
        day = sh.getShift(date);
        sortByRoom(day);
        return day;
    }

    private void sortByRoom(ArrayList<Shift> day) {

    }

    private void insertInRooms(ArrayList<ArrayList<Shift>> week) {
        
        ArrayList<Room> rooms = new ArrayList<>();        
        if (week.get(1).get(1).getRoom().getId() == rooms.get(1).getId()) {
            
        }
    }


}
