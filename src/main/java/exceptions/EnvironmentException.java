package exceptions;

/**
 * An Exception class built to handle exceptions in the Environment package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class EnvironmentException extends Exception {

  /**
   * Constructor for EnvironmentException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public EnvironmentException(String message) {
    super(message);
  }

}
