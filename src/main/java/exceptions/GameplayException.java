package exceptions;

/**
 * An Exception class built to handle exceptions in the Gameplay package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class GameplayException extends Exception {

  /**
   * Constructor for GameplayException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public GameplayException(String message) {
    super(message);
  }

}
