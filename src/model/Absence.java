package model;

/**
 *
 * @author stine
 */
public class Absence {

    private int id;
    private Staff staff;

    public Absence(int id, Staff staff) {
        this.id = id;
        this.staff = staff;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
