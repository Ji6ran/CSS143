/**
 * Created by Jibran on 5/9/19.
 */
public class MyLL {
    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node();
    Node head = n1;

    public MyLL() {
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        head = n1;

    }

    public void traverse(Node n) {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = n;
            traverse(n.next);
        }
    }



    public void traverse() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void traverseBack() {
        Node temp = head;
        Node end;
        while(temp.next != null) {
            end = temp.next;
        }

    }

    public Node insertInList(Node head, int x) {
        Node n1 = new Node(x);

        //first element or empty list
        if (head == null || head.value > x) {
            n1.next = head;
            return n1;
        }
        // Case: somewhere in the middle
        Node current = head;
        while(current.next != null && current.value < x) {
            current = current.next;
        }
        n1.next = current.next;
        current.next = n1;
        return head;
    }

    public Node removeFromList(Node head, int x) {
        Node current = head;

        if(head == null) {
            System.out.println("Empty list");
            return null;
        }
        else {
            while(current.next != null) {
                if (current.value == x) {
                    Node temp = current.next;
                    current = null;
                    head.next = temp;
                    return current;
                }
            }
        }
        return null;
    }
}
