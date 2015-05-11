package control;

import handler.AbsenceHandler;
import handler.ShiftHandler;
import handler.StaffHandler;
import java.util.ArrayList;
import model.Absence;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine, andreas
 */
public class Statistic {

    public ArrayList<ArrayList<Shift>> createDagsvagt(String dayStart, String dayEnd) {
        ArrayList<Shift> shifts = new ArrayList<>();
        ShiftHandler sh = new ShiftHandler();
        shifts = sh.getShift(dayStart, dayEnd);

        ArrayList<Staff> staffs = new ArrayList<>();
        StaffHandler st = new StaffHandler();
        staffs = st.getStaff();

        System.out.println("Antal vagter: " + shifts.size() + ". Antal ansatte: " + staffs.size());

        ArrayList<ArrayList<Shift>> dagsVagt = new ArrayList<>();

        for (int i = 0; i < staffs.size(); i++) {
            System.out.println("1. for loop");
            for (int j = 0; j < shifts.size(); j++) {
                System.out.println("2. for loop");
                System.out.println(staffs.get(i).toString() + " og " + shifts.get(j).getStaff().toString()); //staffHandler laver objekter med alle felter. Shift.getStaff laver objekter med staffId.
                if (staffs.get(i).getId() == shifts.get(j).getStaff().getId()) {

                    System.out.println("if sætning");
                    int k = 0;
                    int l = 0;

                    if (dagsVagt.get(k).isEmpty() || shifts.get(j).getRoom().equals(dagsVagt.get(k).get(l - 1).getRoom())) {
                        dagsVagt.get(k).add(shifts.get(j));
                        System.out.println("Antal dage med dagsvagter: " + dagsVagt.size());
                        System.out.println("Antal dagsvagter i rummet: " + dagsVagt.get(k).size() + dagsVagt.get(k).get(l).getRoom().toString());
                        l++;

                    } else {
                        ArrayList<Shift> vagt = new ArrayList<>();
                        dagsVagt.add(vagt);
                        vagt.add(shifts.get(j));
                        System.out.println("");
                        k++;

                    }

                }

            }
        }

        return dagsVagt;
    }

    public ArrayList<Shift> createVagt(String dayStart, String dayEnd) {
        ArrayList<Shift> shifts = new ArrayList<>();
        ShiftHandler sh = new ShiftHandler();
        shifts = sh.getShift(dayStart, dayEnd);

        ArrayList<Staff> staffs = new ArrayList<>();
        StaffHandler st = new StaffHandler();
        staffs = st.getStaff();

        ArrayList<Shift> vagt = new ArrayList<>();

        for (int i = 0; i < staffs.size(); i++) {

            for (int j = 0; j < shifts.size(); j++) {

                if (staffs.get(i).equals(shifts.get(j).getStaff())) {
                    vagt.add(shifts.get(j));
                }
            }
        }

        return vagt;
    }

    public ArrayList<ArrayList<Absence>> createfravaer(String dayBegyn, String daySlut) {
        ArrayList<Absence> fravaer = new ArrayList<>();
        AbsenceHandler ab = new AbsenceHandler();
        fravaer = ab.getAbsence(dayBegyn, daySlut);

        ArrayList<Staff> staffs = new ArrayList<>();
        StaffHandler st = new StaffHandler();
        staffs = st.getStaff();

        ArrayList<ArrayList<Absence>> fravear = new ArrayList<>();

        for (int i = 0; i < fravaer.size(); i++) {

            for (int j = 0; j < staffs.size(); j++) {

                if (staffs.get(j).equals(fravaer.get(i).getStaff())) {

                    for (int k = 0; k < fravear.size(); k++) {

                        for (int l = 0; l < fravear.get(k).size(); l++) {

                            if (fravear.get(k).isEmpty() || fravear.get(k).get(l - 1).getStaff().equals(staffs.get(j))) {
                                fravear.get(k).add(fravaer.get(i));

                            } else {
                                ArrayList<Absence> fraver = new ArrayList<>();
                                fravear.add(fraver);
                                fraver.add(fravaer.get(i));
                            }

                        }

                    }
                }

            }

        }
        return fravear;
    }

}
