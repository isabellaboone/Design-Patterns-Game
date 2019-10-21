package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A JUnit 4 test case for RecoveryNone().
 * @author andrewjanuszko
 */
public class TestRecoveryNone {

  /**
   * Test to see if recovery runs when the alien has not taken damage.
   */
  @Test
  public void testNoDamage() {
    RecoveryBehavior rb = new RecoveryNone();
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(maxLifePoints, maxLifePoints);
    assertEquals(maxLifePoints, recovered);
  }
  
  /**
   * Test to see if recovery runs when the alien has taken damage.
   */
  @Test
  public void testDamage() {
    RecoveryBehavior rb = new RecoveryNone();
    int maxLifePoints = 100;
    int recovered = rb.calculateRecovery(50, maxLifePoints);
    assertEquals(50, recovered);
  }

}
