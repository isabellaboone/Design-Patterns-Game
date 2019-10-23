package weapon;

import exceptions.WeaponException;

/**
 * Template for a mock weapon.
 * @author andrewjanuszko
 *
 */
public class MockWeapon extends GenericWeapon {
  
  /**
   * Allows us to create a mock weapon.
   */
  public MockWeapon() {
    this.baseDamage = 5;
    this.maxRange = 40;
    this.rateOfFire = 3;
    this.maxAmmo = 20;
    this.currentAmmo = getMaxAmmo();
    this.shotsLeft = getRateOfFire();
  }
  
  /**
   * Allows us to fire a mock weapon.
   */
  @Override
  public int fire(int distance) throws WeaponException {
    if (getShotsLeft() == 0) {
      return 0;
    }
    if (distance < 0) {
      throw new WeaponException("Distance cannot be negative.");
    }
    if (getCurrentAmmo() == 0) {
      return 0;
    }
    --this.currentAmmo;
    --this.shotsLeft;
    return (distance > getMaxRange())
      ? 0
      : Double.valueOf(
             Math.floor(getBaseDamage() * (getMaxRange() - distance + 10) / getMaxRange())
           ).intValue();
  }

  /**
   * To string for a mock weapon.
   */
  @Override
  public String toString() {
    return "MockWeapon";
  }

}
