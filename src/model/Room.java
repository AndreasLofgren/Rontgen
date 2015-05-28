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
     * @param id
     */
    public Room(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param name
     * @param type
     * @param status
     * @param minStaffAmount
     * @param maxStaffAmount
     * @param validFrom
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public int getMinStaffAmount() {
        return minStaffAmount;
    }

    /**
     *
     * @param minStaffAmount
     */
    public void setMinStaffAmount(int minStaffAmount) {
        this.minStaffAmount = minStaffAmount;
    }

    /**
     *
     * @return
     */
    public int getMaxStaffAmount() {
        return maxStaffAmount;
    }

    /**
     *
     * @param maxStaffAmount
     */
    public void setMaxStaffAmount(int maxStaffAmount) {
        this.maxStaffAmount = maxStaffAmount;
    }

    /**
     *
     * @return
     */
    public String getValidFrom() {
        return validFrom;
    }

    /**
     *
     * @param validFrom
     */
    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", minStaffAmount=" + minStaffAmount + ", maxStaffAmount=" + maxStaffAmount + ", validFrom=" + validFrom + '}';
    }
}
