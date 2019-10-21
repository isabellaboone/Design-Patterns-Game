package recovery;

/**
 * A type of recovery behavior.
 * @author andrewjanuszko
 */
public class RecoveryFractional implements RecoveryBehavior {
  
  private double percent;
  
  /**
   * The way in which the alien recovers.
   * @param percent — the rate at which it recovers.
   */
  public RecoveryFractional(double percent) {
    this.percent = percent;
  }

  /**
   * Calculate the new health of the alien.
   * @return the correct health value for the alien.
   */
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife <= 0) {
      return 0;
    }
    int returnedHealth = (int) Math.ceil(currentLife * percent);
    return (currentLife + returnedHealth) > maxLife
        ? maxLife : (currentLife + returnedHealth);
  }

}
