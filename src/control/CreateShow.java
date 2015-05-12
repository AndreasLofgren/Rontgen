package control;

import handler.ActualCompetenceHandler;
import handler.RoomHandler;
import handler.StaffHandler;
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

    StaffHandler sh = new StaffHandler();
    RoomHandler rh = new RoomHandler();

    ArrayList<Staff> staffs = sh.getStaffForToday();
    ArrayList<ArrayList<Shift>> shifts = new ArrayList<>();
    ArrayList<Room> rooms = rh.getRoom();

    public CreateShow() {

    }

    public ArrayList<ArrayList<Shift>> createWeek(String startDato) {

        System.out.println("Størrelse på uge: " + shifts.size());

        for (int i = 0; i < 7; i++) {
            ArrayList<Shift> dayShifts = new ArrayList<>();
            shifts.add(dayShifts);

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

                    addRoom(shift, aComps);
                }

                if (shift.getRoom() == null) {
                    System.out.println("OOPS - room is still null!");
                    System.out.println("");
                } else {
                    System.out.println("Room found");
                    System.out.println("");
                }
            }

//            startDato = "+1";          !!!! Øg dato med en.!!!!!

            System.out.println("----Næste dag----");
            System.out.println("Størrelse på uge: " + shifts.size());
            for (int j = 0; j < shifts.size(); j++) {
                System.out.println("Antal vagter den " + j + 1 + ". dag: " + shifts.get(j).size());
            }
            
        }
        return shifts;
    }

    private void addRoom(Shift shift, ArrayList<ActualCompetence> aComps) {

        System.out.println("Antal rum: " + rooms.size());
        System.out.println("Antal kompetencer: " + aComps.size());

        boolean foundRoom = false;
        for (int k = 0; k < rooms.size() && !foundRoom; k++) {
            if (rooms.get(k).getStatus().equals("Åben")) {
                for (int l = 0; l < aComps.size(); l++) {

                    System.out.println("Rum: " + rooms.get(k).toString());
                    System.out.println("Kompetence: " + aComps.get(l).toString());

                    if (rooms.get(k).getType().equals(aComps.get(l).getCompetance().getSkill())) {
                        foundRoom = true;
                        shift.setRoom(rooms.get(k));

                        System.out.println("Rummet er sat til " + shift.toString());
                    }
                }
            } else {
                System.out.println(rooms.get(k).toString() + " er lukket");
            }
        }
    }
}
