package model;

/**
 *
 * @author stine
 */
public class Employee extends Staff {

    private int tlf;
    private int mobil;
    private String mail;
    private String occupation;

    /**
     *
     * @param id the id of the staff
     * @param tlf the worknumber
     * @param mobil the mobilenumber
     * @param mail the e-mail address
     * @param occupation the occupation of the staff
     */
    public Employee(int id, int tlf, int mobil, String mail, String occupation) {
        super(id);
        this.tlf = tlf;
        this.mobil = mobil;
        this.mail = mail;
        this.occupation = occupation;
    }

    /**
     *
     * @param tlf the worknumber
     * @param mobil the mobilenumber
     * @param mail the e-mail address
     * @param occupation the occupation of the staff
     * @param id the id of the staff
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param nickname the nickname of the employee
     */
    public Employee(int tlf, int mobil, String mail, String occupation, int id,
            String firstName, String lastName, String nickname) {
        super(id, firstName, lastName, nickname);
        this.tlf = tlf;
        this.mobil = mobil;
        this.mail = mail;
        this.occupation = occupation;
    }

    /**
     *
     * @return the worknumber
     */
    public int getTlf() {
        return tlf;
    }

    /**
     *
     * @param tlf the worknumber
     */
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    /**
     *
     * @return the mobilenumber
     */
    public int getMobil() {
        return mobil;
    }

    /**
     *
     * @param mobil the mobilenumber
     */
    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    /**
     *
     * @return the e-mail address
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail the e-mail address
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return the occupation of the staff
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation the occupation of the staff
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
