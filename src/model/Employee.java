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
    
    public Employee(int id, int tlf, int mobil, String mail, String occupation){
        super(id);
        this.tlf = tlf;
        this.mobil = mobil;
        this.mail = mail;
        this.occupation = occupation;
    }

    public Employee(int tlf, int mobil, String mail, String occupation, int id, String firstName, String lastName, String nickname) {
        super(id, firstName, lastName, nickname);
        this.tlf = tlf;
        this.mobil = mobil;
        this.mail = mail;
        this.occupation = occupation;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public int getMobil() {
        return mobil;
    }

    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
