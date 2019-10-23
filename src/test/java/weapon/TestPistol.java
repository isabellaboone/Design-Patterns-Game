package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;


/**
 * Junit test case for Pistol().
 * @author Joshua Stoffey
 */
public class TestPistol {
    
  /**
   * Tests pistol damage at two different ranges.
   * @throws WeaponException if broken.
   */
  @Test
  public void testPistolDamageAtRanges() throws WeaponException {
    Pistol pistol = new Pistol();
    SimpleTimer timer = new SimpleTimer();
      
    timer.addTimeObserver(pistol);
    timer.timeChanged();
      
    assertEquals(10, pistol.getCurrentAmmo());
    assertEquals(0, pistol.fire(51));
      
    assertEquals(9, pistol.getCurrentAmmo());
    assertEquals(12, pistol.fire(0));
      
    assertEquals(8, pistol.getCurrentAmmo());
    assertEquals(0, pistol.fire(0));
  }
}