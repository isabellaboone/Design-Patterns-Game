package exceptions;

/**
 * An Exception class built to handle exceptions in the Weapon package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class WeaponException extends Exception {

  /**
   * Constructor for WeaponException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public WeaponException(String message) {
    super(message);
  }

}
