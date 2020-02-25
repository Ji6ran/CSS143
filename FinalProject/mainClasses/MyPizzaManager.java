package mainClasses;
import java.util.Scanner;

public class MyPizzaManager extends PizzaManager {
    ArrayList<Pizza> list = new ArrayList<Pizza>();
    private int numPizzas = 0;

    public MyPizzaManager()
    {
        super();
    }

    /**
     * Display's all the pizzas in the list
     */
    @Override
    protected void displayAllPizzas() {
        System.out.println(list.toString());
    }

    /**
     * Gets the number typed in
     * @return
     */
    @Override
    protected int getNextInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Type a number: ");
        return s.nextInt();
    }

    /**
     * Gets the character typed in.
     * @return
     */
    @Override
    protected char getNextChar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Type a character: ");
        return s.next().charAt(0);
    }

    /**
     * Eats some pizza
     */
    @Override
    protected void eatSomePizza() {
        Scanner s = new Scanner(System.in); // You type in numerator and denominator first, and then which index's
                                            // pizza you would like to eat
        System.out.println("Eating a fraction of a pizza. How much (numerator/denominator) and at which index?");
        Fraction eat = new Fraction(s.nextDouble(), s.nextDouble()); // eats with the numbers you typed in
        int index = s.nextInt(); // index for which index in the pizza list you want to eat for pizzas.
        try {
            list.get(index).eatSomePizza(eat); // tries to eat pizza at whichever index we give it if possible
        } // catches an exception if it doesn't which simply prints out the message and then removes it from
            // the list, and returns
        catch (PizzaException e) {
            System.out.println("You finished the whole pizza!");
            list.remove(index);
            return;
        }
    }

    /**
     * Adds a random pizza into the array list
     */
    @Override
    protected void addRandomPizza(){
        //new random pizza which gets added to the array list
        Pizza rand = new Pizza();
        list.add(rand);
        numPizzas++;
    }

    /**
     * Runs a binary search using calories
     * @param cals
     * @return
     */
    @Override
    protected int binarySearchByCalories(int cals) {
        quickSortByCalories();  // calls quickSort to sort the array list first
        int low = 0;
        int high = list.size() - 1;
        //pick start and end
        int middle;
        while (low <= high) { // while low is less than or equal to high

            middle = (low + high) / 2; // middle value will be picked
            //set middle
            if (cals < (((Pizza) list.get(middle)).getCalories())) { // if calories are less than the middle value's
                                                                     // calories, then high value gets reset
                high = (middle - 1);
            }
            else if (cals == (((Pizza) list.get(middle)).getCalories())) { // if it equals, then it returns middle
                return middle;
            }
            else if (cals > (((Pizza) list.get(middle)) // if it's greater, then low value gets reset
                    .getCalories())) {
                low = (middle + 1);
            }
        }
        // otherwise exception is thrown
        throw new PizzaException("Sorry, we don't have a pizza with " + cals + " many calories!");

    }

    /**
     * Quick Sorts using calories.
     */
    @Override
    protected void quickSortByCalories() {
        calorieSortRecursion(0, list.size() - 1); // calorieSortRecursion is called (helper method)
        //call other method
    }

    /**
     * Helper method for quickSortByCalories()
     * @param low
     * @param high
     */
    public void calorieSortRecursion(double low, double high) {
        // picks pivot using the other method
        double middle = getMiddleCalorie(low, high);
        if (low < middle - 1) {
            // if low is less than middle - 1, then the new high becomes middle - 1
            // otherwise if the high is greater than the middle, then the middle becomes the new low keeping same high
            calorieSortRecursion(low, middle - 1);
        }
        if (high > middle) {
            calorieSortRecursion(middle, high);
        }
    }

    /**
     * Gets the middle calorie
     * @param low
     * @param high
     * @return
     */
    public double getMiddleCalorie(double low, double high) {
        // pivot value and start and end get initialized.
        double middle = (list.get((int) low)).getCalories(),
                        start = low, end = high;
        while (start <= end) { // while start is less than or equal to end, and while the calories at the index
                                // of start is less than middle - 1, increment start
            while ((list.get((int) start)).getCalories() < middle-1) {
                start++;
            }
            while ((list.get((int) end)).getCalories() > middle) { // almost same as above comment, but if greater than
                                                    // middle, then decrement the end
                end--;
            }
            if (start <= end) {
                list.swap((int) start, (int) end); // swaps the pizza list objects if start is less than or = to end
                start++;
                end--;
            }
        }
        return start; //return the starting point
    }

    /**
     * Remove day old pizzas
     */
    @Override
    protected void removeDayOldPizzas() {

        //iterate over array
        for (int i = 0; i < numPizzas; i++){

            if (super.getCurrentDate().compareTo(((Pizza)list.get(i)).getMadeDate()) >= 1) {
                // if the pizza is a day old or older then remove it
                System.out.println(list.get(i) + " is a day-old pizza, so it will be removed.");
                list.remove(i); //remove
                numPizzas--; //decrement numPizzas
            }
        }
        System.out.println("There are no old pizzas to remove.");
        //no pizzas to remove
    }

    /**
     * Reverses the order of the array list.
     */
    @Override
    protected void reversePizzasWithStack() {
        ArrayList<Pizza> temp = new ArrayList<Pizza>();
        //new temp pizzalist (arraylist)
        for (int i = 0; i < list.size(); i++) {
            // temp gets inserted and then pizzalist gets reset when list = temp
            temp.add(list.get(list.size() - (1 + i)));
        }
        list = temp;
    }

    /**
     * Linear Searches by days
     * @param day
     * @return
     */
    @Override
    protected int linearSearchByDay(int day) {
        for (int i = 0; i < numPizzas; i++){
            // if input day and day made is the same then return the pizza object
            if ((list.get(i)).getMadeDate().getDay() == day){
                System.out.println(list.get(i) + " was made on the " + day + "day.");
                return i;
            }
        }
        // otherwise return no pizzas
        System.out.println("There are no pizzas made on that day.");
        return -1;

    }

    /**
     * Quick Sorts the pizzas by price using helper method
     */
    @Override
    protected void quickSortByPrice() {
        quickSortByPrice2(0, list.size()-1);
    }

    /**
     * Helper method for quickSortByPrice()
     * @param start
     * @param end
     */
    private void quickSortByPrice2(double start, double end) {

        double pivot = getMiddle(start, end); // picking a pivot using getMiddle() method
        if (start < pivot - 1) {
            // recursively quicksorts
            quickSortByPrice2(start, pivot - 1);
        }

        if (end > pivot) {
            // recursively quicksorts
            quickSortByPrice2(pivot, end);
        }

    }

    /**
     * Gets middle value of array given a low value and high.
     * @param low
     * @param high
     * @return
     */
    public double getMiddle(double low, double high) {
        // find the middle of the array
        double middle = (list.get((int) low)).getCost().getMoney(),  // gets the cost Money object if equivalent
                first = low, last = high;

        while (first <= last) {
            while ((list.get((int) first)).getCost().getMoney() < middle) { // while first is less than or equal to
                // last and while the cost of the value at that index is less than middle, increment first
                first++;
            }
            while ((list.get((int) last)).getCost()
                    .getMoney() > middle) {
                last--; // decrement last while the cost is greater than the middle value
            }
            if (first <= last) {
                list.swap((int) first, (int) last);
                first++;
                last--;
            }
        }
        return first;
    }

    /**
     * Gets the area of the middle index in the pizza list
     * @param low
     * @param high
     * @return
     */
    public double getMiddleSize(double low, double high) {
        double middle =
                ( list.get((int) low)).getRemainingArea(),
                first = low, last = high;
        // picks pivot
        while (first <= last) { // while first is less than or equal to last, and while the index of first
                                // in the pizza list's area is less than the middle, increment first
            while (( list.get((int) first)).getRemainingArea() < middle) {
                first++;
            }
            while (( list.get((int) last)).getRemainingArea() > middle) {
                last--;
            }
            if (first <= last) {
                list.swap((int) first, (int) last);
                first++;
                last--;
            }
        }
        return first;

    }

    /**
     * Helper method for quickSortBySize() method
     * @param low
     * @param high
     */
    public void sizeSortRecursion(double low, double high) {
        // choosing the middle pivot
        double middle = getMiddleSize(low, high);
        if (low < middle - 1) { // if low is less than middle value - 1, then recursive call with the high being middle-1
            sizeSortRecursion(low, middle - 1);
        }
        if (high > middle) { // if high is greater than middle, then recursive call with the low being the middle, and
                             // high still being high
            sizeSortRecursion(middle, high);
        }
    }

    /**
     * Quick sorts the pizza list by the size.
     */
    @Override
    protected void quickSortBySize() {
        sizeSortRecursion(0, list.size() - 1);
    }
}
