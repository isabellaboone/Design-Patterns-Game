package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;

import org.junit.Test;

import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;

/**
 * A JUnit 4 test case for aliens.
 * @author andrewjanuszko
 */
public class TestAlien {

  /**
   * Test the creation of aliens.
   * @throws RecoveryRateException if wrong.
   */
  @Test
  public void testInitialization() {
    try {
      Alien alien = new Alien("Alien1", 100);
      assertEquals("Alien1", alien.getName());
      assertEquals(100, alien.getMaxLifePoints());
    } catch (RecoveryRateException rre) {
      rre.printStackTrace();
    }
  }
  
  /**
   * Test recovery rate.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testRecoveryRate() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryLinear(5);
    Alien a = new Alien("A", 100, rb, 5);
    assertEquals(5, a.getRecoveryRate());
  }
  
  /**
   * test setting recover rate.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testSetRate() throws RecoveryRateException {
    Alien a = new Alien("A", 100);
    a.setRecoveryRate(10);
    assertEquals(10, a.getRecoveryRate());
  }
  
  /**
   * test with no recovery rate.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testRecoverZero() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryLinear(0);
    Alien a = new Alien("A", 100, rb, 0);
    a.takeHit(20);
    a.recover();
    assertEquals(80, a.getCurrentLifePoints());
  }
  
  /**
   * test setting recover rate.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testSetRateNew() throws RecoveryRateException {
    Alien a = new Alien("A", 100);
    a.setRecoveryRate(60);
    assertEquals(60, a.getRecoveryRate());
  }
  
  /**
   * test setting recover rate.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testSetRateNewer() throws RecoveryRateException {
    Alien a = new Alien("A", 100);
    a.setRecoveryRate(50);
    assertEquals(50, a.getRecoveryRate());
  }
 
  /**
   * Test the healing of aliens.
   */
  @Test
  public void testLinearFractional() {
    try {
      RecoveryBehavior rb1 = new RecoveryLinear(5);
      Alien a1 = new Alien("Alien1", 90, rb1);
      a1.takeHit(60);
      a1.recover();
      assertEquals(35, a1.getCurrentLifePoints());
      
      RecoveryBehavior rb2 = new RecoveryFractional(0.09);
      Alien a2 = new Alien("Alien2", 90, rb2);
      a2.takeHit(60);
      a2.recover();
      assertEquals(33, a2.getCurrentLifePoints());
    } catch (RecoveryRateException rre) {
      rre.printStackTrace();
    }
  }
  
  /**
   * test the default attack.
   */
  @Test
  public void testDefaultAttack() {
    try {
      Alien a = new Alien("Alien", 100);
      assertEquals(10, a.getAttackStrength());
    } catch (RecoveryRateException rre) {
      rre.printStackTrace();
    }
    
  }
  
  /**
   * tests time tracking.
   */
  @Test
  public void testTime() {
    SimpleTimer timer = new SimpleTimer();
    assertEquals(0, timer.getRound());
    timer.timeChanged();
    assertEquals(1, timer.getRound());
  }
  
  /**
   * test recoveryrateexception.
   */
  @Test
  public void testException() {
    try {
      RecoveryBehavior linear = new RecoveryLinear(4);
      Alien a = new Alien("jason", 15, linear, -1);
      assertEquals("jason", a.getName());
      fail();
    } catch (RecoveryRateException rre) {
      rre.printStackTrace();
    }
  }
  
  /**
   * Aliens dont recover when no being tracked.
   * @throws RecoveryRateException when broken.
   */
  @Test
  public void testNoRecoverTime() throws RecoveryRateException {
    RecoveryBehavior linear = new RecoveryLinear(4);
    Alien a = new Alien("jason", 15, linear, 2);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(a);
    timer.removeTimeObserver(a);
    timer.timeChanged();
    assertEquals(1, timer.getRound());
  }
  
  /**
   * test attacks and stuff.
   * @throws RecoveryRateException if wrong.
   */
  @Test
  public void testCombatRecovery() throws RecoveryRateException {
    RecoveryBehavior linear = new RecoveryLinear(4);
    Alien a = new Alien("jason", 15, linear, 2);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(a);
    timer.timeChanged();
    a.takeHit(6);
    assertEquals(9, a.getCurrentLifePoints());
    timer.timeChanged();
    assertEquals(13, a.getCurrentLifePoints());
    timer.timeChanged();
    assertEquals(13, a.getCurrentLifePoints());
    timer.timeChanged();
    assertEquals(15, a.getCurrentLifePoints());
    a.takeHit(20);
    assertEquals(0, a.getCurrentLifePoints());
    timer.timeChanged();
    assertEquals(0, a.getCurrentLifePoints());
    timer.timeChanged();
    assertEquals(0, a.getCurrentLifePoints());
  }
  
  /**
   * Test movement speed.
   * @throws RecoveryRateException 
   */
  @Test
  public void testMoveSpeed() throws RecoveryRateException {
    Alien shukuchi = new Alien("Shukuchi", 334);
    assertEquals(2, shukuchi.getMoveSpeed());
  }

}
