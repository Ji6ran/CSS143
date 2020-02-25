/**
 * Created by Jibran on 6/6/19.
 */
import java.util.*;
public class ArrListOfStrings {
    public static void main(String[] args) {
        ArrayList<String> array = oddArr();
        for(String ele : array) {
            System.out.print(ele + ", ");
        }

        System.out.println(nums(1234));
    }

    public static ArrayList<String> oddArr() {
        ArrayList<String> array = new ArrayList<String>(100);
        array.add("a");
        array.add("ab");
        array.add("abc");
        array.add("abcd");
        array.add("abcde");
        array.add("abcdef");

        ArrayList<String> output = new ArrayList<String>(100);

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).length() % 2 != 0) {
                String temp = array.get(i);
                output.add(temp);
            }

        }

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).length() % 2 == 0) {
                String temp = array.get(i);
                output.add(temp);
            }

        }

        return output;
    }

    public static int nums(int index) {
        if (index == 0) {
            return 0;
        } else {
            return nums(index / 10);
        }
    }
}
