package mainClasses;

import java.io.Serializable;

public class Fraction implements Comparable, Cloneable, Serializable {

    private final double numerator;
    private final double denominator;

    public Fraction() {
        numerator = 1;
        denominator = 1;

    }

    public Fraction(double nume, double deno) {

        double largest = 0;
        double gcd = 1;
        // Simple invariant to check the largest value between the numerator and denominator.
        if (nume > deno) {
            largest = nume;
        }
        else {
            largest = deno;
        }
        /*
           using 2 as the least number you can divide by, and if the numerator has a remainder of 0 when
           going into "i" which is the largest value, and the denominator does as well, then that's your
           greatest common denominator. After that, make sure to check once more that if the greatest common divisor
           is not 0, then both the numerator and denominator are itself divided by the greatest common denominator
        */

        for (double i = largest; i >= 2; i--) {
            if (nume % i == 0 && deno % i == 0) {
                gcd = i;
                break;
            }
        }

        if (gcd != 0) {
            nume /= gcd;
            deno /= gcd;
        }

        this.numerator = nume;
        this.denominator = deno;
    }

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    /**
     * Simplifies fractions to its simplest form. e.g. 9/3 will be 3/1
     */
//    public void reducedForm() {
//        int n = this.numerator;
//        int d = this.denominator;
//        int largest = 0;
//        int gcd = 1;
//        // Simple invariant to check the largest value between the numerator and denominator.
//        if (n > d) {
//            largest = n;
//        }
//        else {
//            largest = d;
//        }
//        /*
//           using 2 as the least number you can divide by, and if the numerator has a remainder of 0 when
//           going into "i" which is the largest value, and the denominator does as well, then that's your
//           greatest common denominator. After that, make sure to check once more that if the greatest common divisor
//           is not 0, then both the numerator and denominator are itself divided by the greatest common denominator
//        */
//
//        for (int i = largest; i >= 2; i--) {
//            if (this.numerator % i == 0 && this.denominator % i == 0) {
//                gcd = i;
//                break;
//            }
//        }
//
//        if (gcd != 0) {
//            this.numerator /= gcd;
//            this.denominator /= gcd;
//        }
//    }

    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
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
     * Setter for fraction's numerator and denominator, not needed for this project.
     * @param num
     * @param den
     */
//    public void setFraction(int num, int den) {
//        // making sure to check if the denominator is 0 or if the numbers are negative
//        // to not set the fraction and simply exit out of the method using the return statement
//
//        if (den == 0) {
//            System.out.println("Cannot divide by 0");
//            return;
//        }
//
//        if (num < 0 && den < 0) {
//            System.out.println("Cannot have negative numbers");
//            return;
//        }
//
//        this.numerator = num;
//        this.denominator = den;
//    }

    /**
     * Getter for the numerator.
     * @return
     */
    public double getNumerator() {
        return this.numerator;
    }

    /**
     * Getter for the denominator.
     * @return
     */
    public double getDenominator() {
        return this.denominator;
    }

    /**
     * compareTo method to compare numerator and denominator of both fraction objects.
     * @param o
     * @return
     */
    public int compareTo(Object o) {
    	Fraction that = (Fraction)o;
    	if (this.numerator < that.numerator && this.denominator == that.denominator) {
    		return -1;
		}
		else if (this.numerator > that.numerator && this.denominator == that.denominator) {
    		return 1;
		}
		else {
    		return 0;
		}
	}

    /**
     * Removing an amount of fraction
     * @param amount
     * @return
     */
    public Fraction remove(Fraction amount) {
        // TODO Auto-generated method stub
        // Establishes common denominator and then sets the current numerator by multiplying by a common factor

        double td = this.getDenominator() * amount.getDenominator(); // top den becomes this denominator * the denominator
                                                                    // of the Fraction object we pass in
        double tn = this.getNumerator() * td; // Top numerator becomes this numerator * our top den variabe above
        double sN = tn - amount.getNumerator(); //
        return new Fraction(sN, amount.getDenominator());
    }

    /**
     * Helper method to get fraction in one form.
     * @return
     */
    public double quotient() {
        return this.getNumerator() / this.getDenominator();
    }

    /**
     * Clone method.
     * @return
     * @throws CloneNotSupportedException
     */
	@Override
	public Object clone() throws CloneNotSupportedException {
    	return super.clone();
	}

    /**
     * Main to test Fraction class methods.
     * @param args
     */
	/*public static void main(String[] args) {
        Fraction a = new Fraction(3, 6);
        System.out.println(a);
    }*/
}
