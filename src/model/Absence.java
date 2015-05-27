package model;

/**
 *
 * @author stine
 */
public class Absence {

    private Staff staff;
    private String dayStart;
    private String dayEnd;

    /**
     *
     * @param staff the staff object
     * @param dayStart the first day of absence
     * @param dayEnd the last day of absence
     */
    
    public Absence(Staff staff, String dayStart, String dayEnd) {
        this.staff = staff;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    /**
     *
     * @return the staff object
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff the staff object
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return the start of the day
     */
    public String getDayStart() {
        return dayStart;
    }

    /**
     *
     * @param dayStart the start of the day
     */
    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    /**
     *
     * @return the last day of absence
     */
    public String getDayEnd() {
        return dayEnd;
    }

    /**
     *
     * @param dayEnd the last day of absence
     */
    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Override
    public String toString() {
        return "Absence{" + "staff=" + staff + ", dayStart=" + dayStart + ", dayEnd=" + dayEnd + '}';
    }

}
