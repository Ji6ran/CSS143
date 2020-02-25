/**
 * Created by Jibran on 5/9/19.
 */
public class Node {
    int value;
    Node next;
    Node head;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public Node(Node otherNode) {
        this.value = otherNode.value;
        this.next = otherNode.next;
    }

    public Node() {

    }

    @Override
    public String toString() {
        return "Number: " + this.value;
    }

}
