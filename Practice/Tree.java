/**
 * Created by Jibran on 5/30/19.
 */
public class Tree {

    private TNode root;

    public int returnHeightOfTree(TNode root) {
        /*int heightR = 0;
        int heightL = 0;
        if (root == null) {
            return 0;
        }
        TNode temp = root.right;
        TNode tempL = root.left;
        while (temp != null) {
            heightR++;
            temp = temp.right;
        }
        while (tempL != null) {
            heightL++;
            tempL = tempL.left;
        }
        if (heightR > heightL) {
            return heightR;
        }
        else return heightL;*/

        if (root == null) {
            return 0;
        }
        int heightR = returnHeightOfTree(root.right) + 1;
        int heightL = returnHeightOfTree(root.left) + 1;
        return Math.max(heightL, heightR);
    }


    public boolean contains(int value, TNode node) {
        if(node == null) { // base case
            return false;
        }
        if (node.data == value) { // base case
            return true;
        }
        if (value < node.data) {
            // look in left sub tree
            return contains(value, node.left);
        }
        else {
            // look in right sub tree
            return contains(value, node.right);
        }
    }

    public void constructTreeManually() {
        TNode root = new TNode(5);
        TNode n1 = new TNode(4);
        TNode n2 = new TNode(7);

        root.left = n1;
        root.right = n2;

        TNode n3 = new TNode(3);
        TNode n4 = new TNode(6);
        TNode n5 = new TNode(9);

        n1.left = n3;
        n2.left = n4;
        n2.right = n5;

        this.root = root;

        System.out.println("Height of the tree: " + returnHeightOfTree(root));
        System.out.println(contains(10, root)); // print false
        System.out.println(contains(6, root)); // print true

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

    }

    public TNode addNode(int data, TNode head) {
        TNode tempHead = head;

        TNode n = new TNode(data);
        if (head == null) {
            head = n;
            return head;
        }

        TNode prev = null;

        while(head != null) {
            prev = head;
            if (data >= head.data) {
                head = head.right;
            }
            else head = head.left;
        }

        if (data >= prev.data) {
            prev.right = n;
        }
        else prev.left = n;

        return tempHead;
    }

    public static void inOrder(TNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    public static void preOrder(TNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(TNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " " );
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.constructTreeManually();
    }
}
