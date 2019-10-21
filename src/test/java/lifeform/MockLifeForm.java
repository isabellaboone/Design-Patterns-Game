package lifeform;

import exceptions.WeaponException;

public class MockLifeForm extends LifeForm {

  /**
   * A mock LifeForm to use for testing.
   * @param name — the name of the LifeForm.
   * @param points — the health points of the LifeForm.
   */
  public MockLifeForm(String name, int points) {
    super(name, points);
  }
  
  public MockLifeForm(String name, int points, int attack) {
    super(name, points, attack);
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
    if (time >= 0) {
      // nothing
    } else {
      System.out.println("I don't know how you managed to get a negative round, but you did.");
    }
  }
  
}
