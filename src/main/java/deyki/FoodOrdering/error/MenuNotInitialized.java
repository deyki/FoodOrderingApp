package deyki.FoodOrdering.error;

public class MenuNotInitialized extends Exception{
    public MenuNotInitialized() {
        super();
    }

    public MenuNotInitialized(String message) {
        super(message);
    }

    public MenuNotInitialized(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuNotInitialized(Throwable cause) {
        super(cause);
    }

    protected MenuNotInitialized(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
