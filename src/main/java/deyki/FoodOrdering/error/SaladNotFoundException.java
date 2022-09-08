package deyki.FoodOrdering.error;

public class SaladNotFoundException extends Exception{
    public SaladNotFoundException() {
        super();
    }

    public SaladNotFoundException(String message) {
        super(message);
    }

    public SaladNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaladNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SaladNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
