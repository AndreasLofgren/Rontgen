package model;

/**
 *
 * @author stine
 */
public class Competence {

    private String skill;
    private Room room;

    public Competence(String skill) {
        this.skill = skill;
    }

    public Competence(String skill, Room room) {
        this.skill = skill;
        this.room = room;

    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Competence{" + "skill=" + skill + ", room=" + room + '}';
    }

}
