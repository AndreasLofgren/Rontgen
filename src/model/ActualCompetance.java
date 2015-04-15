package model;

/**
 *
 * @author stine
 */
public class ActualCompetance {

    private String expirationDate;
    private Competance competance;
    private Staff staff;

    public ActualCompetance(String expirationDate, Competance competance,
            Staff staff) {
        this.expirationDate = expirationDate;
        this.competance = competance;
        this.staff = staff;
    }

    public Competance getCompetance() {
        return competance;
    }

    public void setCompetance(Competance competance) {
        this.competance = competance;
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
