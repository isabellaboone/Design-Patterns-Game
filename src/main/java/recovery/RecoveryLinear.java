package recovery;

/**
 * A type of recovery behavior.
 * @author andrewjanuszko
 */
public class RecoveryLinear implements RecoveryBehavior {

  private int step;
  
  /**
   * The way in which the alien recovers.
   */
  public RecoveryLinear(int step) {
    this.step = step;
  }
  

  /**
   * Calculate the new health of the alien.
   * @return the correct health value for the alien.
   */
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    return currentLife == 0 ? 0 : Math.min(maxLife, currentLife + step);
  }

}

