package transaction;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
public class UserAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
