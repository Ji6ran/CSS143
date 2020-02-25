/**
 * Created by Jibran on 6/4/19.
 */
import java.util.Stack;
import java.util.ArrayList;
/* Generic stack class
   Max of 100 elements */

public class GenericStack<T> {
    private ArrayList<T> st = new ArrayList<T> ();
    private int index = 0;

    public void push (T item) {
        if(st.size() < 100) {
            st.add(index, item);
            index++;
        }
    }
    public T pop () throws IllegalArgumentException {
        if(isEmpty()) {
            throw new IllegalArgumentException("Stack is empty, cannot pop anything");
        }
        else {
            return st.remove(--index);
        }
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public static void main (String[] args) {
        GenericStack<Integer> s = new GenericStack<Integer> ();
        s.push (17);
        s.push(40);
        int i = s.pop();
        System.out.format("%4d%n", i);
    }
}
