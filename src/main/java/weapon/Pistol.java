package weapon;

import exceptions.WeaponException;

/**
 * Template for all pistols.
 * @author andrewjanuszko
 */
public class Pistol extends GenericWeapon {

  /**
   * Creates a pistol.
   */
  public Pistol() {
    this.baseDamage = 10;
    this.maxRange = 50;
    this.rateOfFire = 2;
    this.maxAmmo = 10;
    this.currentAmmo = getMaxAmmo();
    this.shotsLeft = getShotsLeft();
  }
  
  /**
   * Fire at a target that is some distance away.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if the distance is incorrect.
   */
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException("Distance cannot be negative.");
    }
   // if (getCurrentAmmo() == 0) {
   //   return 0;
   // }
    if (this.getShotsLeft() == 0) {
      return 0;
    }
   // --this.currentAmmo;
    --this.shotsLeft;
    return (distance > getMaxRange())
      ? 0
      : Double.valueOf(
             Math.floor(getBaseDamage() * (getMaxRange() - distance + 10) / getMaxRange())
           ).intValue();

  }

  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    return "Pistol";
  }

}
