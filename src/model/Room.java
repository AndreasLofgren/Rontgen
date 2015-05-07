package model;

/**
 *
 * @author stine
 */
public class Room {

    private String id;
    private String type;
    private String status;
    private int minStaffAmount;
    private int maxStaffAmount;
    private String validFrom;

    public Room(String id, String type, String status, int minStaffAmount,
            int maxStaffAmount, String validFrom) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.minStaffAmount = minStaffAmount;
        this.maxStaffAmount = maxStaffAmount;
        this.validFrom = validFrom;
    }

    public Room(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getMinStaffAmount() {
        return minStaffAmount;
    }

    public void setMinStaffAmount(int minStaffAmount) {
        this.minStaffAmount = minStaffAmount;
    }

    public int getMaxStaffAmount() {
        return maxStaffAmount;
    }

    public void setMaxStaffAmount(int maxStaffAmount) {
        this.maxStaffAmount = maxStaffAmount;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", type=" + type + ", status=" + status + ", minStaffAmount=" + minStaffAmount + ", maxStaffAmount=" + maxStaffAmount + ", validFrom=" + validFrom + '}';
    }

}
