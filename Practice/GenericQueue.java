/**
 * Created by Jibran on 6/4/19.
 */
import java.util.ArrayList;
public class GenericQueue<T> {
    ArrayList<T> q = new ArrayList<T>();
    int idx = 0;

    public void enqueue(T data) {
        if (q.size() > 100) {
            throw new IllegalArgumentException("Limit reached (100)");
        }
        else {
            q.add(data);
        }
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue an empty list");
        }
        else {
            T temp = q.remove(idx);
            return temp;
        }
    }

    public static void main(String[] args) {
        GenericQueue<Integer> qu = new GenericQueue<Integer>();
        qu.enqueue(5);
        qu.enqueue(9);
        qu.enqueue(4);
        int d = qu.dequeue();
        int e = qu.dequeue();
        System.out.format("%4d%n", d);
        System.out.format("%4d%n", e);
        qu.enqueue(3);
        qu.enqueue(10);
        int a = qu.dequeue();
        int b = qu.dequeue();
        System.out.format("%4d%n", a);
        System.out.format("%4d%n", b);
    }
}
