package exceptions;

/**
 * Exception for attachments.
 * @author andrewjanuszko
 */
@SuppressWarnings("serial")
public class AttachmentException extends Exception {

  /**
   * Allows the exception to throw messages.
   * @param message holds the message to be printed.
   */
  public AttachmentException(String message) {
    super(message);
  }
}
