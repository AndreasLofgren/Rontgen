package model;

/**
 *
 * @author stine
 */
public class Competence {

    private int id;
    private String name;
    private Room room;

    /**
     *
     * @param id the id of the competence
     */
    public Competence(int id) {
        this.id = id;
    }

    /**
     *
     * @param name the name of the competence
     */
    public Competence(String name) {
        this.name = name;
    } 
    
    /**
     *
     * @param id the id of the competence
     * @param name the name of the competence
     * @param room the room object
     */
    public Competence(int id, String name, Room room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }

    /**
     *
     * @return the id of the competence
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the competence
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the name of the competence
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name of the competence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the room object
     */
    public Room getRoom() {
        return room;
    }

    /**
     *
     * @param room the room object
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Competence{" + "id=" + id + ", name=" + name + ", room=" + room + '}';
    }
}
