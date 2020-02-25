package ingredients;
import mainClasses.Money;
import java.awt.Color;

/**
 * Created by Jibran on 6/13/19.
 */
public class Pepper extends Vegetable { // subclass of Vegetable with same constructor, one accounting for color as well
    public Pepper(String desc, Money m, int cal) {
        super(desc, m, cal);
    }
    public Pepper(String desc, Money m, int cal, Color c) {
        super(desc, m, cal, c);
    }
}
