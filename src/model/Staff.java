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

    public Staff(int id) {
        this.id = id;
    }

    public Staff(int id, String firstName, String lastName, String nickname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickname=" + nickname + '}';
    }

}
