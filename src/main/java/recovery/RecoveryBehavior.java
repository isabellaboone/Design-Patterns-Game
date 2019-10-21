package recovery;

/**
 * A way for aliens to recover.
 * @author andrewjanuszko
 */
public interface RecoveryBehavior {
  
  /**
   * Calculate the new health of the alien.
   */
  public int calculateRecovery(int currentLife, int maxLife);
  
}
