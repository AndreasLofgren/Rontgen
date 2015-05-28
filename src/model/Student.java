package model;

/**
 *
 * @author stine
 */
public class Student extends Staff {

    private int module;

    /**
     *
     * @param module the module the student is on
     * @param id the id of the staff
     */
    public Student(int module, int id) {
        super(id);
        this.module = module;

    }

    /**
     *
     * @param module the module the student is on
     * @param id the id of the staff
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param nickname the nickname of the student
     */
    public Student(int module, int id, String firstName, String lastName,
            String nickname) {
        super(id, firstName, lastName, nickname);
        this.module = module;
    }

    /**
     *
     * @return the module the student is on
     */
    public int getModule() {
        return module;
    }

    /**
     *
     * @param module the module the student is on
     */
    public void setModule(int module) {
        this.module = module;
    }

}
