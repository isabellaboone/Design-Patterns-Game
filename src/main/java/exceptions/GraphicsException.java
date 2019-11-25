package exceptions;

/**
 * An Exception class built to handle exceptions in the Graphics package.
 * 
 * @author andrewjanuszko
 */

@SuppressWarnings("serial")
public class GraphicsException extends Exception {

  /**
   * Constructor for GraphicsException. Creates an exception.
   * 
   * @param message - the message to be displayed when thrown.
   */
  public GraphicsException(String message) {
    super(message);
  }

}
