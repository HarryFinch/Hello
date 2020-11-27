package transaction;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
public class BookStockException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
