package weapon;

import exceptions.WeaponException;
import gameplay.TimerObserver;

/**
 * A template for all weapons.
 * @author andrewjanuszko
 */
public interface Weapon extends TimerObserver {

  /**
   * Fire the weapon once, this reduces the current ammo by one bullet.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if the distance is incorrect.
   */
  public int fire(int distance) throws WeaponException;
  
  /**
   * Get the base damage of the current weapon.
   * @return the base damage of this weapon.
   */
  public int getBaseDamage();
  
  /**
   * Gets the number of bullets in the clip of the current weapon.
   * @return the current number of bullets in the clip.
   */
  public int getCurrentAmmo();
  
  /**
   * Gets the clip size of the current weapon.
   * @return the clip size of this weapon.
   */
  public int getMaxAmmo();
  
  /**
   * Get the maximum range of the current weapon.
   * @return the maximum range of the weapon.
   */
  public int getMaxRange();
  
  /**
   * Get the number of attachments on the current weapon.
   * @return the number of attachments on this Weapon.
   */
  public int getNumAttachments();
  
  /**
   * Get the number of times the current weapon may fire during a round.
   * @return the number of times this weapon may fire during a round.
   */
  public int getRateOfFire();
  
  /**
   * Gets the number of shots left in the current round.
   * @return the number of shots left in this round.
   */
  public int getShotsLeft();
  
  /**
   * Reload the clip to full capacity.
   * For now, we assume a limitless supply of clips.
   * This may be refactored in the future to take ammo reserves into account.
   */
  public void reload();
  
  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public String toString();
  
}
