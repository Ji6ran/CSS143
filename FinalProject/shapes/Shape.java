package shapes;
import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
public class Shape extends Object {
	private int x = 0; // private because we don't want people changing the coordinates, they can view with getters
	private int y = 0;

	public Shape() {
		x = 0;
		y = 0;
	}

	public Shape( int a, int b ) {
		x=a;
		y=b;
	}
	
	public double getArea(){ return -1; }
	
	public void draw( Graphics g ){}

	/**
	 * Getter for X coord
	 * @return
	 */
	public int getX() { return x; }

	/**
	 * Getter for Y coord
	 * @return
	 */
	public int getY() { return y; }

	/**
	 * Setter for X coord
	 * @param x
	 */
	public void setX(int x) { this.x = x; }

	/**
	 * Setter for Y coord
	 * @param y
	 */
	public void setY(int y) { this.y = y; }
}