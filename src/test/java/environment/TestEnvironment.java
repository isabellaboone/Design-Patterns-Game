package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;

import lifeform.MockLifeForm;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import weapon.MockWeapon;

/**
 * The JUnit 4 test file for Environment.class
 * @author andrewjanuszko
 *
 */
public class TestEnvironment {

  private Environment env;
  
  /**
   * Creates our environment.
   */
  @Before
  public void createEnvironment() {
	  env = Environment.getEnvironment(100, 100);
  }

  /**
   * Tests to see if we can initialize Environments
   * correctly.
   */
  @Test
  public void testInitialization() {
    env.clearBoard();
    assertNull(env.getLifeForm(0, 0));
  }
  
  /**
   * Test that a weapon can be added to an environment.
   */
  @Test
  public void testAddWeapon() {
    env.clearBoard();
    MockWeapon weapon = new MockWeapon();
    assertTrue(env.addWeapon(weapon, 1, 1));
  }
  
  /**
   * Test removing weapons from cells.
   */
  @Test
  public void testRemoveWeapon() {
    MockWeapon weapon = new MockWeapon();
    assertTrue(env.addWeapon(weapon, 1, 1));
    env.removeWeapon(weapon, 1, 1);
  }
  
  /**
   * Test getting rows.
   */
  @Test
  public void testGetRow() {
    assertEquals(100, env.getNumRows());
  }
  
  /**
   * Test getting cols.
   */
  @Test
  public void testGetCols() {
    assertEquals(100, env.getNumCols());
  }
  
  /**
   * Test distances along two different positions in same rows.
   */
  @Test
  public void testGetDistanceSameRow() {
    assertEquals(0, env.getDistance(2, 3, 2, 3), 0.1);
  }
  
  /**
   * Test distances along two different positions in same cols.
   */
  @Test
  public void testGetDistanceSameCol() {
    assertEquals(5.0, env.getDistance(1, 3, 2, 3), 0.1);
  }
  
  /**
   * Test distances along two different positions in different rows/cols.
   */
  @Test
  public void testGetDistanceDiff() {
    assertEquals(7.07, env.getDistance(2, 2, 3, 3), 0.1);
  }

  /**
   * Tests to see if we can add LifeForms to
   * Environments correctly.
   */
  @Test
  public void testAddLifeForm() {
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertEquals(lf, env.getLifeForm(1, 1));
    env.clearBoard();
  }
  
  /**
   * Tests the border cases of the Environment.
   */
  @Test
  public void testBorderCases() {
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertTrue(env.addLifeForm(lf, i, j));
        assertEquals(lf, env.getLifeForm(i, j));
      }
    }
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertFalse(env.addLifeForm(lf, i, j));
        assertEquals(lf, env.getLifeForm(i, j));
      }
    }
  }
  
  /**
   * Tests to see if we can remove LifeForms
   * from the environment correctly.
   */
  @Test
  public void testRemoveLifeForm() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertTrue(env.addLifeForm(lf, i, j));
        assertEquals(lf, env.getLifeForm(i, j));
      }
    }
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        assertEquals(lf, env.getLifeForm(i, j));
        env.removeLifeForm(i, j);
        assertNull(env.getLifeForm(i, j));
      }
    }
  }
  
  /**
   * Tests to see if the code can prevent
   * users from overwriting their Environment
   * without removing LifeForms.
   */
  @Test
  public void testOverwriteLifeForm() {
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertFalse(env.addLifeForm(lf, 1, 1));
  }
}
