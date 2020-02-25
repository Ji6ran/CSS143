package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;

public class Ingredient implements Comparable {

	public final String desc;
	public final Money cost;
	public final int cal;


	/**
	 * Constructor for ingredient taking description of Ingredient, cost, and calories.
	 * @param desc
	 * @param cost
	 * @param cal
	 */
	public Ingredient(String desc, Money cost, int cal) {
		this.desc = desc;
		this.cost = new Money(cost);
		this.cal = cal;
	}

	/**
	 * Compares to another cost.
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		Money that = (Money)o;
		return this.compareTo(that);
	}

	/**
	 * Basic toString() method to test for Ingredients
	 * @return
	 */
	@Override
	public String toString(){
		String retVal = "";
		retVal += this.desc + "(" + this.cal + " calories | " + this.cost + ")";
		return retVal;
	}

}
