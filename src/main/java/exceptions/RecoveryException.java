package exceptions;

/**
 * An Exception class built to handle exceptions in the Recovery package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class RecoveryException extends Exception {

  /**
   * Constructor for RecoveryException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public RecoveryException(String message) {
    super(message);
  }

}
