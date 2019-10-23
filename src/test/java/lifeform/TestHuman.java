package lifeform;

import static org.junit.Assert.assertEquals;

import exceptions.WeaponException;
import org.junit.Test;

/**
 * A JUnit 4 test case for Human().
 * @author andrewjanuszko
 */
public class TestHuman {

  /**
   * Test the creation of human.
   */
  @Test
  public void testInitialization() {
    Human andrew = new Human("Andrew", 50, 10);
    assertEquals("Andrew", andrew.getName());
    assertEquals(50, andrew.getCurrentLifePoints());
    assertEquals(10, andrew.getArmorPoints());
  }
  
  /**
   * Test the setting of armor for humans.
   */
  @Test
  public void testSetArmorPoints() {
    Human andrew = new Human("Andrew", 50, 10);
    assertEquals(10, andrew.getArmorPoints());
    andrew.setArmorPoints(70);
    assertEquals(70, andrew.getArmorPoints());
  }
  
  /**
   * Test the getting of armor for humans.
   */
  @Test
  public void testGetArmorPoints() {
    Human andrew = new Human("Andrew", 50, 10);
    assertEquals(10, andrew.getArmorPoints());
  }
  
  /**
   * Test invalid armor points for humans.
   */
  @Test
  public void testInvalidArmorPoints() {
    Human andrew = new Human("Andrew", 50, 10);
    assertEquals(10, andrew.getArmorPoints());
    andrew.setArmorPoints(-1);
    assertEquals(10, andrew.getArmorPoints());
    andrew.setArmorPoints(20);
    assertEquals(20, andrew.getArmorPoints());
  }
  
  /**
   * Test getting attack strength.
   */
  @Test
  public void testAttackStrength() {
    Human isabella = new Human("Isabella", 40, 6);
    assertEquals(5, isabella.getAttackStrength());
  }
  
  /**
   * Test health when armor > damage.
   */
  @Test
  public void testAbsorbDamage() {
    Human isabella = new Human("Isabella", 40, 6);
    isabella.takeHit(5);
    assertEquals(40, isabella.getCurrentLifePoints());
  }
  
  /**
   * Test health when armor < damage.
   */
  @Test
  public void testReduceDamage() {
    Human isabella = new Human("Isabella", 40, 6);
    isabella.takeHit(10);
    assertEquals(36, isabella.getCurrentLifePoints());
  }
  
  /**
   * Test health when armor == damage.
   */
  @Test
  public void testArmorIsDamage() { 
    Human isabella = new Human("Isabella", 40, 6);
    isabella.takeHit(6);
    assertEquals(40, isabella.getCurrentLifePoints());
  }
  
  /**
   * Test that humans can attack humans.
   * @throws WeaponException when broken.
   */
  @Test
  public void testHumanVsHuman() throws WeaponException {
    Human sam = new Human("Sam", 40, 1);
    Human fender = new Human("Fender", 60, 3);
    sam.attack(fender, 5);
    assertEquals(58, fender.getCurrentLifePoints());
    fender.attack(sam, 5);
    assertEquals(36, sam.getCurrentLifePoints());
  }
}
