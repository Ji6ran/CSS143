/**
 * Created by Jibran on 6/4/19.
 */
public class GenericClass<T> {
    private T data;

    public GenericClass() {

    }

    public void setData(T t) {
        data = t;
    }

    public T getData() {
        return data;
    }

    public static void main(String[] args) {
        GenericClass<Node> nodes = new GenericClass<Node>();
        Node a = new Node(5);
        nodes.setData(a);
        System.out.println(nodes.getData());

        GenericClass<String> test = new GenericClass<String>();
        String t = "Hello World";
        test.setData(t);
        System.out.println(test.getData());
    }
}
