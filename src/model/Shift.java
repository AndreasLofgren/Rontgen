package model;

/**
 *
 * @author stine
 */
public class Shift {

    private int id;
    private String date;
    private String shiftStart;
    private String shiftEnd;
    private Staff staff;
    private Room room;
    private String comment;

    public Shift(String date) {
        this.date = date;
    }

    
    public Shift(int id, String date, String shiftStart, String shiftEnd, String comment,
            Staff staff, Room room) {
        this.id = id;
        this.date = date;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.comment = comment;
        this.staff = staff;
        this.room = room;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    public String getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", date=" + date + ", shiftStart=" + shiftStart + ", shiftEnd=" + shiftEnd + ", staff=" + staff + ", room=" + room + ", comment=" + comment + '}';
    }

}
