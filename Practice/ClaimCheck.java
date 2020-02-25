

public class ClaimCheck {

    private Date pickupDate;
    private int numberItems;

    public ClaimCheck(ClaimCheck other) {
        this.pickupDate = other.pickupDate;
        this.numberItems = other.numberItems;
    }

    public boolean equals(Object inputObject) { /* Do not critique this method; assume it works*/ return false; }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public int getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }
}

 class Date {
    public int month, day, year;

    public Date() { /* Do not critique this; assume it works*/ }

    public Date(int m, int d, int y) {
        setDay(d);

        setMonth(m);
        setYear(y);
    }

    public Date(Date inDate) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean equals(Object inputObject) { /* Do not critique this method; assume it works*/ return false; }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

}
