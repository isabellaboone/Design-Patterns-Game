package lifeform;

import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * Allows us to make aliens.
 * @author andrewjanuszko
 */
public class Alien extends LifeForm implements TimerObserver {
  
  private int maxLifePoints;
  private RecoveryBehavior recoveryBehavior = new RecoveryNone();
  private int recoveryRate = 0;

  /**
   * Creates an alien.
   * @param name holds the name of the alien.
   * @throws RecoveryRateException if things are broken.
   */
  public Alien(String name, int maxLifePoints) throws RecoveryRateException {
    super(name, maxLifePoints, 10);
    setMaxLifePoints(maxLifePoints);
  }
  
  /**
   * Creates an alien.
   * @param name holds the name of the alien.
   * @throws RecoveryRateException if things are broken.
   */
  public Alien(String name, int maxLifePoints, RecoveryBehavior behavior)
      throws RecoveryRateException {
    super(name, maxLifePoints, 10);
    recoveryBehavior = behavior;
    setMaxLifePoints(maxLifePoints);
  }
  
  /**
   * Creates an alien.
   * @param name holds the name of the alien.
   * @throws RecoveryRateException if things are broken.
   */
  public Alien(String name, int maxLifePoints, RecoveryBehavior behavior, int recoveryRate)
      throws RecoveryRateException {
    super(name, maxLifePoints, 10);
    recoveryBehavior = behavior;
    setMaxLifePoints(maxLifePoints);
    recoveryBehavior = behavior;
    if (recoveryRate < 0) {
      throw new RecoveryRateException("Invalid recovery rate. (recoveryRate < 0)");
    }
    this.recoveryRate = recoveryRate;
  }
  
  /**
   * Sets the max life points.
   */
  public void setMaxLifePoints(int maxLifePoints) {
    this.maxLifePoints = maxLifePoints; 
  }
  
  /**
   * Gets the recovery rate.
   * @return the recovery rate.
   */
  public int getRecoveryRate() {
    return recoveryRate;
  }

  /**
   * Gets the max life points.
   * @return the max life points.
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  /**
   * Gets the recovery behavior.
   * @return the recoveryBehavior.
   */
  public RecoveryBehavior getRecoveryBehavior() {
    return recoveryBehavior;
  }
  
  /**
   * Allows aliens to recover.
   */
  public void recover() {
    currentLifePoints = recoveryBehavior.calculateRecovery(
        getCurrentLifePoints(), getMaxLifePoints());
  }
  
  /**
   * sets recovery rate.
   */
  public void setRecoveryRate(int rr) {
    this.recoveryRate = rr;
  }

  /**
   * cause it updates time.
   */
  public void updateTime(int time) {
    if (time % recoveryRate == 0) {
      this.recover();
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
  
}
