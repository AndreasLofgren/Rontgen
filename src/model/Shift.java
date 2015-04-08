package model;

/**
 *
 * @author stine
 */
public class Shift {
    private int id;
    private String type;
    private String shiftStart;
    private String shiftEnd;
    private Staff staff;
    private Room room;
    
    public Shift(int id, String type, String shiftStart, String shiftEnd, Staff staffId, Room roomId) {
        this.id = id;
        this.type = type;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.staff = staff;
        this.room = room;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
