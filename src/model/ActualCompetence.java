package model;

/**
 *
 * @author stine
 */
public class ActualCompetence {

    private String expirationDate;
    private Competence competence;
    private Staff staff;

    public ActualCompetence(String expirationDate, Competence competence,
            Staff staff) {
        this.expirationDate = expirationDate;
        this.competence = competence;
        this.staff = staff;
    }

    public Competence getCompetance() {
        return competence;
    }

    public void setCompetance(Competence competence) {
        this.competence = competence;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
