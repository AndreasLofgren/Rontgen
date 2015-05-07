package control;

import handler.ShiftHandler;
import handler.StaffHandler;
import java.util.ArrayList;
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

        ArrayList<ArrayList<Shift>> dagsVagt = new ArrayList<>();

        for (int i = 0; i < staffs.size(); i++) {

            for (int j = 0; j < shifts.size(); j++) {

                if (staffs.get(i).equals(shifts.get(j).getStaff())) {

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
}
