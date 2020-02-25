package ingredients;
import mainClasses.Money;
import java.awt.Color;

/**
 * Created by Jibran on 6/12/19.
 */
public class Vegetable extends Ingredient {
    private Color myColor;

    /**
     * Constructor which is the same as Ingredient
     * @param desc
     * @param m
     * @param cal
     */
    public Vegetable(String desc, Money m, int cal) {
        super(desc, m, cal);
    }

    /**
     * Overloaded constructor accounting for color
     * @param desc
     * @param m
     * @param cal
     * @param c
     */
    public Vegetable(String desc, Money m, int cal, Color c) {
        super(desc, m, cal);
        myColor = c;
    }

    /**
     * Setter for color
     * @param c
     */
    public void setMyColor(Color c) {
        myColor = c;
    }

    /**
     * Getter for color
     * @return
     */
    public Color getMyColor() {
        return myColor;
    }

    /**
     * String representation of color as well as super.toString()
     * @return
     */
    @Override
    public String toString() {
        // Color which is the same as instance variable
        Color theColor = getMyColor();
        String colorName = "";
        // if color equals the same color as yours, your string will share that same color name.

        if (Color.BLACK.equals(theColor))
        {
            colorName = "BLACK";
        }
        else if (Color.YELLOW.equals(theColor))
        {
            colorName = "Yellow";
        }
        else if (Color.GREEN.equals(theColor)) {
            colorName = "Green";
        }
        else if (Color.RED.equals(theColor)) {
            colorName = "Red";
        }
        return (colorName + " " + super.toString());
    }

    /**
     * Equals method comparing colors, then super classes' equals() method
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Vegetable that = (Vegetable)o;
        if (this.myColor == that.myColor) { // if this instances color is same as the one being compared to,
            return super.equals(that); // then return the super classes' equal method passing in that vegetable object
        }
        else {
            return false;
        }
    }

    /**
     * Main method to test Vegetable class methods
     * @param args
     */
    /*public static void main(String[] args) {
        Vegetable a = new Vegetable("Veggie", new Money(4, 50), 200);
        a.setMyColor(Color.GREEN);
        System.out.println(a.toString());
    }*/
}
