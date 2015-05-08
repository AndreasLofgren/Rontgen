package control;

import handler.AbsenceHandler;
import handler.RoomHandler;
import handler.ShiftHandler;
import handler.StaffHandler;
import java.util.ArrayList;
import model.Absence;
import model.ActualCompetence;
import model.Room;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine Staff
 */
public class CreateShow {

    public CreateShow() {

    }

    public ArrayList<ArrayList<Shift>> createWeek(String startDato) {

        ArrayList<Staff> staffs = new ArrayList<>();
        ArrayList<Shift> dayShifts = new ArrayList<>();
        ArrayList<ArrayList<Shift>> shifts = new ArrayList<>();
        ArrayList<Absence> absences = new ArrayList<>();
        ArrayList<Absence> absencesToday = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();

        StaffHandler sh = new StaffHandler();
        staffs = sh.getStaff();

        AbsenceHandler ah = new AbsenceHandler();
        absences = ah.getAbsence();

        shifts.add(dayShifts);

        RoomHandler rh = new RoomHandler();
        rooms = rh.getRoom();

        Shift shift = new Shift(startDato);
        dayShifts.add(shift);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < absences.size(); j++) {
                if (absences.get(j).getDayEnd().equals("")
                        || absences.get(j).getDayEnd().equals(dayShifts.get(0).getDate()) // || staffs.getActive()
                        ) {
                    absencesToday.add(absences.get(j));
                }
            }
            for (int j = 0; j < dayShifts.size() - absencesToday.size(); j++) {

                if (j == 0 || dayShifts.get(j - 1).getDate().equals(shift.getDate())) {
                    dayShifts.add(shift);
                } else {
                    ArrayList<Shift> nextDay = new ArrayList<>();
                    nextDay.add(shift);
                    shifts.add(nextDay);
                }

                if (dayShifts.get(j).getRoom() == null) {
                    System.out.println("Room is null" + rooms.size());
                    boolean foundRoom = false;
                    for (int l = 0; l < rooms.size(); l++) {

                        if (rooms.get(l).getStatus().equals("Åben") && !foundRoom) {
                            foundRoom = true;
                            dayShifts.get(j).setRoom(rooms.get(l));
                            System.out.println("Første if sætning: " + dayShifts.get(j).getRoom().toString());
                        } else {
                            System.out.println(dayShifts.get(j).getRoom().toString() + "lukket");
                        }
                    }
                    if (dayShifts.get(j).getRoom() == null) {
                        System.out.println("OOPS - room is still null!");
                    } else {
                        System.out.println("Room found");
                    }

                }

//                shufflePriority(staffs);
                for (int l = 0; l < staffs.size(); l++) {
                    ActualCompetence aComp = new ActualCompetence(staffs.get(l));
                    for (int m = 0; m < absencesToday.size(); m++) {
                        if (staffs.get(l).getId() == absencesToday.get(m).getStaff().getId()) {
                            staffs.remove(l);
                        } else if (aComp.getCompetance().getSkill().equals(dayShifts.get(j).getRoom().getType())) {
                            dayShifts.get(j).setStaff(staffs.get(l));
                        }
                    }

                }

            }
        }
        return shifts;
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
