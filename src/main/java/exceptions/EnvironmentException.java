package exceptions;

/**
 * Exception for environment.
 * @author andrewjanuszko
 */
@SuppressWarnings("serial")
public class EnvironmentException extends Exception {

  /**
   * Allows the exception to throw messages.
   * @param message holds the message to be printed.
   */
  public EnvironmentException(String message) {
    super(message);
  }
}
