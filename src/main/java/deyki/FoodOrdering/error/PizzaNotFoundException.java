package deyki.FoodOrdering.error;

public class PizzaNotFoundException extends Exception{
    public PizzaNotFoundException() {
        super();
    }

    public PizzaNotFoundException(String message) {
        super(message);
    }

    public PizzaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PizzaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
