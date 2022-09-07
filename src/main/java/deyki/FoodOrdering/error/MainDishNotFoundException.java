package deyki.FoodOrdering.error;

public class MainDishNotFoundException extends Exception{
    public MainDishNotFoundException() {
        super();
    }

    public MainDishNotFoundException(String message) {
        super(message);
    }

    public MainDishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MainDishNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MainDishNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
