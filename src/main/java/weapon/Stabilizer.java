package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * Template for stabilizers.
 * @author andrewjanuszko
 */
public class Stabilizer extends Attachment {
  
  /**
   * Creates a stabilizer.
   * @param baseWeapon — the weapon to be modified.
   * @throws AttachmentException if attachment is incorrect.
   */
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Too many attachments!");
    }
    this.base = baseWeapon;
  }

  /**
   * A Stabilizer auto reloads if ammo is at 0 after firing.
   * A Stabilizer also increases the Weapon's damage by 25%.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if distance is incorrect.
   */
  public int fire(int distance) throws WeaponException {
    if (base.getShotsLeft() == 0) {
      return 0;
    }
    int damage = base.fire(distance);
    if (base.getCurrentAmmo() == 0) {
      base.reload();
    }
    return Double.valueOf(
             Math.floor(Math.floor(0.25 * damage) + damage)
           ).intValue();
  }
  
  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    return base.toString() + " +Stabilizer";
  }
}
