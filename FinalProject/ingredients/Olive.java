package ingredients;
import mainClasses.Money;
import java.awt.Color;

/**
 * Created by Jibran on 6/13/19.
 */
public class Olive extends Vegetable { // subclass of Vegetable with same constructor, as well as an additional one
                                       // accounting for color
    public Olive(String desc, Money m, int cal) {
        super(desc, m, cal);
    }
    public Olive(String desc, Money m, int cal, Color c) {
        super(desc, m, cal, c);
    }
}
