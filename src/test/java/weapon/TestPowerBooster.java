package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

/**
 * JUnit test case for PowerBooster() class.
 * @author andrewjanuszko
 *
 */
public class TestPowerBooster {

  /**
   * Test power booster on chain gun.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testChainBooster() throws AttachmentException, WeaponException {
    ChainGun chain = new ChainGun();
    PowerBooster boostedChain = new PowerBooster(chain);
    assertEquals(1, boostedChain.getNumAttachments());
    assertEquals(60, boostedChain.getMaxRange());
    assertEquals(6, boostedChain.fire(15));
    assertEquals(25, boostedChain.fire(55));
  }
  
  /**
   * Test scope and power booster on pistol.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testPistolScopeBooster() throws AttachmentException, WeaponException {
    Pistol pistol = new Pistol();
    Scope scopedPistol = new Scope(pistol);
    PowerBooster boostedScopedPistol = new PowerBooster(scopedPistol);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(boostedScopedPistol);
    timer.timeChanged();
    assertEquals(2, boostedScopedPistol.getNumAttachments());
    assertEquals(60, boostedScopedPistol.getMaxRange());
    assertEquals(36, boostedScopedPistol.fire(10));
    assertEquals(17, boostedScopedPistol.fire(30));
  }
  
  /**
   * Test double power booster on chain gun.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testChainDualBooster() throws AttachmentException, WeaponException {
    ChainGun chain = new ChainGun();
    PowerBooster boostedChain = new PowerBooster(chain);
    PowerBooster doubleBoostedChain = new PowerBooster(boostedChain);
    assertEquals(2, doubleBoostedChain.getNumAttachments());
    assertEquals(60, doubleBoostedChain.getMaxRange());
    assertEquals(24, doubleBoostedChain.fire(25));
    assertEquals(57, doubleBoostedChain.fire(60));
  }
  
  /**
   * Test stabilizer and power booster on plasma cannon.
   * @throws AttachmentException when broken.
   * @throws WeaponException when broken.
   */
  @Test
  public void testPlasmaStabilizerBooster() throws AttachmentException, WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    Stabilizer stabilizedPlasma = new Stabilizer(pc);
    PowerBooster boostedStabilizedPlasma = new PowerBooster(stabilizedPlasma);
    assertEquals(2, boostedStabilizedPlasma.getNumAttachments());
    assertEquals(40, boostedStabilizedPlasma.getMaxRange());
    assertEquals(124, boostedStabilizedPlasma.fire(25));
    assertEquals(0, boostedStabilizedPlasma.fire(60));
  }

}
