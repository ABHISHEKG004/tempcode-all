package MCothers.JobPortalVersionGaurav.exception;

/**
 * Created by gaurav.kum on 10/12/17.
 */
public class InvalidTypeException extends Exception {
    public InvalidTypeException() {
        super();
    }

    public InvalidTypeException(String message)
    {
        super(message);
    }

    public InvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTypeException(Throwable cause) {
        super(cause);
    }
}
