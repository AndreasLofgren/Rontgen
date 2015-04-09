package model;

/**
 *
 * @author stine
 */
public class Compentences {

    private String skill;
    private Room room;

    public Compentences(String skill) {
        this.skill = skill;
    }  
    
    public Compentences(String skill, Room room) {
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

}
