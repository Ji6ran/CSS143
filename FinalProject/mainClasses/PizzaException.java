package mainClasses;

public class PizzaException extends RuntimeException {
	//TODO:
    public PizzaException() {
        super();
    } // default constructor for no argument exception

    public PizzaException(String message) {
        super(message);
    }
}
