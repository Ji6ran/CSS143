/**
 * Created by Jibran on 5/9/19.
 */
public class Recursion {
    public static void main(String[] args) {
        recurse(9);
        prAster(4);
    }

    public static void recurse(int n) {
        if(n == 1) {
            System.out.println(n);
        }
        else {
            System.out.println(n);
            recurse(n - 1);
        }
    }

    public static void prAster(int n) {
        if(n == 1) {
            System.out.print("*");
        }
        else {
            System.out.print("*");
            prAster(n-1);
        }

    }
}
