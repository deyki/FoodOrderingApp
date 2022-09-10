package deyki.FoodOrdering.error;

public class MenuNotInitializedException extends Exception{
    public MenuNotInitializedException() {
        super();
    }

    public MenuNotInitializedException(String message) {
        super(message);
    }

    public MenuNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuNotInitializedException(Throwable cause) {
        super(cause);
    }

    protected MenuNotInitializedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
