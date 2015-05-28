package model;

/**
 *
 * @author stine
 */
public class Message {

    private String description;
    private Staff staff;

    /**
     *
     * @param description the content of the message
     * @param staff the staff object
     */
    public Message(String description, Staff staff) {
        this.description = description;
        this.staff = staff;
    }

    /**
     *
     * @return the staff object
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff the staff object
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return the content of the message
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description the content of the message
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
