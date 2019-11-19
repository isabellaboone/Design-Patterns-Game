package exceptions;

@SuppressWarnings("serial")
public class GUIException extends Exception {
  
  /**
   * An exception thrown when GUI is incorrect;
   * @param message the message to be thrown.
   */
  public GUIException(String message) {
    super(message);
  }

}
