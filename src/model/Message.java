
package model;

/**
 *
 * @author stine
 */
public class Message {
    private String description;
    private Staff staff;

    public Message(String description, Staff staff) {
        this.description = description;
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
