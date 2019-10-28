public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 1;
        denominator = 1;

    }

    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
        reducedForm();

    }

    /**
     * Simplifies fractions to its simplest form. e.g. 9/3 will be 3/1
     */
    public void reducedForm() {
        int n = this.numerator;
        int d = this.denominator;
        int largest = 0;
        int gcd = 1;
        // Simple invariant to check the largest value between the numerator and denominator.
        if (n > d) {
            largest = n;
        }
        else {
            largest = d;
        }
        /*
           using 2 as the least number you can divide by, and if the numerator has a remainder of 0 when
           going into "i" which is the largest value, and the denominator does as well, then that's your
           greatest common denominator. After that, make sure to check once more that if the greatest common divisor
           is not 0, then both the numerator and denominator are itself divided by the greatest common denominator
        */

        for (int i = largest; i >= 2; i--) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                gcd = i;
                break;
            }
        }

        if (gcd != 0) {
            this.numerator /= gcd;
            this.denominator /= gcd;
        }
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Comparing Fraction objects rather than just any general object, so that the program doesn't get confused
     * @param oth
     * @return
     */
    public boolean equals(Fraction oth) {
        if (oth == null) {
            return false;
        }
        // if the Fraction we are passing in is not an instance of the Fraction class, then return false.
        if(!(oth instanceof Fraction)) {
            return false;
        }
        // if none of the above statements get reached, then check to see if they have the same
        // numerator and same denominator. If so, then return true, if either one of these is false
        // then return false.
        return (oth.numerator == this.numerator && oth.denominator == this.denominator);
    }

    /**
     * Setting the fraction that uses num and den as the numerator and denominator
     * @param num
     * @param den
     */
    public void setFraction(int num, int den) {
        // making sure to check if the denominator is 0 or if the numbers are negative
        // to not set the fraction and simply exit out of the method using the return statement

        if (den == 0) {
            System.out.println("Cannot divide by 0");
            return;
        }

        if (num < 0 && den < 0) {
            System.out.println("Cannot have negative numbers");
            return;
        }

        this.numerator = num;
        this.denominator = den;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }


}
