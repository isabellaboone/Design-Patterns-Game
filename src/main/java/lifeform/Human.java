package lifeform;

import exceptions.WeaponException;

/**
 * A class for making humans.
 * @author andrewjanuszko
 */
public class Human extends LifeForm {

  private int armor;

  /**
   * Allows us to create humans.
   * @param name holds the name for the human.
   * @param points holds the points for the human.
   * @param armor holsd the points for the armor.
   */
  public Human(String name, int points, int armor) {
    super(name, points, 5);
    setArmorPoints(armor);
  }
  
  /**
   * Return the armor points of the Human.
   * @return the armor points.
   */
  public int getArmorPoints() {
    return armor;
  }
  
  /**
   * Allows the user to set the armor points of the Human.
   * @param points — holds the armor points to be assigned.
   */
  public void setArmorPoints(int points) {
    armor = (points < 0)
        ? armor : points;
  }
  
  /**
   * Humans take damage differently than normal lifeforms.
   */
  @Override
  public void takeHit(int damage) {
    int remainingDamage = (getArmorPoints() - damage);
    if (remainingDamage < 0) {
      currentLifePoints = (getCurrentLifePoints() - Math.abs(remainingDamage)) <= 0
          ? 0 : getCurrentLifePoints() - Math.abs(remainingDamage);
    }
  }

  @Override
  public int fire(int distance) throws WeaponException {
    return weapon.fire(distance);
  }

  @Override
  public int getBaseDamage() {
    return weapon.getBaseDamage();
  }

  @Override
  public int getCurrentAmmo() {
    return weapon.getCurrentAmmo();
  }

  @Override
  public int getMaxAmmo() {
    return weapon.getMaxAmmo();
  }

  @Override
  public int getMaxRange() {
    return weapon.getMaxRange();
  }

  @Override
  public int getNumAttachments() {
    return weapon.getNumAttachments();
  }

  @Override
  public int getRateOfFire() {
    return weapon.getRateOfFire();
  }

  @Override
  public int getShotsLeft() {
    return weapon.getShotsLeft();
  }

  @Override
  public void reload() {
    weapon.reload();
  }

  @Override
  public void updateTime(int time) {
    
  }
  
  @Override
  public String getStats() {
    return "<html><h1 style = font-size:30px; text-align:center>" +  getName() + "</h1><br/>"
        + "Health: " + currentLifePoints + "/" + maxLifePoints + "<br/>"
        + "Attack: " + getAttackStrength() + "<br/>"
        + "Armor: " + armor + "<br/>"
        + "Weapon: " + (hasWeapon() ? weapon : "None")
        + "<br/>_________________________________________"
        + "</html>";
  }
}
