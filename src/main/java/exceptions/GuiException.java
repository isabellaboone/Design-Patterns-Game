package exceptions;

@SuppressWarnings("serial")
public class GuiException extends Exception {
  
  /**
   * An exception thrown when GUI is incorrect.
   * @param message the message to be thrown.
   */
  public GuiException(String message) {
    super(message);
  }

}
