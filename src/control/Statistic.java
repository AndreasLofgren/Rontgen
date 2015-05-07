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

    public ArrayList<ArrayList<Shift>> createDagsvagt() {
        ArrayList<Shift> shifts = new ArrayList<>();
        ShiftHandler sh = new ShiftHandler();
        shifts = sh.getShift();

        ArrayList<Staff> staffs = new ArrayList<>();
        StaffHandler st = new StaffHandler();
        staffs = st.getStaff();

        ArrayList<ArrayList<Shift>> dagsVagt = new ArrayList<>();

        for (int i = 0; i < staffs.size(); i++) {

            for (int j = 0; j < shifts.size(); j++) {

                if (staffs.get(i).equals(shifts.get(j).getStaff())) {

                    if (shifts.get(j).getShiftStart() <= "7:30:00" && shifts.get(j).getShiftEnd() <= "15:30:00") {

                        for (int k = 0; k < dagsVagt.size(); k++) {
                            for (int l = 0; l < dagsVagt.get(k).size(); l++) {

                                if (dagsVagt.get(k).isEmpty() || shifts.get(j).getRoom().equals(dagsVagt.get(k).get(l - 1))) {
                                    dagsVagt.get(k).add(shifts.get(j));

                                } else {
                                    ArrayList<Shift> vagt = new ArrayList<>();
                                    dagsVagt.add(vagt);
                                    vagt.add(shifts.get(j));
                                }

                            }

                        }
                    }

                }

            }
        }
        return dagsVagt;
    }

    public void createfravaer(String dayBegyn, String daySlut) {
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
