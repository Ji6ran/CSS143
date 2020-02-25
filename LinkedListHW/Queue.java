/**
 * Created by Jibran on 5/24/19.
 */
public class Queue extends LList {
    /**
     * This method queues a node that is passed in. First in first out.
     * @param n1
     */
    public void enqueue(Node n1) {
        super.insert(n1, 0);
    }

    /**
     * This method dequeues a node that is passed in. First in first out.
     * @return
     */
    public Node dequeue() {
        return super.remove(getSize() - 1);
    }

    public static void main(String[] args) {
        Node n1 = new Node(9);
        Node n2 = new Node(4);
        Node n3 = new Node(8);
        Node n4 = new Node(1);
        Queue empty = new Queue();
        Queue one = new Queue();
        Queue multiple = new Queue();


        one.enqueue(n1);
        multiple.enqueue(n1);
        multiple.enqueue(n2);
        multiple.enqueue(n3);
        multiple.enqueue(n4);
        System.out.println("Empty: " + empty.toString());
        System.out.println("Single: " + one.toString());
        System.out.println("Multiple: " + multiple.toString());
    }
}
