package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

/**
 * JUnit test case for Scope() attachment.
 * @author andrewjanuszko
 *
 */
public class TestScope {

  /**
   * Test with scope on a pistol.
   * @throws AttachmentException if too many attachments.
   * @throws WeaponException if distance is incorrect.
   */
  @Test
  public void testPistolScope() throws AttachmentException, WeaponException {
    Pistol pistol = new Pistol();
    Scope scopedPistol = new Scope(pistol);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(scopedPistol);
    timer.timeChanged();
    assertEquals(1, scopedPistol.getNumAttachments());
    assertEquals(60, scopedPistol.getMaxRange());
    assertEquals("Pistol +Scope", scopedPistol.toString());
    assertEquals(7, scopedPistol.fire(55));
    assertEquals(9, scopedPistol.fire(30));
    timer.timeChanged();
    assertEquals(7, scopedPistol.fire(55));
    assertEquals(9, scopedPistol.fire(30));
  }

  /**
   * Test with double scopes on pistol.
   * @throws AttachmentException if too many attachments.
   * @throws WeaponException if distance is incorrect.
   */
  @Test
  public void testPistolTwoScope() throws AttachmentException, WeaponException {
    Pistol pistol = new Pistol();
    Scope scopedPistol = new Scope(pistol);
    Scope doubleScopedPistol = new Scope(scopedPistol);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(doubleScopedPistol);
    timer.timeChanged();
    assertEquals(2, doubleScopedPistol.getNumAttachments());
    assertEquals(70, doubleScopedPistol.getMaxRange());
    assertEquals("Pistol +Scope +Scope", doubleScopedPistol.toString());
    assertEquals(12, doubleScopedPistol.fire(65));
    assertEquals(2, doubleScopedPistol.fire(50));
    timer.timeChanged();
    assertEquals(12, doubleScopedPistol.fire(65));
    assertEquals(2, doubleScopedPistol.fire(50));
  }

  /**
   * Test with power booster and scope on chain gun.
   * @throws AttachmentException if too many attachments.
   * @throws WeaponException if distance is incorrect.
   */
  @Test
  public void testGhainGunBoosterScope() throws AttachmentException, WeaponException {
    ChainGun chain = new ChainGun();
    PowerBooster boostedChain = new PowerBooster(chain);
    Scope scopedBoostedChain = new Scope(boostedChain);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(scopedBoostedChain);
    timer.timeChanged();
    assertEquals(2, scopedBoostedChain.getNumAttachments());
    assertEquals(70, scopedBoostedChain.getMaxRange());
    assertEquals("ChainGun +PowerBooster +Scope", scopedBoostedChain.toString());
    assertEquals(22, scopedBoostedChain.fire(30));
    assertEquals(33, scopedBoostedChain.fire(60));
    timer.timeChanged();
    assertEquals(20, scopedBoostedChain.fire(30));
    assertEquals(32, scopedBoostedChain.fire(60));
  }

  /**
   * Test with stabilizer and scope on plasma cannon.
   * @throws AttachmentException if too many attachments.
   * @throws WeaponException if distance is incorrect.
   */
  @Test
  public void testPlasmaStabilizerScope() throws AttachmentException, WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    Stabilizer stabilizedPlasma = new Stabilizer(pc);
    Scope scopedStabilizedPlasma = new Scope(stabilizedPlasma);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(scopedStabilizedPlasma);
    timer.timeChanged();
    assertEquals(2, scopedStabilizedPlasma.getNumAttachments());
    assertEquals(50, scopedStabilizedPlasma.getMaxRange());
    assertEquals("PlasmaCannon +Stabilizer +Scope", scopedStabilizedPlasma.toString());
    assertEquals(0, scopedStabilizedPlasma.fire(55));
    assertEquals(0, scopedStabilizedPlasma.fire(30));
    timer.timeChanged();
    assertEquals(0, scopedStabilizedPlasma.fire(55));
    assertEquals(0, scopedStabilizedPlasma.fire(30));
  }
}
