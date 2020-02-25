/**
 * Created by Jibran on 4/26/19.
 */
package timeStamp;

public class Date implements Comparable {
    private int day;
    private int month;
    private int year;

    /**
     * Constructor tha takes in month day and year
     * @param month
     * @param day
     * @param year
     */
    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year); // using setters here because the invariants are enforced in the setters.
    }

    /**
     * Copy constructor
     * @param other
     */
    public Date(Date other) {
        if(other == null) {
            return;
        }
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    /**
     * Setter for day of Date
     * @param day
     */
    public void setDay(int day) {
        if(day < 1 || day > 31) { // enforcing invariants with days being 1-31
            System.out.println("Day can only be between 1 and 31");
            this.day = 3;
            return;
        }
        else {
            this.day = day;
        }
    }

    /**
     * Setter for month of Date
     * @param month
     */
    public void setMonth(int month) {
        if(month < 1 || month > 12) { // enforcing invariants with month being 1-12
            System.out.println("Month can only be between 1 and 12");
            this.month = 1;
            return;
        }
        else {
            this.month = month;
        }
    }

    /**
     * Setter for year of Date
     * @param year
     */
    public void setYear(int year) {
        if(year < 2014 || year > 2024) { // enforcing invariants with year being 2014-2024
            this.year = 2014;
            return;
        }
        else {
            this.year = year;
        }
    }

    /**
     * Getter for Day
     * @return
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Getter for Month
     * @return
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Getter for Year
     * @return
     */
    public int getYear() {
        return this.year;
    }

    /**
     * equals() method to compare two dates based on day, month, and year
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Date)) {
            return false;
        }
        Date that = (Date)o;
        // returns true if both Date objects' day month and year are the same.
        return (this.day == that.day) && (this.month == that.month) && (this.year == that.year);
    }

    /**
     * After() method to tell whether or not a date is after another.
     * @param o
     * @return
     */
    public boolean after(Date o) {
        if(o == null) { // if the date is null that you're passing in, then return false
            return false;
        }
        // if the month, day, and year are less than or equal to the date you're comparing to, then return false
        else if((this.month <= o.month) && (this.day <= o.day) && (this.year <= o.year)) {
            return false;
        }
        // if none of the above conditions have been met, return true.
        else {
            return true;
        }
    }

    /**
     * compareTo method which compares years, year and month, and then year, month and day to account for which
     * value to return
     * @param o
     * @return
     */
    @Override
	public int compareTo(Object o) {
    	Date that = (Date)o;
    	if (this.year < that.year) {
    		return -1;
		}
		else if (this.year > that.year) {
    		return 1;
		}
		else if (this.year == that.year && this.month < that.month) {
    		return -1;
		}
		else if (this.year == that.year && this.month > that.month) {
    	    return 1;
        }
        else if (this.year == that.year && this.month == that.month && this.day < that.day) {
    	    return -1;
        }
        else if (this.year == that.year && this.month == that.month && this.day > that.day) {
    	    return 1;
        }
        else {
    	    return 0;
        }
	}

    /**
     * toString() method to return the date
     * @return
     */
    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }
}
