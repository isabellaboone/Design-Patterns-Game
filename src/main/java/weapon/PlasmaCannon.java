package weapon;

import exceptions.WeaponException;

/**
 * Template for all plasma cannons.
 * @author andrewjanuszko
 */
public class PlasmaCannon extends GenericWeapon {
  
  /**
   * Creates plasma cannon.
   */
  public PlasmaCannon() {
    this.baseDamage = 50;
    this.maxRange = 40;
    this.rateOfFire = 1;
    this.maxAmmo = 4;
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
    --this.shotsLeft;
    int damage = Double.valueOf(
        Math.floor(getBaseDamage() * (
            Double.valueOf(getCurrentAmmo()) / Double.valueOf(getMaxAmmo())))
        ).intValue();
    --this.currentAmmo;
    return (distance > getMaxRange())
      ? 0
      : damage;
  }

  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    // TODO Auto-generated method stub
    return "PlasmaCannon";
  }

}
