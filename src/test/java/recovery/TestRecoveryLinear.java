package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A JUnit 4 test case for RecoveryLinear().
 * @author andrewjanuszko
 */
public class TestRecoveryLinear {

  /**
   * Test recovery when no damage is taken.
   */
  @Test
  public void testNoDamage() {
    RecoveryBehavior rb = new RecoveryLinear(3);
    int maxLifePoints = 30;
    int recovered = rb.calculateRecovery(maxLifePoints, maxLifePoints);
    assertEquals(maxLifePoints, recovered);
  }
  
  /**
   * Test recovery when it recovers fully.
   */
  @Test
  public void testRecoverToMax() {
    RecoveryBehavior rb = new RecoveryLinear(5);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(98, maxLifePoints);
    assertEquals(maxLifePoints, recovered);
  }
  
  /**
   * Test recovery when it recovers a whole step.
   */
  @Test
  public void testRecoverFullStep() {
    RecoveryBehavior rb = new RecoveryLinear(5);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(90, maxLifePoints);
    assertEquals(95, recovered);
  }
  
  /**
   * Test recovery when dead.
   */
  @Test
  public void testRecoverFromZero() {
    RecoveryBehavior rb = new RecoveryLinear(5);
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(0, maxLifePoints);
    assertEquals(0, recovered);
  }
}
