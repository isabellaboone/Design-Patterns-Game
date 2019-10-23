package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

/**
 * JUnit test case for Stabilizer() attachment.
 * @author andrewjanuszko
 *
 */
public class TestStabilizer {

  /**
   * Test stabilizer on plasma cannon.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testPlasmaStabilizer() throws AttachmentException, WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    Stabilizer stabilizedPlasma = new Stabilizer(pc);

    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(stabilizedPlasma);
    timer.timeChanged();
    assertEquals(1, stabilizedPlasma.getNumAttachments());
    timer.timeChanged();
    assertEquals(40, stabilizedPlasma.getMaxRange());
    assertEquals(4, stabilizedPlasma.getCurrentAmmo());
    assertEquals(62, stabilizedPlasma.fire(30));
    timer.timeChanged();
    assertEquals(46, stabilizedPlasma.fire(5));
  }
  
  /**
   * Test double stabilizer on plasma cannon.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testPlasmaTwoStabilizers() throws AttachmentException, WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    Stabilizer stabilizedPlasma = new Stabilizer(pc);
    Stabilizer doubleStabilizedPlasma = new Stabilizer(stabilizedPlasma);
    assertEquals(40, doubleStabilizedPlasma.getMaxRange());
    assertEquals(4, doubleStabilizedPlasma.getCurrentAmmo());
    assertEquals(77, doubleStabilizedPlasma.fire(10));
    assertEquals(0, doubleStabilizedPlasma.fire(70));
  }
  
  /**
   * Test scope and stabilizer on pistol.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testPistolScopeStabilizer() throws AttachmentException, WeaponException {
    Pistol pistol = new Pistol();
    Stabilizer stabilizedPistol = new Stabilizer(pistol);
    Scope scopedStabilizedPistol = new Scope(stabilizedPistol);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(scopedStabilizedPistol);
    timer.timeChanged();
    assertEquals(2, scopedStabilizedPistol.getNumAttachments());
    assertEquals(10, scopedStabilizedPistol.getCurrentAmmo());
    assertEquals(60, scopedStabilizedPistol.getMaxRange());
    for (int i = 9; i > 0; --i) {
      assertEquals(10, scopedStabilizedPistol.fire(30));
      assertEquals(i, scopedStabilizedPistol.getCurrentAmmo());
      timer.timeChanged();
    }
    assertEquals(10, scopedStabilizedPistol.fire(30));
    assertEquals(10, scopedStabilizedPistol.getCurrentAmmo());
    timer.timeChanged();
  }
  
  /**
   * Test power booster and stabilizer on chain gun.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testChainBoosterStabilizer() throws AttachmentException, WeaponException {
    ChainGun chain = new ChainGun();
    PowerBooster boostedChain = new PowerBooster(chain);
    Stabilizer stabilizedBoostedChain = new Stabilizer(boostedChain);
    assertEquals(2, stabilizedBoostedChain.getNumAttachments());
    assertEquals(40, stabilizedBoostedChain.getCurrentAmmo());
    assertEquals(60, stabilizedBoostedChain.getMaxRange());
    assertEquals(12, stabilizedBoostedChain.fire(20));
    assertEquals(31, stabilizedBoostedChain.fire(55));
  }

}
