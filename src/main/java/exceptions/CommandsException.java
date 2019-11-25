package exceptions;

/**
 * An Exception class built to handle exceptions in the Command package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class CommandsException extends Exception {

  /**
   * Constructor for CommandException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public CommandsException(String message) {
    super(message);
  }

}
