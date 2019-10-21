package recovery;

/**
 * A class for a type of RecoveryBehavior.
 * @author andrewjanuszko
 */
public class RecoveryNone implements RecoveryBehavior {
  
  /**
   * Creates RecoveryNone() RecoveryBehavior.
   */
  public RecoveryNone() {
    // Empty because there is no recovery.
  }

  /**
   * Calculates new health based on input health data.
   * @param maxLife — the maximum life of the alien.
   * @return currentLife.
   */
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    return currentLife;
  }
  
}
