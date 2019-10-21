package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;
import weapon.MockWeapon;

/**
 * The JUnit 4 test file for LifeForm.class
 * @author andrewjanuszko
 */
public class TestLifeForm {
  
  /**
   * Tests to see if we can initialize LifeForms.
   */
  @Test
  public void testInitialization() {
    MockLifeForm entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
    assertEquals(40, entity.getCurrentLifePoints());
  }
  
  /**
   * Tests getting the name of LifeForms.
   */
  @Test
  public void testGetName() {
    MockLifeForm entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
  }
  
  /**
   * Test getting the lifepoints of LifeForms.
   */
  @Test
  public void testLifePoints() {
    MockLifeForm entity = new MockLifeForm("Bob", 40);
    assertEquals(40, entity.getCurrentLifePoints());
  }
  
  /**
   * Test LifeForms taking damage.
   */
  @Test
  public void testTakeHit() {
    MockLifeForm entity = new MockLifeForm("Bob", 40);
    entity.takeHit(10);
    assertEquals(30, entity.getCurrentLifePoints());
  }
  
  /**
   * Test LifeForms taking damage frequently.
   */
  @Test
  public void testMultipleHits() {
    MockLifeForm entity = new MockLifeForm("Bob", 40);
    entity.takeHit(10);
    assertEquals(30, entity.getCurrentLifePoints());
    entity.takeHit(50);
    assertEquals(0, entity.getCurrentLifePoints());
  }
  
  /**
   * Test if LifeForms can attack eachother.
   * @throws WeaponException if broken.
   */
  @Test
  public void testAttackLifeForm() throws WeaponException {
    MockLifeForm drake = new MockLifeForm("Drake", 50, 10);
    MockLifeForm josh = new MockLifeForm("Josh", 60, 10);
    assertEquals(60, josh.getCurrentLifePoints());
    assertEquals(50, drake.getCurrentLifePoints());
    drake.attack(josh, 3);
    assertEquals(50, josh.getCurrentLifePoints());
    josh.attack(drake, 3);
    assertEquals(40, drake.getCurrentLifePoints());
  }

  /**
   * Dead LifeForms cannot attack.
   * @throws WeaponException if broken.
   */
  @Test
  public void testAttackOfTheDead() throws WeaponException {
    MockLifeForm physicsgrade = new MockLifeForm("Physics Grade", 0, 100);
    MockLifeForm mentalhealth = new MockLifeForm("Mental Health", 20, 0);
    assertEquals(0, physicsgrade.getCurrentLifePoints());
    assertEquals(20, mentalhealth.getCurrentLifePoints());
    physicsgrade.attack(mentalhealth, 5);
    assertEquals(20, mentalhealth.getCurrentLifePoints());
  }
  
  /**
   * Test if lifeforms can pick up weapons.
   */
  @Test
  public void testPickUpWeapon() {
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    MockWeapon rifle = new MockWeapon();
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
  }
  
  /**
   * Test if lifeforms know that they have weapons.
   */
  @Test
  public void testAlreadyHasWeapon() {
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    MockWeapon rifle = new MockWeapon();
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
    assertFalse(hunter.pickUpWeapon(rifle));
  }
  
  /**
   * Test if lifeforms can drop weapons.
   */
  @Test
  public void testDropWeapon() {
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    MockWeapon rifle = new MockWeapon();
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
    
    MockWeapon droppedWeapon = (MockWeapon) hunter.dropWeapon();
    assertEquals(droppedWeapon, rifle);
    assertFalse(hunter.hasWeapon());
  }
  
  /**
   * Test if lifeforms can do melee damage.
   * @throws WeaponException if broken.
   */
  @Test
  public void testMeleeWhenNoAmmo() throws WeaponException {
    MockWeapon rifle = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(rifle);
    timer.timeChanged();
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    for (int i = 0; i < 20; i++) {
      assertEquals(5, rifle.fire(10));
      timer.timeChanged();
    }
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
    MockLifeForm bear = new MockLifeForm("Bear", 20, 5);
    hunter.attack(bear, 5);
    assertEquals(10, bear.getCurrentLifePoints());
  }
  
  /**
   * Test if lifeforms can do melee damage.
   * @throws WeaponException if broken.
   */
  @Test
  public void testPunchRange() throws WeaponException {
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    MockLifeForm bear = new MockLifeForm("Bear", 20, 5);
    hunter.attack(bear, 6);
    assertEquals(20, bear.getCurrentLifePoints());
  }
  
  /**
   * Test that lifeforms can reload.
   * @throws WeaponException if broken.
   */
  @Test
  public void testCanReload() throws WeaponException {
    MockWeapon rifle = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(rifle);
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    timer.timeChanged();
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
    
    assertEquals(20, hunter.getCurrentAmmo());
    hunter.fire(20);
    assertEquals(19, hunter.getCurrentAmmo());
    hunter.reload();
    assertEquals(20, hunter.getCurrentAmmo());
  }
  
  /**
   * Test that lifeforms can shoot other lifeforms.
   * @throws WeaponException if broken.
   */
  @Test
  public void testCanShootSomeone() throws WeaponException {
    MockWeapon rifle = new MockWeapon();
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(rifle);
    MockLifeForm hunter = new MockLifeForm("Hunter", 100, 10);
    MockLifeForm bear = new MockLifeForm("Bear", 20, 5);
    assertEquals(20, bear.getCurrentLifePoints());
    assertFalse(hunter.hasWeapon());
    assertTrue(hunter.pickUpWeapon(rifle));
    assertTrue(hunter.hasWeapon());
    hunter.attack(bear, 5);
    hunter.attack(bear, 5);
    hunter.attack(bear, 5);
    assertEquals(5, bear.getCurrentLifePoints());
  }
}
