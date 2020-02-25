package mainClasses;
import java.text.DecimalFormat;
import java.util.Random;
import ingredients.Meat;
import shapes.Circle;
import shapes.*;
import timeStamp.Date;
import timeStamp.TimeStamp;
import ingredients.Ingredient;
import ingredients.*;
import java.awt.Color;


public class Pizza implements PizzaComparable {
	/*
	 * TODO: Data definitions here, like the ArrayList of ingredients
	 *
	 */
	private ArrayList<Ingredient> list = new ArrayList<Ingredient>();
	private int calCount;
	private Money cost = new Money(4, 0);
	private Shape myShape;
	private Fraction remainingPizza = new Fraction(1, 1);
	public TimeStamp dateMade;
	private double remainingArea;
	private int numCals = 0;

	/**
	 * Constructor which has a random generator for shapes, sauces, cheese, meat, and vegetables
	 */
	public Pizza() { 
		//TODO:  this one makes a random pizza as far as ingredients and shape & size go
		Random rand = new Random();
		if (rand.nextInt(2) == 1) {
			myShape = new Square(1, 1);
		}
		else {
			myShape = new Circle(1, 1);
		}
		setShape(myShape);
		Ingredient sauce;
		if(rand.nextInt(2) == 1) {
			sauce = new Marinara("Marinara Sauce", new Money(0, 50), 50);
		}
		else {
			sauce = new Alfredo("Alfredo Sauce", new Money(0, 40), 50);
		}
		addIngredient(sauce); // adds the sauce after random util determines which sauce to use
		Ingredient cheese;
		if(rand.nextInt(2) == 1) {
			cheese = new Goat("Goat Cheese", new Money(1, 0), 150);
		}
		else {
			cheese = new Mozzarella("Mozzarella Cheese", new Money(2, 0), 200);
		}
		addIngredient(cheese); // adds the cheese after random util determines which cheese to use
		Ingredient meat;
		if(rand.nextInt(2) == 1) {
			meat = new Sausage("Sausage Meat", new Money(2, 0), 200);
		}
		else {
			meat = new PepperOni("Pepperoni Meat", new Money(1, 50), 175);
		}
		addIngredient(meat); // adds the meat after random util determines which meat to use
		Ingredient vegetables;
		if(rand.nextInt(2) == 1) {
			vegetables = new Pepper("Pepper Vegs", new Money(1, 0), 80, Color.RED);
		}
		else {
			vegetables = new Olive("Olive Vegs", new Money(1, 0), 75, Color.GREEN);
		}
		addIngredient(vegetables); // adds the veggies after random util determines which veggies to use

		remainingArea = myShape.getArea();
		dateMade = new TimeStamp( PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime() );
	}

	/**
	 * Setter for shape
	 * @param s
	 */
	public void setShape(Shape s) {
		myShape = s;
	}

	/**
	 * Getter for remaining fraction
	 * @return
	 */
	public Fraction getRemainingFraction() {
		return new Fraction(this.remainingPizza);
	}

	/**
	 * Setter for remaining fraction
	 * @param f
	 */
	public void setRemainingFraction(Fraction f) {
		this.remainingPizza = f;
	}

	/**
	 * Getter for remaining area
	 * @return
	 */
	public double getRemainingArea() {
		return this.remainingArea;
	}

	/**
	 * Getter for calories
	 * @return
	 */
	public int getCalories() {
		return this.calCount;
	}

	/**
	 * Getter for cost
	 * @return
	 */
	public Money getCost() {
		return this.cost;
	}

	/**
	 * Getter for shape
	 * @return
	 */
	public Shape getShape() { return myShape; }

	/**
	 * Adds ingredients to the pizza
	 * @param a
	 */
	public void addIngredient(Ingredient a) {
		if (a == null) {
			throw new PizzaException("Ingredient doesn't exist");
		}
		list.add(a); // adds the ingredient to the list, cost adds however much the cost is, and the calorie count
					// increases accordingly, as well as number of calories total for each food.
		cost.add(a.cost);
		calCount += a.cal;
		numCals++;
	}

