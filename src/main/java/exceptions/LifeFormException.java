package exceptions;

/**
 * An Exception class built to handle exceptions in the LifeForm package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class LifeFormException extends Exception {

  /**
   * Constructor for LifeFormException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public LifeFormException(String message) {
    super(message);
  }

}
