package deyki.FoodOrdering.error;

public class DessertNotFoundException extends Exception{
    public DessertNotFoundException() {
        super();
    }

    public DessertNotFoundException(String message) {
        super(message);
    }

    public DessertNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DessertNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DessertNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
