public class FractionCounter {
    Fraction f = null;
    int counter = 0;

    FractionCounter(Fraction theFraction) {
        f = theFraction;
    }

    /**
     * Compares fraction objects and if they are equal, counter goes up by 1 and it returns true
     * @param newFraction
     * @return
     */
    public boolean compareAndIncremeent(Fraction newFraction) {
        if (newFraction.equals(this.f)) {
            counter++;
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return "Fraction: " + this.f + " | has a count of: " + this.counter;
    }
}
