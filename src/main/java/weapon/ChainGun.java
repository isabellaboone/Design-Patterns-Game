package weapon;

import exceptions.WeaponException;

/**
 * Template for all chain guns.
 * @author andrewjanuszko
 */
public class ChainGun extends GenericWeapon {

  /**
   * Creates a chain gun.
   */
  public ChainGun() {
    this.baseDamage = 15;
    this.maxRange = 60;
    this.rateOfFire = 4;
    this.maxAmmo = 40;
    this.currentAmmo = getMaxAmmo();
    this.shotsLeft = getRateOfFire();
  }
  
  /**
   * Fire at a target that is some distance away.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if distance is incorrect.
   */
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
          Math.floor(getBaseDamage() * (distance / Double.valueOf(getMaxRange())))
        ).intValue();
  }

  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    return "ChainGun";
  }

}
