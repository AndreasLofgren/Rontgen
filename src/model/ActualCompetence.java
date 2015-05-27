package model;

/**
 *
 * @author stine
 */
public class ActualCompetence {

    private String expirationDate;
    private Competence competence;
    private Staff staff;

    /**
     *
     * @param staff the staff object
     */
    public ActualCompetence(Staff staff) {
        this.staff = staff;
    }
    
    /**
     *
     * @param expirationDate the date of expiration
     * @param competence the competence object
     * @param staff the staff object
     */
    public ActualCompetence(String expirationDate, Competence competence,
            Staff staff) {
        this.expirationDate = expirationDate;
        this.competence = competence;
        this.staff = staff;
    }

    /**
     *
     * @return the competence object
     */
    public Competence getCompetance() {
        return competence;
    }

    /**
     *
     * @param competence the competence object
     */
    public void setCompetance(Competence competence) {
        this.competence = competence;
    }

    /**
     *
     * @return the staff object
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff the staff object
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return the date of expiration
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     *
     * @param expirationDate the date of expiration
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "ActualCompetence{" + "expirationDate=" + expirationDate + ", competence=" + competence + ", staff=" + staff + '}';
    }

}
