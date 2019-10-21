package exceptions;

/**
 * Allows us to throw recovery rate exceptions.
 * @author andrewjanuszko
 */
@SuppressWarnings("serial")
public class RecoveryRateException extends Exception {
  
  /**
   * Allows us to throw recovery rate exceptions.
   * @param message — the message to be thrown.
   */
  public RecoveryRateException(String message) {
    super(message);
  }
  
}