	/**
	 * Eats some pizza.
	 * @param amt
	 */
	public void eatSomePizza(Fraction amt) {

		if (this.remainingPizza.quotient() <= amt.quotient()) {
			throw new PizzaException("Cannot take more than what's there");
		}
		if (this.remainingPizza.getDenominator() == 0) {
			throw new PizzaException("Cannot divide by 0");
		}
		if (amt.quotient() > this.remainingPizza.quotient()) {
			throw new PizzaException();
		}
		try {
			if(this.remainingPizza.quotient() - amt.quotient() == 0) {
				throw new PizzaException("No pizza left");
			}
		}
		catch(PizzaException e) {
			System.out.println("No pizza left D:");
			return;
		}
		// Remaining fraction which equals however much of the fraction of pizza we remove, then sets the remaining
		// fraction as that, and the remaining area = itself subtracted by the area * the fraction remainder (if that made sense)
		Fraction rem = new Fraction(remainingPizza.remove(amt));
		setRemainingFraction(rem);
		this.remainingArea -= (this.remainingArea * amt.quotient());
	}

	/**
	 * Getter for pizza date made
	 * @return
	 */
	public Date getMadeDate() { return this.dateMade; }

	/**
	 * Compares pizza's by cost
	 * @param o
	 * @return
	 */
	public int compareTo(Object o) { // compares by price
		if (!(o instanceof Pizza)) {
			throw new PizzaException("Not a pizza!");
		}
		Pizza that = (Pizza)o;
		if (this.cost.getMoney() == that.cost.getMoney()) {
			return 0;
		}
		else if (this.cost.getMoney() > that.cost.getMoney()) {
			return 1;
		}
		else {
			return -1;
		}

	}

	/**
	 * Compares pizzas by size
	 * @param o
	 * @return
	 */
	public int compareToBySize(Object o) {
		if (!(o instanceof Pizza)) {
			throw new PizzaException("Not a pizza!");
		}
		Pizza that = (Pizza)o;

		return this.remainingPizza.compareTo(that.getRemainingFraction());
	}

	/**
	 * Compares pizzas by calories
	 * @param o
	 * @return
	 */
	public int compareToByCalories(Object o) {
		if (!(o instanceof Pizza)) {
			throw new PizzaException("Not a pizza!");
		}
		Pizza that = (Pizza)o;
		if (this.calCount > that.calCount) {
			return 1;
		}
		else if (this.calCount < that.calCount) {
			return -1;
		}
		else {
			return 0;
		}
	}

	/**
	 * Main to test Pizza class methods
	 * @param args
	 */
	/*public static void main(String[] args) {
		Pizza ball = new Pizza();
		Pizza crasd = new Pizza();
		Pizza dulled = new Pizza();
		Pizza elephant = new Pizza();
		ball.eatSomePizza(new Fraction(1, 8));
		System.out.println(ball.getRemainingFraction());
		System.out.println(ball.getRemainingArea());

		crasd.eatSomePizza(new Fraction(1, 8));
		System.out.println(crasd.getRemainingFraction());
		System.out.println(crasd.getRemainingArea());

		dulled.eatSomePizza(new Fraction(1, 8));
		System.out.println(dulled.getRemainingFraction());
		System.out.println(dulled.getRemainingArea());

		elephant.eatSomePizza(new Fraction(1, 8));
		System.out.println(elephant.getRemainingFraction());
		System.out.println(elephant.getRemainingArea());

		System.out.println(ball.toString());

	}*/

	/**
	 * toString() method which displays all the information about fraction of pizza remaining, shape, calories, price
	 * and area
	 * @return
	 */
	@Override
	public String toString(){
		return "Pizza has a price: " + getCost() + " and calories " + getCalories() + ", Fraction remaining: " +
				getRemainingFraction() + " and area left: " + getRemainingArea() + " and \nshape: " + getShape();
	}
}
