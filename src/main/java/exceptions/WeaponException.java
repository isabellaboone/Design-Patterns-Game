package exceptions;

/**
 * Exceptions for weapons.
 * @author andrewjanuszko
 *
 */
@SuppressWarnings("serial")
public class WeaponException extends Exception {

  /**
   * Allows the user to throw messages with exceptions.
   * @param message holds the message to be printed.
   */
  public WeaponException(String message) {
    super(message);
  }
}
