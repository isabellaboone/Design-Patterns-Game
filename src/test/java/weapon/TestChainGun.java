package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.WeaponException;
import org.junit.Test;

/**
 * Test for the Chain Gun class.
 * @author andrewjanuszko
 *
 */
public class TestChainGun {

  /**
   * Test chain gun damage at 2 ranges.
   * @throws WeaponException if wrong.
   */
  @Test
  public void testChainDamageAtRanges() throws WeaponException {
    ChainGun chain = new ChainGun();
    assertEquals(15, chain.fire(60));
    assertEquals(0, chain.fire(0));
  }

}
