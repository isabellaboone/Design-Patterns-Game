package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

/**
 * Test plasma cannon class.
 * @author andrewjanuszko
 *
 */
public class TestPlasmaCannon {

  /**
   * Test plasma cannons at 2 damage ranges.
   * @throws WeaponException if broken.
   */
  @Test
  public void testPlasmaDamageAtRanges() throws WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(pc);
    timer.timeChanged();
    assertEquals(50, pc.fire(0));
    timer.timeChanged();
    assertEquals(37, pc.fire(40));
  }
}
