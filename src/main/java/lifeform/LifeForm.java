package lifeform;

import exceptions.WeaponException;
import weapon.Weapon;

/**
 * An abstract class used as the base of a LifeForm type.
 * @author andrewjanuszko
 */
public abstract class LifeForm implements Weapon {

  private String myName;
  protected int currentLifePoints;
  private int attackStrength;
  public Weapon weapon;
  protected int row;
  protected int col;
  
  /**
   * LifeForm constructor — template for LifeForm type.
   * @param name — holds the name of the LifeForm.
   * @param points — holds the health points of the LifeForm.
   */
  public LifeForm(String name, int points) {
    this(name, points, 1);
    setLocation(-1, -1);
  }
  
  /**
   * LifeForm constructor — template for LifeForm type.
   * @param name — holds the name of the LifeForm.
   * @param points — holds the health points of the LifeForm.
   */
  public LifeForm(String name, int points, int attack) {
    myName = name;
    currentLifePoints = points;
    attackStrength = attack;
    setLocation(-1, -1);
  }
  
  /**
   * Allows the user to get the assigned life
   * points of a LifeForm. 
   * @return the life points of the LifeForm.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }
  
  /**
   * Allows the user to get the assigned name
   * of a LifeForm.
   * @return the name of the LifeForm.
   */
  public String getName() {
    return myName;
  }
  
  /**
   * Allows LifeForms to take damage.
   */
  public void takeHit(int damage) {
    currentLifePoints = (getCurrentLifePoints() - damage) < 0 
        ? 0 : getCurrentLifePoints() - damage;
  }
  
  /**
   * Returns the attack strength of the LifeForm.
   * @return the attack strength.
   */
  public int getAttackStrength() {
    return attackStrength;
  }
  
  /**
   * Sets the current lifePoints of the LifeForm.
   */
  public void setCurrentLifePoints(int lifePoints) {
    currentLifePoints = lifePoints;
  }
  
  /**
   * Allows the user to attack other lifeforms.
   * @param lf the lifeform to attack.
   * @throws WeaponException if distance is incorrect.
   */
  public void attack(LifeForm lf, int distance) throws WeaponException {
    if (this.currentLifePoints != 0) {
      if (!hasWeapon() || (hasWeapon() && weapon.getCurrentAmmo() == 0)) {
        if (distance <= 5) {
          lf.takeHit(getAttackStrength());
        } else {
          lf.takeHit(0);
        }
      } else {
        lf.takeHit(weapon.fire(distance));
      }
    } else {
      lf.takeHit(0);
    }
  }
  
  /**
   * Allows lifeforms to pick up weapons.
   * @param weapon is the weapon to be picked up.
   * @return true or false depending on if the weapon was picked up.
   */
  public boolean pickUpWeapon(Weapon weapon) {
    if (hasWeapon()) {
      return false;
    }
    if (this.weapon == null) {
      this.weapon = weapon;
    }
    this.weapon.updateTime(0);
    return (this.weapon == weapon) ? true : false;
  }
  
  /**
   * Allows lifeforms to drop weapons.
   * @return the dropped weapon.
   */
  public Weapon dropWeapon() {
    if (!hasWeapon()) {
      return null;
    }
    Weapon dropped = weapon;
    weapon = null;
    return dropped;
  }
  
  /**
   * Allows lifeforms to see if they have weapons.
   * @return true or false.
   */
  public boolean hasWeapon() {
    return (weapon == null) ? false : true;
  }
  
  /**
   * 
   * @return
   */
  public int getRow() {
    return row;
  }
  
  /**
   * 
   * @return
   */
  public int getCol() {
    return col;
  }
  
  public void setLocation(int row, int col) {
    if (row < -1 || col < -1) {
      return;
    } else {
      
    }
  }

}
