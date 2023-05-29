package MCexamples.splitwise.exception;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

public class InvalidExpenseException extends Exception{

  public InvalidExpenseException(String message) {
    super(message);
  }

  public InvalidExpenseException(String message, Throwable cause) {
    super(message, cause);
  }

}
