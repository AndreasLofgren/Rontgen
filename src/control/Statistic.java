package control;

import handler.AbsenceHandler;
import handler.ShiftHandler;
import handler.StaffHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.Absence;
import model.Shift;
import model.Staff;

/**
 *
 * @author stine, andreas
 */
public class Statistic {

    /**
     *
     * @param type the type of shift
     * @return an arraylist of arraylist of shift object 
     * @throws FileNotFoundException if Database.ini is not found
     */
    public ArrayList<ArrayList<Shift>> createDagsvagt(String type) throws FileNotFoundException {

        ShiftHandler sh = new ShiftHandler();
        ArrayList<Shift> shifts = sh.getShiftByType(type);

        StaffHandler st = new StaffHandler();
        ArrayList<Staff> staffs = st.getStaff();

        ArrayList<Shift> vagtRum = new ArrayList<>();
        ArrayList<ArrayList<Shift>> dagsVagt = new ArrayList<>();
        dagsVagt.add(vagtRum);

        System.out.println("Antal ansatte: " + staffs.size());

        for (int i = 0; i < staffs.size(); i++) {

//            ArrayList<Shift> shiftsPerson = sh.getShift(staffs.get(i).getId());
            System.out.println("Antal vagter: " + shifts.size());

            for (int j = 0; j < shifts.size(); j++) {

                System.out.println("Ansat: " + staffs.get(i).toString());
                System.out.println("Vagt: " + shifts.get(j).getStaff().toString()); //staffHandler laver objekter med alle felter. Shift.getStaff laver objekter med staffId.

                if (staffs.get(i).getId() == shifts.get(j).getStaff().getId()) {

                    System.out.println("dagsVagt: " + dagsVagt.size());

                    shifts.get(j).setStaff(staffs.get(i));

                    for (int k = 0; k < dagsVagt.size(); k++) {

                        if (vagtRum.isEmpty()) {
                            vagtRum.add(shifts.get(j));
                        } else {
                            System.out.println("dagsVagter i rum: " + vagtRum.size());
                            for (int l = 0; l < vagtRum.size(); l++) {

//                            ArrayList shiftsRoom = sh.getShift();
                                System.out.println("dagsVagt: " + dagsVagt.get(k).toString());

                                if (l == 0) {
                                    vagtRum.add(shifts.get(j));
                                } else if (shifts.get(j).getRoom().equals(vagtRum.get(l - 1).getRoom())) {
                                    vagtRum.add(shifts.get(j)); // tilføjer konstant den samme vagt

                                    System.out.println("Rum 1: " + shifts.get(j).getRoom());
                                    System.out.println("Rum 2: " + vagtRum.get(l - 1).getRoom());
                                    System.out.println("");

                                } else {
                                    ArrayList<Shift> newDagsVagt = new ArrayList<>();
                                    dagsVagt.add(newDagsVagt);
                                    newDagsVagt.add(shifts.get(j));
                                    System.out.println("");

                                }
                            }
                        }

                        System.out.println("");
                        System.out.println("Antal vagter: " + dagsVagt.get(k).size());
                    }
                }
            }

            System.out.println("----");
        }
        return dagsVagt;
    }

    /**
     *
     * @param type the type of shift
     * @return an arraylist of arraylist of shift object 
     * @throws FileNotFoundException if Database.ini is not found
     */
    public ArrayList<Shift> createVagt(String type) throws FileNotFoundException {

        ShiftHandler sh = new ShiftHandler();
        ArrayList<Shift> shifts = sh.getShiftByType(type);

        StaffHandler st = new StaffHandler();
        ArrayList<Staff> staffs = st.getStaff();

        ArrayList<Shift> vagt = new ArrayList<>();

        System.out.println("Antal ansatte: " + staffs.size());
        for (int i = 0; i < staffs.size(); i++) {

            System.out.println("Antal vagter: " + shifts.size());
            for (int j = 0; j < shifts.size(); j++) {

                System.out.println("Nuværende ansat: " + staffs.get(i).toString());
                System.out.println("Nuværende vagt: " + shifts.get(j).toString());

                if (staffs.get(i).getId() == shifts.get(j).getStaff().getId()) {
                    shifts.get(j).setStaff(staffs.get(i));
                    vagt.add(shifts.get(j));
                }
            }
            System.out.println("Antal vagter tilføjet: " + vagt.size());
        }

        return vagt;
    }

    /**
     *
     * @param dayBegyn the first day of the absence
     * @param daySlut the last day of the absence
     * @return an arraylist of arraylist of shift object 
     * @throws FileNotFoundException if Database.ini is not found
     */
    public ArrayList<ArrayList<Absence>> createfravaer(String dayBegyn, String daySlut) throws FileNotFoundException {

        AbsenceHandler ab = new AbsenceHandler();
        ArrayList<Absence> absence = ab.getAbsence(dayBegyn, daySlut);

        StaffHandler st = new StaffHandler();
        ArrayList<Staff> staffs = st.getStaff();

        ArrayList<ArrayList<Absence>> absences = new ArrayList<>();

        System.out.println("Antal fravær: " + absence.size());
        for (int i = 0; i < absence.size(); i++) {

            System.out.println("Antal ansatte: " + staffs.size());
            for (int j = 0; j < staffs.size(); j++) {

                System.out.println("Nuværende ansat: " + staffs.get(j).toString());
                System.out.println("Check fravær for: " + absence.get(i).getStaff().toString());

                if (staffs.get(j).getId() == absence.get(i).getStaff().getId()) {

                    System.out.println("Antal ansatte med fravær: " + absences.size());
                    for (int k = 0; k < absences.size(); k++) {

                        System.out.println("Fravær: " + absences.get(k).size());
                        for (int l = 0; l < absences.get(k).size(); l++) {

                            if (absences.get(k).isEmpty()) {
                                absences.get(k).add(absence.get(i));

                            } else if (absences.get(k).get(l - 1).getStaff().equals(staffs.get(j))) {
                                absences.get(k).add(absence.get(i));

                            } else {
                                ArrayList<Absence> newAbsence = new ArrayList<>();
                                absences.add(newAbsence);
                                newAbsence.add(absence.get(i));
                            }
                        }
                    }
                }
            }
        }
        return absences;
    }
}
