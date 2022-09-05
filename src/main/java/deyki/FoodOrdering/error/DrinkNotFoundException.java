package deyki.FoodOrdering.error;

public class DrinkNotFoundException extends Exception{
    public DrinkNotFoundException() {
        super();
    }

    public DrinkNotFoundException(String message) {
        super(message);
    }

    public DrinkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DrinkNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DrinkNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
