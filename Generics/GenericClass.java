/**
 * Created by Jibran on 6/4/19.
 */
public class GenericClass<T> {
    private T data;

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public static void main(String[] args) {
        GenericClass<String> t = new GenericClass<String>();
        t.setData("Hello");
        System.out.println(t.getData());
    }
}
