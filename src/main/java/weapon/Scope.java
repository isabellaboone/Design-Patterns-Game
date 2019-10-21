package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * Template for scopes.
 * @author andrewjanuszko
 */
public class Scope extends Attachment {

  /**
   * Creates an instance of a Scope wrapped around a base GenericWeapon.
   * Scopes add 10 to the maxRange of the base Weapon
   * @param baseWeapon — the weapon to be modified.
   * @throws AttachmentException if the attachment is incorrect.
   */
  public Scope(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Too many attachments!");
    }
    this.base = baseWeapon;
  }
  
  /**
   * Fire the weapon once, this reduces the current ammo by one bullet.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target.
   * @throws WeaponException if distance is incorrect.
   */
  public int fire(int distance) throws WeaponException {
    if (base.getMaxRange() < distance && distance <= getMaxRange()) {
      return (5 + base.fire(base.getMaxRange()));
    }
    return Double.valueOf(
        Math.floor(base.fire(distance) * (
            1 + (getMaxRange() - distance) / Double.valueOf(getMaxRange())))
    ).intValue();
  }
  
  /**
   * Get the maximum range of the current weapon.
   * @return the maximum range of the weapon.
   */
  public int getMaxRange() {
    return base.getMaxRange() + 10;   
  }
  
  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    return base.toString() + " +Scope";
  }
  
}
