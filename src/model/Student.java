package model;

/**
 *
 * @author stine
 */
public class Student extends Staff {

    private int module;

    /**
     *
     * @param module
     * @param id
     */
    public Student(int module, int id) {
        super(id);
        this.module = module;

    }

    /**
     *
     * @param module
     * @param id
     * @param firstName
     * @param lastName
     * @param nickname
     */
    public Student(int module, int id, String firstName, String lastName,
            String nickname) {
        super(id, firstName, lastName, nickname);
        this.module = module;
    }

    /**
     *
     * @return
     */
    public int getModule() {
        return module;
    }

    /**
     *
     * @param module
     */
    public void setModule(int module) {
        this.module = module;
    }

}
