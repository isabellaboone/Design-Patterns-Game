package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

/**
 * A JUnit test case for MockWeapon().
 * @author andrewjanuszko
 */
public class TestGenericWeapon {

  /**
   * Test to see if weapons consume ammo.
   * @throws WeaponException when broken.
   */
  @Test
  public void testConsumeAmmo() throws WeaponException {
    MockWeapon mock = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(mock);
    timer.timeChanged();
    for (int i = 20; i > 0; --i) {
      assertEquals(i, mock.getCurrentAmmo());
      assertEquals(5, mock.fire(10));
      timer.timeChanged();
      
    }
    assertEquals(0, mock.getCurrentAmmo());
    assertEquals(0, mock.fire(10));
  }
  
  /**
   * Tests to see if weapons follow their rate of fire.
   * @throws WeaponException when broken.
   */
  @Test
  public void testRateOfFire() throws WeaponException {
    MockWeapon mock = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(mock);
    timer.timeChanged();
    assertEquals(3, mock.fire(20));
    assertEquals(3, mock.fire(20));
    assertEquals(3, mock.fire(20));
    timer.timeChanged();
    assertEquals(3, mock.fire(20));
    assertEquals(3, mock.fire(20));
    assertEquals(3, mock.fire(20));
  }
  
  /**
   * Tests to see if weapons can reload.
   * @throws WeaponException when broken.
   */
  @Test
  public void testReload() throws WeaponException {
    MockWeapon mock = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(mock);
    timer.timeChanged();
    for (int i = 20; i > 0; --i) {
      assertEquals(i, mock.getCurrentAmmo());
      assertEquals(5, mock.fire(10));
      timer.timeChanged();
    }
    assertEquals(0, mock.getCurrentAmmo());
    assertEquals(0, mock.fire(10));
    timer.timeChanged();
    mock.reload();
    assertEquals(20, mock.getCurrentAmmo());
  }
  
  /**
   * Tests to see if weapons do damage when they have no ammo.
   * @throws WeaponException when broken.
   */
  @Test
  public void testNoDamageWhenEmpty() throws WeaponException {
    MockWeapon mock = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(mock);
    timer.timeChanged();
    for (int i = 20; i > 0; --i) {
      assertEquals(i, mock.getCurrentAmmo());
      assertEquals(5, mock.fire(10));
      timer.timeChanged();
    }
    assertEquals(0, mock.getCurrentAmmo());
    assertEquals(0, mock.fire(10));
  }
  
  /**
   * Tests to see if weapons do damage when they are out of range.
   * @throws WeaponException when broken.
   */
  @Test
  public void testNoDamageWhenBeyondRange() throws WeaponException {
    MockWeapon mock = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(mock);
    timer.timeChanged();
    assertEquals(40, mock.getMaxRange());
    assertEquals(0, mock.fire(mock.getMaxRange() + 1));
  }

}
