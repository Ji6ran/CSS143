/**
 * Created by Jibran on 5/24/19.
 */
public class Stack extends LList {
    /**
     * This method pushes a node to the stack at the bottom.
     * @param next
     */
    public void push(Node next) {
        super.insert(next, 0);
    }

    /**
     * This method pops the top of the stack. First in last out
     * @return
     */
    public Node pop() {
        return super.remove(0);
    }

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        Stack empty = new Stack();
        Stack one = new Stack();
        Stack multiple = new Stack();

        one.push(n1);
        multiple.push(n1);
        multiple.push(n2);
        multiple.push(n3);
        multiple.push(n4);

        System.out.println("Empty: " + empty.toString());
        System.out.println("Single: " + one.toString());
        System.out.println("Multiple: " + multiple.toString());
    }
}
