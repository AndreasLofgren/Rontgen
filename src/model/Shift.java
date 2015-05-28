package model;

/**
 *
 * @author stine
 */
public class Shift {

    private int id;
    private String type;
    private String date;
    private String shiftStart;
    private String shiftEnd;
    private Staff staff;
    private Room room;
    private String comment;

    /**
     *
     * @param date the date of the shift
     */
    public Shift(String date) {
        this.date = date;
    }

    /**
     *
     * @param id the id of the shift
     * @param type the type of shift
     * @param date the date of the shift
     * @param shiftStart the start of the shift
     * @param shiftEnd the end of the shift
     * @param staff the staff who has the shift
     * @param room the room where the shift is
     * @param comment comment attached to the shift
     */
    public Shift(int id, String type, String date, String shiftStart,
            String shiftEnd, Staff staff, Room room, String comment) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.staff = staff;
        this.room = room;
        this.comment = comment;
    }

    /**
     *
     * @return the id of the shift
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the shift
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the type of shift
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type the type of shift
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return the date of the shift
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date the date of the shift
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return comment attached to the shift
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment comment attached to the shift
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return the start of the shift
     */
    public String getShiftStart() {
        return shiftStart;
    }

    /**
     *
     * @param shiftStart the start of the shift
     */
    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    /**
     *
     * @return the end of the shift
     */
    public String getShiftEnd() {
        return shiftEnd;
    }

    /**
     *
     * @param shiftEnd the end of the shift
     */
    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    /**
     *
     * @return the staff who has the shift
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff the staff who has the shift
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return the room where the shift is
     */
    public Room getRoom() {
        return room;
    }

    /**
     *
     * @param room the room where the shift is
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", date=" + date + ", shiftStart=" + shiftStart + ", shiftEnd=" + shiftEnd + ", staff=" + staff + ", room=" + room + ", comment=" + comment + '}';
    }

}
