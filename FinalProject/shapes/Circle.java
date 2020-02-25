package shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Jibran on 5/7/19.
 */
public class Circle extends Shape {
    private double r;

    public Circle(int x, int y) {
        super(x, y);
        setRadius(4);
    }

    /**
     * Getter for area of circle
     * @return
     */
    public double getArea() {
        return Math.PI * r * r;
    }

    /**
     * Getter for radius of circle (never used)
     * @return
     */
    public double getRadius() {
        return this.r;
    }

    /**
     * Setter for radius of circle
     * @param r
     */
    public void setRadius(double r) {
        this.r = r;
    }

    /**
     * Only for JFrame will we need the draw methods, hence why they're commented out.
     * @param
     */
    /*public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        final int x = getX();
        final int y = getY();

        g2d.setColor(Color.GREEN);
        g2d.setPaint(new GradientPaint(x, y, Color.GREEN, x + (int) r / 4, y + (int) r / 4, Color.BLUE, true));

        int xOffset = 0;
        int yOffset = 0;
        for (int i = 0; i < 20; i++) {
            xOffset = (int) (Math.random() * r);
            yOffset = (int) (Math.random() * r);
            g2d.draw(new Ellipse2D.Double(x + xOffset, y + yOffset, x + xOffset + 3, y + yOffset + 3));
        }
    }*/

    /**
     * Just a toString() to make sure you know it's circular.
     * @return
     */
    @Override
    public String toString() {
        return "Circular";
    }

}
