package environment;

import java.util.ArrayList;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A class that creates a Cell type.
 * 
 * @author andrewjanuszko
 */

public class Cell extends Object {

  LifeForm lifeform;
  ArrayList<Weapon> weapons = new ArrayList<Weapon>();

  /**
   * Allows the user to return the stored LifeForm.
   * 
   * @return the LifeForm
   */
  public LifeForm getLifeForm() {
    return lifeform;
  }

  /**
   * Allows the user to add a LifeForm.
   * 
   * @param lifeform — the LifeForm to be stored.
   * @return true is the LifeForm was added, false if a LifeForm is saved.
   */
  public boolean addLifeForm(LifeForm lifeform) {
    if (!hasLifeForm()) {
      this.lifeform = lifeform;
      return true;
    }
    return false;
  }

  /**
   * Allows the user to remove a LifeForm.
   */
  void removeLifeForm() {
    lifeform = null;
  }

  /**
   * Returns how many weapons are left in the cell.
   * 
   * @return the number of weapons left.
   */
  public int getWeaponsCount() {
    return weapons.size(); // returns 0 / 1 / 2
  }

  /**
   * check to see if a weapon is in a cell.
   * @return if a cell has a weapon.
   */
  public boolean hasWeapon() {
    return (weapons.size() > 0) ? true : false;
  }

  /**
   * Adds a weapon to a cell.
   * 
   * @param weapon is the weapon to be put inside of the cell.
   * @return true if placed successfully, false otherwise.
   */
  public boolean addWeapon(Weapon weapon) {
    if (weapons.contains(weapon) || weapons.size() == 2) {
      return false;
    }
    weapons.add(weapon);
    return true;
  }

  /**
   * Removes weapon if the weapon is in a cell.
   * 
   * @param weapon the weapon to be removed.
   * @return the removed weapon. Null otherwise.
   */
  public Weapon removeWeapon(Weapon weapon) {
    if (!weapons.contains(weapon)) {
      return null;
    }
    return weapons.remove(weapons.indexOf(weapon));
  }

  /**
   * Get the weapon in slot #1.
   * 
   * @return the weapon in slot #1.
   */
  public Weapon getWeapon1() {
    if (getWeaponsCount() == 0) {
      return null;
    }
    return weapons.get(0);
  }

  /**
   * Get the weapon in slot #2.
   * 
   * @return the weapon in slot #2.
   */
  public Weapon getWeapon2() {
    if (getWeaponsCount() < 2) {
      return null;
    }
    return weapons.get(1);
  }

  /**
   * Return whether the cell has a lifeform in it.
   */
  public boolean hasLifeForm() {
    return (lifeform == null) ? false : true;
  }

  /**
   * i like set direction better.
   * 
   * @return
   */
  public void setDirection(int direction) {
    if (!hasLifeForm()) {
      lifeform.turn(direction);
    }
  }

  /**
   * gets the direction of a lifeform in the cell.
   * @return the direct of the lifeform in the cell.
   */
  public int getDirection() {
    if (hasLifeForm()) {
      return lifeform.getDirection();
    }
    return 0;
  }

  /**
   * gets the statue of the cell.
   * @return the stats in HTML.
   */
  public String getStats() {
    // if(hasLifeForm()) {
    return "<html><h1 style = font-size:30px; text-align:center>Ground</h1><br/>" + "Weapon 1: "
        + (getWeapon1() == null ? "none" : getWeapon1()) + "<br/>" + "Weapon 2: "
        + (getWeapon2() == null ? "none" :
          getWeapon2()) + "<br/>" + "<br/>_____________________________________________"
        + (hasLifeForm() ? lifeform.getStats() :
          "");
    // }
  }

}
