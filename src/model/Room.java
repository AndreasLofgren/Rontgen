package model;

/**
 *
 * @author stine
 */
public class Room {
    private int id;
    private String type;
    private String status;
    private int staffAmount;
    

    public Room(int id, String type, String status, int staffAmount) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.staffAmount = staffAmount;
    }

    public Room(int room) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStaffAmount() {
        return staffAmount;
    }

    public void setStaffAmount(int staffAmount) {
        this.staffAmount = staffAmount;
    }
    
    
    
}
