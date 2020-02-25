package ingredients;
import mainClasses.Money;

/**
 * Created by Jibran on 6/12/19.
 */
public class Base extends Ingredient { // subclass of Ingredient, same constructor.
    public Base(String desc, Money m, int cal) {
        super(desc, m, cal);
    }
}
