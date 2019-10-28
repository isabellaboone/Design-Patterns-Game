package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import lifeform.MockLifeForm;
import weapon.MockWeapon;

import org.junit.Test;

/**
 * The JUnit 4 test file for Cell.class
 * @author andrewjanuszko
 */
public class TestCell {

  /**
   * Tests to see if a Cell can be properly
   * initialized.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
    assertEquals(0, cell.getWeaponsCount());
  }
  
  /**
   * Tests to see if a LifeForm can be
   * properly added to a Cell.
   */
  @Test
  public void testAddLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    MockLifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }
  
  /**
   * Tests to see if the overwrite protection
   * works properly on a Cell.
   */
  @Test
  public void testOverwriteLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();
    cell.addLifeForm(bob);
    assertEquals(bob, cell.getLifeForm());
    MockLifeForm fred = new MockLifeForm("Fred", 40);
    assertFalse(cell.addLifeForm(fred));
  }
  
  /**
   * Tests to see if LifeForms can be
   * properly removed from a Cell.
   */
  @Test
  public void testRemoveLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();
    cell.addLifeForm(bob);
    assertEquals(bob, cell.getLifeForm());
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
  }
  
  /**
   * Test to see that we can add weapons to a cell.
   */
  @Test
  public void testAddWeapon() {
    MockWeapon mock1 = new MockWeapon();
    MockWeapon mock2 = new MockWeapon();
    MockWeapon mock3 = new MockWeapon();
    Cell cell = new Cell();
    assertEquals(0, cell.getWeaponsCount());
    assertTrue(cell.addWeapon(mock1));
    assertEquals(1, cell.getWeaponsCount());
    assertEquals(mock1, cell.getWeapon1());
    assertTrue(cell.addWeapon(mock2));
    assertEquals(2, cell.getWeaponsCount());
    assertEquals(mock2, cell.getWeapon2());
    assertFalse(cell.addWeapon(mock3));
    assertEquals(2, cell.getWeaponsCount());
    assertFalse(cell.addWeapon(mock1));
    assertFalse(cell.addWeapon(mock2));
  }
  
  /**
   * Test to see that we can remove weapons from a cell.
   */
  @Test
  public void testRemoveWeapon() {
    MockWeapon mock1 = new MockWeapon();
    MockWeapon mock2 = new MockWeapon();
    MockWeapon mock3 = new MockWeapon();
    Cell cell = new Cell();
    cell.addWeapon(mock1);
    cell.addWeapon(mock2);
    assertNull(cell.removeWeapon(mock3));
    assertNotNull(cell.removeWeapon(mock1));
    assertNotNull(cell.removeWeapon(mock2));
    assertNull(cell.removeWeapon(mock1));
    assertNull(cell.removeWeapon(mock2));
  }

}
