package ingredients;
import mainClasses.Money;

/**
 * Created by Jibran on 6/12/19.
 */
public class Meat extends Ingredient { // subclass of Ingredient with same constructor
    public Meat(String desc, Money m, int cal) {
        super(desc, m, cal);
    }
}
