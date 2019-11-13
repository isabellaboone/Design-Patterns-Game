package lifeform;

import exceptions.WeaponException;
import weapon.Weapon;

/**
 * An abstract class used as the base of a LifeForm type.
 * 
 * @author andrewjanuszko
 */
public abstract class LifeForm implements Weapon {

  private String myName;
  protected int currentLifePoints;
  private int attackStrength;
  protected Weapon weapon;
  protected int row;
  protected int col;
  protected int direction;
  protected int movesLeft;

  /**
   * LifeForm constructor — template for LifeForm type.
   * 
   * @param name   — holds the name of the LifeForm.
   * @param points — holds the health points of the LifeForm.
   */
  public LifeForm(String name, int points) {
    this(name, points, 1);
    setLocation(-1, -1);
    turn(1);
  }

  /**
   * LifeForm constructor — template for LifeForm type.
   * 
   * @param name   — holds the name of the LifeForm.
   * @param points — holds the health points of the LifeForm.
   */
  public LifeForm(String name, int points, int attack) {
    myName = name;
    currentLifePoints = points;
    attackStrength = attack;
    setLocation(-1, -1);
    turn(1);
  }

  /**
   * Allows the user to get the assigned life points of a LifeForm.
   * 
   * @return the life points of the LifeForm.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * Allows the user to get the assigned name of a LifeForm.
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
        ? 0 
        : getCurrentLifePoints() - damage;
  }

  /**
   * Returns the attack strength of the LifeForm.
   * 
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
   * 
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
   * 
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
   * 
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
   * 
   * @return true or false.
   */
  public boolean hasWeapon() {
    return (weapon == null) ? false : true;
  }

  /**
   * Returns the row.
   * @return the row number
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column number.
   * @return the column number
   */
  public int getCol() {
    return col;
  }

  /**
   * Sets the location of the lifeform.
   * @param row the row number
   * @param col the column number
   */
  public void setLocation(int row, int col) {
    if (!((row < -1) || (col < -1))) {
      this.row = row;
      this.col = col;
    }
  }
  
  /**
	 * Returns the current direction of the LifeForm.
	 * @return the current direction of the LifeForm.
	 */
  public int getDirection() {
    return direction;
  }
  
  /**
   * Allows LifeForms to turn.
   * Up = 1 / Right = 2 / Down = 3 / Right = 4
   * @param direction, the direction to turn.
   * @return true if LifeForm turned, false if it did not.
   */
  public boolean turn(int direction) {
    return false;
  }
  
  /**
   * Moves 1 cell (5 meters) in the current direction of the LifeForm.
   * @return true if the LifeForm moved, false if it did not.
   */
  public boolean move() {
	  return false;
  }
  
}
