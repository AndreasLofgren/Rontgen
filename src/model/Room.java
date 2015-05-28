package model;

/**
 *
 * @author stine
 */
public class Room {

    private int id;
    private String name;
    private String type;
    private String status;
    private int minStaffAmount;
    private int maxStaffAmount;
    private String validFrom;

    /**
     *
     * @param id the id of the room
     */
    public Room(int id) {
        this.id = id;
    }

    /**
     *
     * @param id the id of the room
     * @param name the name of the room
     * @param type the type of the room
     * @param status the status of the room
     * @param minStaffAmount the minimun amount of staff working in the room
     * @param maxStaffAmount the maximun amount of staff working in the room
     * @param validFrom the date from which this information is valid
     */
    public Room(int id, String name, String type, String status, int minStaffAmount, int maxStaffAmount, String validFrom) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.minStaffAmount = minStaffAmount;
        this.maxStaffAmount = maxStaffAmount;
        this.validFrom = validFrom;
    }

    /**
     *
     * @return the id of the room
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the room
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the type of the room
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type the type of the room
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return the status of the room
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status the status of the room
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return the minimun amount of staff working in the room
     */
    public int getMinStaffAmount() {
        return minStaffAmount;
    }

    /**
     *
     * @param minStaffAmount the minimun amount of staff working in the room
     */
    public void setMinStaffAmount(int minStaffAmount) {
        this.minStaffAmount = minStaffAmount;
    }

    /**
     *
     * @return the maximun amount of staff working in the room
     */
    public int getMaxStaffAmount() {
        return maxStaffAmount;
    }

    /**
     *
     * @param maxStaffAmount the maximun amount of staff working in the room
     */
    public void setMaxStaffAmount(int maxStaffAmount) {
        this.maxStaffAmount = maxStaffAmount;
    }

    /**
     *
     * @return the date from which this information is valid
     */
    public String getValidFrom() {
        return validFrom;
    }

    /**
     *
     * @param validFrom the date from which this information is valid
     */
    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", minStaffAmount=" + minStaffAmount + ", maxStaffAmount=" + maxStaffAmount + ", validFrom=" + validFrom + '}';
    }
}
