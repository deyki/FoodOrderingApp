package deyki.FoodOrdering.error;

public class UserProfileDetailsNotFoundException extends Exception{
    public UserProfileDetailsNotFoundException() {
        super();
    }

    public UserProfileDetailsNotFoundException(String message) {
        super(message);
    }

    public UserProfileDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserProfileDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserProfileDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
