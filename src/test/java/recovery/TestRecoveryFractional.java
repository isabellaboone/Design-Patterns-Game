package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A JUnit 4 test case for RecoveryFractional().
 * @author andrewjanuszko
 */
public class TestRecoveryFractional {

  /**
   * Test to see if recovery runs when no damage is taken.
   */
  @Test
  public void testNoDamage() {
    RecoveryBehavior rb = new RecoveryFractional(0.15);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(maxLifePoints, maxLifePoints);
    assertEquals(maxLifePoints, recovered);
  }
  
  /**
   * Test to see if recovery runs when aliens recover to max health.
   */
  @Test
  public void testRecoverToMax() {
    RecoveryBehavior rb = new RecoveryFractional(0.15);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(95, maxLifePoints);
    assertEquals(maxLifePoints, recovered);
  }
  
  /**
   * Test to see if recovery runs when appling a full percent.
   */
  @Test
  public void testRecoverFullPercent() {
    RecoveryBehavior rb = new RecoveryFractional(0.15);
    int maxLifePoints = 60;
    int recovered = rb.calculateRecovery(54, maxLifePoints);
    assertEquals(60, recovered);
  }
  
  /**
   * Test to see if dead aliens recover.
   */
  @Test
  public void testRecoverFromZero() {
    RecoveryBehavior rb = new RecoveryFractional(0.15);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(0, maxLifePoints);
    assertEquals(0, recovered);
  }

}
