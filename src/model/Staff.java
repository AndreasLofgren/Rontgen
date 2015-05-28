package model;

/**
 *
 * @author stine
 */
public class Staff {

    private int id;
    private String firstName;
    private String lastName;
    private String nickname;

    /**
     *
     * @param id the id of the staff
     */
    public Staff(int id) {
        this.id = id;
    }

    /**
     *
     * @param id the id of the staff
     * @param firstName the first name of the staff
     * @param lastName the last name of the staff
     * @param nickname the nickname of the staff
     */
    public Staff(int id, String firstName, String lastName, String nickname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;

    }

    /**
     *
     * @return the id of the staff
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the staff
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the first name of the staff
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName the first name of the staff
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return the last name of the staff
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName the last name of the staff
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return the nickname of the staff
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname the nickname of the staff
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickname=" + nickname + '}';
    }

}
