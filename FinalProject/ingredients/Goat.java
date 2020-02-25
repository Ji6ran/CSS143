package ingredients;
import mainClasses.Money;

/**
 * Created by Jibran on 6/12/19.
 */
public class Goat extends Cheese { // subclass of Cheese with same constructor
    public Goat(String desc, Money m, int cal) {
        super(desc, m, cal);
    }
}
