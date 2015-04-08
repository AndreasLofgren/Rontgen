
package model;

import java.time.LocalTime;

/**
 *
 * @author stine
 */
public class Actualcompentence {
    private LocalTime expirationDate;
    private Compentences compentence;
    private Staff staff;

    public Actualcompentence(LocalTime expirationDate, Compentences compentence, Staff staff) {
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

    public LocalTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalTime expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    
}
