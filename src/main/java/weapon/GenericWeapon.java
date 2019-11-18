package weapon;

import exceptions.WeaponException;

/**
 * Template for all generic weapons.
 * @author andrewjanuszko
 */
public abstract class GenericWeapon extends Object implements Weapon {

  protected int baseDamage;
  protected int maxRange;
  protected int rateOfFire;
  protected int maxAmmo;
  protected int currentAmmo;
  protected int shotsLeft;
  
  /**
   * Fire at a target that is some distance away.
   * @param distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if distance is incorrect.
   */
  public abstract int fire(int distance) throws WeaponException;
  
  /**
   * Get the base damage of the current weapon.
   * @return the base damage of this weapon.
   */
  public int getBaseDamage() {
    return this.baseDamage;
  }
  
  /**
   * Gets the number of bullets in the clip of the current weapon.
   * @return the current number of bullets in the clip.
   */
  public int getCurrentAmmo() {
    return this.currentAmmo;
  }
  
  /**
   * Gets the clip size of the current weapon.
   * @return the clip size of this weapon.
   */
  public int getMaxAmmo() {
    return this.maxAmmo;
  }

  /**
   * Get the maximum range of the current weapon.
   * @return the maximum range of the weapon.
   */
  public int getMaxRange() {
    return this.maxRange;
  }

  /**
   * Get the number of attachments on the current weapon.
   * @return the number of attachments on this Weapon.
   */
  public int getNumAttachments() {
    return 0;
  }

  /**
   * Get the number of times the current weapon may fire during a round.
   * @return the number of times this weapon may fire during a round.
   */
  public int getRateOfFire() {
    return this.rateOfFire;
  }

  /**
   * Gets the number of shots left in the current round.
   * @return the number of shots left in this round.
   */
  public int getShotsLeft() {
    return this.shotsLeft;
  }

  /**
   * Reload the clip to full capacity.
   * For now, we assume a limitless supply of clips.
   * This may be refactored in the future to take ammo reserves into account.
   */
  public void reload() {
    this.currentAmmo = getMaxAmmo();
  }

  /**
   * Displays the Weapon and any attachments.
   * @return the Weapon and any attachments.
   */
  public abstract String toString();

  /**
   * Updates the time of the system.
   */
  public void updateTime(int time) {
    if (time >= 0) {
      shotsLeft = getRateOfFire();
    } else {
      System.out.println("I don't know how you managed to get a negative round, but you did.");
    }
  }
  
}