package shapes;
import java.awt.*;
import java.text.*;

/**
 * Created by Jibran on 5/7/19.
 */
public class Square extends Shape {
    private int height;
    private int width;
    private double sideLength;

    public Square(int x, int y) {
        super(x, y);
        height = 8;
        width = 8;
        sideLength = 8;
    }

    /**
     * Getter for area of a square
     * @return
     */
    public double getArea() {
        return sideLength * sideLength;
    }

    /**
     * Getter for height of square
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for height of square
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter for width of square
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter for width of square
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setter for sidelength of square
     * @param sl
     */
    public void setSideLength(double sl) {
        this.sideLength = sl;
    }

    /**
     * Getter for sidelength of square
     * @return
     */
    public double getSideLength() { return this.sideLength; }

    /**
     * Will only use draw for JFrame hence why it's commented out
     * @param g
     */
    /*public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.CYAN); // setting color
        for(int i = 0; i < 20; i++) {
            g2d.draw3DRect(10, 10, height, width, false); //drawing square using x y and height width, no raising
        }
    }*/

    /**
     * toString() method so you know it's a square
     * @return
     */
    @Override
    public String toString() {
        return "Square";
    }
    /*public Shape test() {
        Shape retVal = null;
        retVal = new Square(3, 9);
        return retVal;
    }*/
}
