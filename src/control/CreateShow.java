package control;

import handler.ShiftHandler;
import java.util.ArrayList;
import model.Absence;
import model.ActualCompetance;
import model.Competance;
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
    private Competance compentence;
    private ActualCompetance actualcompentence;
    private Student student;
    private Employee employee;
    private Message message;

    public CreateShow(Staff staff, Shift shift, Room room, Absence absence,
            Competance compentence, ActualCompetance actualcompentence,
            Student student, Employee employee, Message message) {
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

    public void createWeek() {

    }

    public void showWeek(String monDate, String tuesDate, String wednesDate,
            String thursDate, String friDate, String saturDate, String sunDate) {
        ShiftHandler sh = new ShiftHandler();

        ArrayList<Shift> monday = new ArrayList<>();
        monday = sh.getShift(monDate);
        sortByRoom(monday);

        ArrayList<Shift> tuesday = new ArrayList<>();
        tuesday = sh.getShift(tuesDate);
        sortByRoom(tuesday);

        ArrayList<Shift> wednesday = new ArrayList<>();
        wednesday = sh.getShift(wednesDate);

        ArrayList<Shift> thursday = new ArrayList<>();
        thursday = sh.getShift(thursDate);
        sortByRoom(wednesday);

        ArrayList<Shift> friday = new ArrayList<>();
        friday = sh.getShift(friDate);
        sortByRoom(thursday);

        ArrayList<Shift> saturday = new ArrayList<>();
        saturday = sh.getShift(saturDate);
        sortByRoom(friday);

        ArrayList<Shift> sunday = new ArrayList<>();
        sunday = sh.getShift(sunDate);
        sortByRoom(sunday);

        ArrayList<ArrayList<Shift>> week = new ArrayList<>();

        week.add(monday);
        week.add(tuesday);
        week.add(wednesday);
        week.add(thursday);
        week.add(friday);
        week.add(saturday);
        week.add(sunday);

        //sort by room and insert in weekplan.
    }

    public void sortByRoom(ArrayList<Shift> day) {

    }

}
