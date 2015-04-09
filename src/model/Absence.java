package model;

/**
 *
 * @author stine
 */
public class Absence {

    private Staff staff;
    private String dayStart;
    private String dayEnd;

    public Absence(Staff staff, String dayStart, String dayEnd) {
        this.staff = staff;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

}
