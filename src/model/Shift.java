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
     * @param date
     */
    public Shift(String date) {
        this.date = date;
    }

    /**
     *
     * @param id
     * @param type
     * @param date
     * @param shiftStart
     * @param shiftEnd
     * @param staff
     * @param room
     * @param comment
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
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public String getShiftStart() {
        return shiftStart;
    }

    /**
     *
     * @param shiftStart
     */
    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    /**
     *
     * @return
     */
    public String getShiftEnd() {
        return shiftEnd;
    }

    /**
     *
     * @param shiftEnd
     */
    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    /**
     *
     * @return
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     *
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", date=" + date + ", shiftStart=" + shiftStart + ", shiftEnd=" + shiftEnd + ", staff=" + staff + ", room=" + room + ", comment=" + comment + '}';
    }

}
