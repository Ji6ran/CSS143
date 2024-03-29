/**
 * Created by Jibran on 5/24/19.
 */
public class LList {
    Node head = null;
    int size = 0; // size to keep track of how big the list is

    /**
     * Method to insert at a specific index in the linked list.
     * @param n1
     * @param index
     */
    public void insert(Node n1, int index) {
        if (index < 0) {  // if index is negative exception gets thrown.
            throw new ListException("Index out of bounds");
        }
        if (isEmpty()) { // if list is empty, then set the head = to the node you pass in
            head = n1;
        }
        else if (index == 0) {
            n1.next = this.head;
            this.head = n1;
        }
        else if (head.next == null) {
            head.next = n1;
        }
        else {
            Node cur = head; // create temp variable and set it as head.
            while (cur.next != null) { // while the next value is null, the next value will become the node you pass in
                cur = cur.next;
            }
            n1.next = cur.next;
            cur.next = n1;
        }
        size++; // increase size as a new node has been inserted in the list
    }

    /**
     * Method to remove a node from a specific index.
     * @param index
     * @return
     */
    public Node remove(int index) {
        Node returnVal = null; // default value
        Node cur = head;
        if (isEmpty()) {
            throw new ListException("Can't remove from empty list");
        }
        // if index passed in is 0, returnVal becomes head, and head gets assigned to next node.
        else if(index == 0) {
            returnVal = head;
            head = head.next;
        }
        //else if (index >= 2)
        // if index is >= 2, then for loop
        else {
            for (int i = 0; i < index - 1; i++)
            {
                cur = cur.next;
            }
            if (cur.next.next == null)
            {
                returnVal = cur.next;
                cur.next = null;
                size--;
                return returnVal;
            }
            else
            {
                returnVal = cur.next;
                cur.next = cur.next.next;
                size--;
                return returnVal;
            }
        }
        size--;
        return returnVal;
    }

    /**
     * returns size of linked list
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Method to return the index where the value is stored.
     * @param target
     * @return
     */
    public int indexOf(Node target) {
        int index = 0;
        Node current = head;
        while (current != null) { // while current is not null, check to see if the current's value is the same
                                  // as the value you are trying to look for, if so return that. If that isn't true,
                                  // increase the index by 1 and set current to the next node. If none of it is found
                                  // then just simply return -1.
            if (current.value == target.value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    /**
     * Checks to see if the list is empty.
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns values in the list separated by commas.
     * @return
     */
    @Override
    public String toString() {
        String str = "(";
        if (head != null) { // if head is not null, then string += the value of head.
                            // you then make a current node and set it to the next node after head. while that current
                            // is not null, your string will be concatinating the values, and current will be set to
                            // the next node in the list so that it can keep showing the values until current becomes null.
            str += head.value;
            Node current = head.next;
            while (current !=  null) {
                str += ", " + current.value;
                current = current.next;
            }
        }
        str += ")";
        return str;
    }
}
