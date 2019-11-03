package exceptions;

/*
 * Allows us to throw movement exceptions.
 */
@SuppressWarnings("serial")
public class MovementException extends Exception {
  
  /**
   * An exception thrown when movement is incorrect;
   * @param message the message to be thrown.
   */
  public MovementException(String message) {
    super(message);
  }

}
