package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * Template for power boosters.
 * @author andrewjanuszko
 */
public class PowerBooster extends Attachment {
  
  /**
   * Power Boosters increase the base Weapon's damage based on how much ammo is left.
   * The more ammo left, the more powerful the boost.
   * @param baseWeapon the weapon to me modified.
   * @throws AttachmentException if the attachment is incorrect.
   */
  public PowerBooster(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Too many attachments!");
    }
    this.base = baseWeapon;
  }
  
  /**
   * Most attachments will change the damage the weapon does when it fires.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if distance is incorrect.
   */
  public int fire(int distance) throws WeaponException {
    if (base.getShotsLeft() == 0) {
      return 0;
    }
    return Double.valueOf(
             Math.floor((1 + (
                 base.getCurrentAmmo()) / (double) base.getMaxAmmo()) * base.fire(distance))
           ).intValue();
  }
  
  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString() {
    return base.toString() + " +PowerBooster";
  }
  
}
