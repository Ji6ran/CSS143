import java.util.*;
import java.io.*;
public class Fractions {
    public static void main(String[] args) {

        /*
            1). We could complete it without using arrays, it would just be extremely complicated and a
                very long process

            2). You cannot use just one array, because you have to read the file using Strings, and then
                convert them into doubles in order for you to complete calculations.

            3). I'm confused on the question, but I assume you mean inheritance, because a class can be
                "a part of" another class if you inherit it. It is done by this line of code (ignoring names)
                public class ClassName extends OtherClass {}

            4). You could cross multiply and see if the numbers are equal.
         */


        /*
            We read the file the first time to check how many lines are in the file. Once we count how many lines
            are in the file, we take that number and use it to initialize String array length. The second time
            we read the file is to check each individual line, and then put those in the elements of the String array
         */
        Scanner rdr = null;
        String lines = "";
        int counter = 0;
        try {
            // the reason for the path file being linked is because Mac OS just work differently when it comes to this
            rdr = new Scanner(new FileInputStream("/Users/Jibran/Documents/CSS143/FractionsV1/src/fractions.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        while(rdr.hasNextLine()) {
            lines = rdr.nextLine(); // this variable is created so that we can read from the file, rather than
                                    // just detecting the file is there
            counter++;
        }

        rdr.close();
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("/Users/Vykz/Documents/CSS143/FractionsV1/src/fractions.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        /*
            We take our string array, and initialize it with the amount of lines there.
            We then set the elements with whichever line is read next in the text file. After that
            we close off the scanner, and create an array of doubles. This array of doubles is initialized
            through our splitting method, which takes the String array, and converts it to a double.
            After that, we check to see how many times a number has an occurrence we record that
            using a variable. We then print out the results.
         */
        String[] frac;
        frac = new String[counter];
        for(int i = 0; i < frac.length; i++) {
            frac[i] = input.nextLine();
        }
        input.close();
        double[] nums = splitting(frac);
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            System.out.println(frac[i] + " has a count of " + count);
        }
    }
    /*
        We are passing in the string array that we want to split the equation symbols out of.
        In the body, we create an array of doubles whose length is going to be the same as
        the string array that you passed in. From there we make a for loop, and within it
        Created an array of string to split the "/" from the original array. From there, set the
        element in your array of doubles to be parsed from your split decimal array of strings, and
        divide it with the 2nd element. Return the array at the end.
     */
    public static double[] splitting(String[] array) {
        double[] fracs = new double[array.length];
        for(int i = 0; i < fracs.length; i++) {
            String[] dec = array[i].split("/");
            fracs[i] = Double.parseDouble(dec[0]) / Double.parseDouble(dec[1]);
        }
        return fracs;
    }
}
