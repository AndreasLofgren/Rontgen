package control;

import handler.ActualCompetenceHandler;
import handler.RoomHandler;
import handler.StaffHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.ActualCompetence;
import model.Room;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine Staff
 */
public class CreateShow {

    private StaffHandler sh;
    private RoomHandler rh;

    private ArrayList<ArrayList<Shift>> shifts;
    private ArrayList<Room> rooms;

    /**
     *
     * @throws FileNotFoundException if Database.ini is not found
     */
    public CreateShow() throws FileNotFoundException {
        sh = new StaffHandler();
        rh = new RoomHandler();

        shifts = new ArrayList<>();
        rooms = rh.getRoom();

    }

    /**
     *
     * @param startDato
     * @return an arraylist of arraylist of shift object 
     * @throws FileNotFoundException if Database.ini is not found
     */
    public ArrayList<ArrayList<Shift>> createWeek(String startDato) throws FileNotFoundException {

        ArrayList<Staff> staffs = sh.getStaffForToday(startDato);
        System.out.println("Størrelse på uge: " + shifts.size());

        for (int i = 0; i < 7; i++) {
            ArrayList<Shift> dayShifts = new ArrayList<>();
            shifts.add(dayShifts);

            System.out.println("Dato: " + startDato);
            System.out.println("Antal ansatte: " + staffs.size());

//                shufflePriority(staffs);
            for (int j = 0; j < staffs.size(); j++) {

                Shift shift = new Shift(startDato);
                dayShifts.add(shift);

                ActualCompetenceHandler ach = new ActualCompetenceHandler();
                ArrayList<ActualCompetence> aComps = ach.getActualCompetance(staffs.get(j).getId());

                System.out.println("Nuværende ansat: " + staffs.get(j));
                System.out.println("Antal vagter: " + dayShifts.size());

                if (shift.getStaff() == null) {

                    shift.setStaff(staffs.get(j));
                }

                if (shift.getStaff() == null) {
                    System.out.println("OOPS - staff is still null!");
                } else {
                    System.out.println("Staff found");
                }

                if (shift.getRoom() == null) {

                    addRoom(dayShifts, shift, aComps);
                }

                if (shift.getRoom() == null) {
                    System.out.println("OOPS - room is still null!");
                    System.out.println("");
                } else {
                    System.out.println("Room found");
                    System.out.println("");
                }
            }

            startDato = changeDate(startDato);

            System.out.println("----Næste dag----");
            System.out.println("Dato: " + startDato);
            System.out.println("Størrelse på uge: " + shifts.size());
            for (int j = 0; j < shifts.size(); j++) {
                System.out.println("Antal vagter den " + (j + 1) + ". dag: " + shifts.get(j).size());
            }

        }

        return shifts;
    }

    private void addRoom(ArrayList<Shift> shifts, Shift shift, ArrayList<ActualCompetence> aComps) {

        System.out.println("Antal rum: " + rooms.size());
        System.out.println("Antal kompetencer: " + aComps.size());

        boolean foundRoom = false;
        for (int k = 0; k < rooms.size() && !foundRoom; k++) {

            if (rooms.get(k).getStatus().equals("Åben")) {

                int count = 0;

                System.out.println("Rum: " + rooms.get(k));
                for (int i = 0; i < shifts.size() && count < rooms.get(k).getMinStaffAmount(); i++) {

//                    System.out.println("Vagt: " + shifts.get(i));
                    if (i != 0 && shifts.get(i - 1).getRoom() != null && shifts.get(i - 1).getRoom().getName().equals(rooms.get(k).getName())) {
                        count++;
                    }
                }

                if (rooms.get(k).getMinStaffAmount() > count) {

                    for (int l = 0; l < aComps.size(); l++) {

                        System.out.println("Kompetence: " + aComps.get(l).toString());

                        if (rooms.get(k).getType().equals(aComps.get(l).getCompetance().getName())) {
                            foundRoom = true;
                            shift.setRoom(rooms.get(k));

                            System.out.println("Rummet er sat til " + shift.toString());
                        }
                    }
                }
            } else {
                System.out.println(rooms.get(k).toString() + " er lukket");
            }
        }
    }

    private String changeDate(String startDato) {

        int year = Integer.parseInt(startDato.substring(0, 4));
        int month = Integer.parseInt(startDato.substring(5, 7));
        int day = Integer.parseInt(startDato.substring(8));

        int daysInMonth = 0;

        switch (month) {
            case 1:
                daysInMonth = 31;
                break;
            case 2:
                daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                        || (year % 400 == 0) ? 29 : 28;
                break;
            case 3:
                daysInMonth = 31;
                break;
            case 4:
                daysInMonth = 30;
                break;
            case 5:
                daysInMonth = 31;
                break;
            case 6:
                daysInMonth = 30;
                break;
            case 7:
                daysInMonth = 31;
                break;
            case 8:
                daysInMonth = 31;
                break;
            case 9:
                daysInMonth = 30;
                break;
            case 10:
                daysInMonth = 31;
                break;
            case 11:
                daysInMonth = 30;
                break;
            case 12:
                daysInMonth = 31;
                break;
            default:
                daysInMonth = 30;
        }

        if (day < daysInMonth) {
            day++;

        } else if (day == daysInMonth) {
            day = 1;

            if (month < 12) {
                month++;

            } else {
                month = 1;
                year++;
            }
        } else {
            System.out.println("Du prøver at lave en dag som ikke er mulig. " + day);
        }

        if (day < 10 && month < 10) {
            startDato = year + "-0" + month + "-0" + day;
        } else if (day < 10) {
            startDato = year + "-" + month + "-0" + day;
        } else if (month < 10) {
            startDato = year + "-0" + month + "-" + day;
        } else {
            startDato = year + "-" + month + "-" + day;
        }

        return startDato;

    }
}
