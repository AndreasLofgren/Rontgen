
package model;


/**
 *
 * @author stine
 */
public class Actualcompentence {
    private String expirationDate;
    private Compentences compentence;
    private Staff staff;

    public Actualcompentence(String expirationDate, Compentences compentence, Staff staff) {
        this.expirationDate = expirationDate;
        this.compentence = compentence;
        this.staff = staff;
    }

    public Compentences getCompentence() {
        return compentence;
    }

    public void setCompentence(Compentences compentence) {
        this.compentence = compentence;
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
