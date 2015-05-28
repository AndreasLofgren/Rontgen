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
     * @param id
     */
    public Staff(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param nickname
     */
    public Staff(int id, String firstName, String lastName, String nickname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;

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
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickname=" + nickname + '}';
    }

}
