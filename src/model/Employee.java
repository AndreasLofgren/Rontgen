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
     * @param id
     * @param tlf
     * @param mobil
     * @param mail
     * @param occupation
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
     * @param tlf
     * @param mobil
     * @param mail
     * @param occupation
     * @param id
     * @param firstName
     * @param lastName
     * @param nickname
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
     * @return
     */
    public int getTlf() {
        return tlf;
    }

    /**
     *
     * @param tlf
     */
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    /**
     *
     * @return
     */
    public int getMobil() {
        return mobil;
    }

    /**
     *
     * @param mobil
     */
    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
