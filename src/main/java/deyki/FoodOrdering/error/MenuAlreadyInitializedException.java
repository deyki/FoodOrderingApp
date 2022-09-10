package deyki.FoodOrdering.error;

public class MenuAlreadyInitializedException extends Exception{
    public MenuAlreadyInitializedException() {
        super();
    }

    public MenuAlreadyInitializedException(String message) {
        super(message);
    }

    public MenuAlreadyInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuAlreadyInitializedException(Throwable cause) {
        super(cause);
    }

    protected MenuAlreadyInitializedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
