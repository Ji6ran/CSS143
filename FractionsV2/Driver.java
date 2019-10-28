import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner reader = null;
        Scanner lines = null;

        try {
            reader = new Scanner(new FileInputStream("fractionsv2.txt"));
            lines = new Scanner(new FileInputStream("fractionsv2.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        int count = 0; // counts how many lines are in the file
        String fracTemp = "";

        while(lines.hasNextLine()) {
            fracTemp = lines.nextLine();
            count++;
        }

        lines.close();


        String[] storage = new String[count];
        String[] temp;
        int[] tempFracs = new int[2];
        Fraction[] fracs = new Fraction[count];
        for(int i = 0; i < storage.length; i++) {
            storage[i] = reader.nextLine();
        }

        for (int j = 0; j < storage.length; j++) {
            temp = storage[j].split("/");
            // Attempts to parse every string read into an int if possible, and if not
            // then it'll throw a numberformatexception showing that it cannot parse
            // non-numerical strings
            try {
                tempFracs[0] = Integer.parseInt(temp[0]);
                tempFracs[1] = Integer.parseInt(temp[1]);

                Fraction f = new Fraction(tempFracs[0], tempFracs[1]);
                fracs[j] = f;
            }
            catch (NumberFormatException e) {
                System.out.println("Cannot parse non-numbers");
                System.exit(0);
            }
        }

        // this'll be an array to store toStrings from the fraction counter class
        String[] fcArr = new String[fracs.length];

        /*
            We create a new instance of FractionCounter with it taking in the fraction at
            different slots, and then we compare that with other fractions. It's used to count
            how many times that fraction appears in the array. Once that's finished, we use
            the toString() method in FractionCounter to be stored in our String array.
         */
        for(int i = 0; i < fracs.length; i++) {

            FractionCounter fc = new FractionCounter(fracs[i]);
            for (int j = 0; j < fracs.length; j++) {
                if(fc.compareAndIncremeent(fracs[j])) {
                    continue;
                }
            }
            fcArr[i] = fc.toString();
        }
        /*
            After that, we check to see if there are repeated fractions, such as 2/1 repeating
            itself. If there are repeated cases, then those simply get set as empty string. Once
            we start printing, then we make sure to only print what's not an empty string in the
            elements of the fcArr array.
         */
        for(int i = 0; i < fcArr.length; i++) {
            for(int j = i + 1; j < fcArr.length; j++) {
                if(fcArr[i].equals(fcArr[j])) {
                    fcArr[j] = "";
                }
            }
        }

        for(String el : fcArr) {
            if(el != "") {
                System.out.println(el);
            }
        }
    }
}
