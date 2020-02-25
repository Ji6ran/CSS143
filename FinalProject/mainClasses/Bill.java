/**
 * Created by Jibran on 4/26/19.
 */
package mainClasses;
import timeStamp.Date;

public class Bill {

    // instance variables
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * Takes in amount, dueDate, and the company aka originator
     * @param amount
     * @param dueDate
     * @param originator
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this.amount = amount;
        this.originator = originator;
        this.dueDate = dueDate;
        this.paidDate = null;
    }

    /**
     * Copy constructor
     * @param toCopy
     */
    public Bill(Bill toCopy) {
        if(toCopy == null) {
            return;
        }
        this.amount = toCopy.amount;
        this.dueDate = toCopy.dueDate;
        this.paidDate = toCopy.paidDate;
        this.originator = toCopy.originator;
    }

    public Money getAmount() {
        return this.amount;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public String getOriginator() {
        return this.originator;
    }

    public boolean isPaid() {
        if(paidDate == null) {
            return false;
        }
        if(this.paidDate.after(this.dueDate)) {
            return false;
        }
        else {
            return true;
        }
    }

    public void setPaid(Date onDay) {
        if(onDay.after(this.dueDate)) { // if the date you enter is after the due date, you cannot pay
            System.out.println("Cannot pay after the due date");
            System.exit(0);
        }
        this.paidDate = onDay; // saves the paid Date (?)
    }

    public void setUnpaid() {
        this.paidDate = null;
    }

    public void setDueDate(Date nextDate) {
        if(nextDate.after(this.paidDate)) {
            System.out.println("Can't set the due date after the paid date");
            System.exit(0);
        }
        else {
            this.dueDate = nextDate;
        }
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String toString() {
        if(isPaid() == false) { // if the bill hasn't been paid, don't print out a date paid string
            String d = "Amount: " + this.amount + "\n" +
                       "Due Date: " + this.dueDate + "\n" +
                       "Originator: " + this.originator + "\n" +
                       "Paid?: " + isPaid();

            return d;
        }
        else {
            String h = "Amount: " + this.amount + "\n" +
                    "Due Date: " + this.dueDate + "\n" +
                    "Originator: " + this.originator + "\n" +
                    "Paid?: " + isPaid() + "\n" +
                    "Date Paid: " + this.paidDate;

            return h;
        }
    }

    public boolean equals(Bill toCompare) {
        if(toCompare == null) {
            return false;
        }
        // prints out true if the amount, dueDate, paidDate, and originator are the same
        return (this.amount.equals(toCompare.amount)) && (this.dueDate.equals(toCompare.dueDate)) &&
                (this.paidDate.equals(toCompare.paidDate)) && (this.originator.equals(toCompare.originator));
    }

}
