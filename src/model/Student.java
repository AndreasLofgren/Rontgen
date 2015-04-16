package model;

/**
 *
 * @author stine
 */
public class Student extends Staff {

    private int module;

    public Student(int module, int id) {
        super(id);
        this.module = module;

    }

    public Student(int module, int id, String firstName, String lastName,
            String nickname) {
        super(id, firstName, lastName, nickname);
        this.module = module;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

}
