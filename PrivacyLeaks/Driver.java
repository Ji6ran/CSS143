/**
 HW3.java: Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */


public class Driver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        System.out.println("Money1 object output:");
        Money money1 = new Money(10);
        System.out.println("Original"); // original initialization
        System.out.println(money1);

        money1.setMoney(30,50);
        System.out.println("Set money"); // setting money
        System.out.println(money1);
        System.out.println("Added $4.23"); // adding money
        money1.add(4, 23);
        System.out.println(money1); // printing final amount
        System.out.println();
        //TODO: do more functional exercises with the money class
        System.out.println("Money2 object output:");
        Money money2 = new Money(money1); // doing this for the purpose of using .equals() method
        System.out.println("Original");
        System.out.println(money2);
        Money money3 = new Money(money2);
        System.out.println("Money2 equal to Money3? " + money2.equals(money3));
        System.out.println();



        //Construct some bills
        Money amount = new Money(20); // new money
       // System.out.println("Money: " + amount);

        Date dueDate = new Date(4, 20, 2015); // a due date
        Date paidDate = new Date(3, 1, 2014); // paid date
        Date paidDate2 = new Date(1, 4, 2014); // 2nd paid date
       // System.out.println("Date: " + dueDate);

        Bill bill1 = new Bill(amount, dueDate, "The phone company");

        System.out.println(bill1); // print out before it's paid
        bill1.setPaid(paidDate);
        System.out.println();
        System.out.println(bill1); // print out after it's paid
        System.out.println();

        Bill bill2 = new Bill(bill1);
        //bill2.setDueDate(new Date(5, 20, 2015));
        System.out.println("Bill2 and Bill1 same?: " + bill2.equals(bill1)); // check to see if they're equal
        bill2.setDueDate(new Date(2, 1, 2014));

        amount.setMoney(31, 99);
        System.out.println("Amount set to: " + amount);
        System.out.println();

        Bill bill3 = new Bill(amount, dueDate, "The record company");

        // outputs
        System.out.println("Bill objects output:");
        System.out.println();
        System.out.println("Bill 1");
        System.out.println(bill1);
        System.out.println();
        System.out.println("Bill 2");
        System.out.println(bill2);
        bill2.setPaid(paidDate2);
        System.out.println();
        System.out.println(bill2);
        System.out.println();
        System.out.println("Bill 3");
        System.out.println(bill3);
        System.out.println();

        Bill bill4 = new Bill(amount, dueDate, "The record company");
        System.out.println("Bill 4");
        System.out.println(bill4);
        System.out.println("Bill1 and bill2 same?: " + bill1.equals(bill2));
        
    }
}
