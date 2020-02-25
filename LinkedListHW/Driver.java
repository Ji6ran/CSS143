/**
 * Created by Jibran on 5/24/19.
 */
public class Driver {
    public static void main(String[] args) {
        LList empty = new LList();
        LList one = new LList();
        LList multiple = new LList();

        Node foo = new Node(4);
        Node boo = new Node(3);
        Node woo = new Node(9);
        Node goo = new Node(1);
        System.out.println("Empty's list: " + empty);
        System.out.println("Empty?: " + empty.isEmpty());


        one.insert(foo, 0);
        multiple.insert(boo, 0);
        multiple.insert(goo, 1);

        System.out.println("One: " + one);
        System.out.println("Multiple: " + multiple);
        System.out.println();
        System.out.println("One's size: " + one.getSize());
        System.out.println("One Empty?: " + one.isEmpty());
        System.out.println("Multiple's size: " + multiple.getSize());
        System.out.println("Multiple Empty?: " + multiple.isEmpty());
        System.out.println();

        one.remove(0);
        multiple.remove(1);

        System.out.println("One upon remove: " + one);
        System.out.println("One's size upon remove: " + one.getSize());
        System.out.println("One Empty upon remove?: " + one.isEmpty());
        System.out.println();
        System.out.println("Multiple upon remove: " + multiple);
        System.out.println("Multiple's size upon remove: " + multiple.getSize());
        System.out.println("Multiple Empty upon remove?: " + one.isEmpty());
        System.out.println();
        Node roo = new Node(2);

        one.insert(roo, 0);
        multiple.insert(roo, 2);
        System.out.println("Position of 2 in multiple: " + multiple.indexOf(new Node(2)));
        System.out.println("One on insert: " + one);
        System.out.println("One's size on insert: " + one.getSize());
        System.out.println("One Empty on insert?: " + one.isEmpty());
        System.out.println();
        System.out.println("Multiple on insert: " + multiple);
        System.out.println("Multiple's size on insert: " + multiple.getSize());
        System.out.println("Multiple Empty on insert?: " + one.isEmpty());
    }
}
