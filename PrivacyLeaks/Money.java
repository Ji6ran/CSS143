/**
 * Created by Jibran on 4/26/19.
 */
import java.text.*;
public class Money implements Comparable {
    private int dollars;
    private int cents;

    /**
     * Constructor that takes in only dollars.
     * @param dol
     */
    public Money(int dol) {
        setDollars(dol);
    }

    /**
     * Constructor that takes in dollars and cents
     * @param dol
     * @param cent
     */
    public Money(int dol, int cent) {
        setDollars(dol);
        setCents(cent);
    }

    /**
     * Copy constructor
     * @param other
     */
    public Money(Money other) {
        if(other == null) {
            return;
        }
        this.dollars = other.dollars;
        this.cents = other.cents;
    }

    public int getDollars() {
        return this.dollars;
    }


    public int getCents() {
        return this.cents;
    }

    public double getMoney() {
        return this.dollars + ((double)this.cents / 100);
    }

    private void setDollars(int dollars) {
        if(dollars < 0) {
            System.out.println("Dollars can't be negative");
            return;
        }
        this.dollars = dollars;
    }

    private void setCents(int cents) {
        if(cents < 0) {
            System.out.println("Cents can't be negative");
            return;
        }
        if(cents >= 0 && cents < 100) {
            this.cents += cents;
        }
        if(cents >= 100) { // same logic from add(int dol, int cents) applied here, enforcing invariants for if
                           // the cents go over 100
            int tempDol = cents / 100;
            this.dollars += tempDol;
            this.cents = (cents % 100);
        }
    }

    public void setMoney(int dollar, int cent) {
        setDollars(dollar); // using setters because invariants are being enforced.
        setCents(cent);
    }

    public void add(int dol) {
        if(dol >= 0) {
            this.dollars += dol;
        }
    }

    public void add(int dol, int cents) {
        if(dol < 0) { // enforcing invariants so money can't be negative, same for line 78
            System.out.println("Dollars can't be negative");
            return;
        }
        else if(cents < 0) {
            System.out.println("Cents can't be negative");
            return;
        }
        else {
            this.dollars += dol;
            if (cents <= 99 && cents >= 0) { // enforcing invariants for cents
                this.cents += cents;
            }
            if (cents >= 100) {
                int tempDol = cents / 100; // tempdollars takes the cents and divides by 100
                this.dollars += tempDol; // class level dollars adds whatever dollars were left over, and because it's
                                         // an int, everything after the whole number gets cut off.
                this.cents += (cents % 100); // cents then = cents % 100.
            }
        }
    }

    public void add(Money other) { // adds money from other Money object.
        this.dollars += other.dollars;
        this.cents += other.cents;
    }

    public boolean equals(Object other) {
        if(other == null || !(other instanceof Money)) {
            return false;
        }

        Money that = (Money)other;
        return (this.dollars == that.dollars) && (this.cents == that.cents);
    }

    @Override
    public String toString() {
        // Using the DecimalFormat object to format it correctly up to 2 decimal places, and then
        // return the formatted money implementing the getMoney() method.
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(getMoney());
    }

	@Override
	public int compareTo(Object o) {
    	if (!(o instanceof Money)) {
    		return 0;
		}
		// TODO Auto-generated method stub
		return 1;
	}
}
