package exceptions;

/**
 * An Exception class built to handle exceptions in the Game package.
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class GameException extends Exception {

  /**
   * Constructor for GameException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public GameException(String message) {
    super(message);
  }
  
}
