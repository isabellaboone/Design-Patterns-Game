package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import lifeform.MockLifeForm;

import org.junit.Test;

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
	  env = Environment.getEnvironment(4, 4);
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
    assertEquals(4, env.getNumRows());
  }
  
  /**
   * Test getting cols.
   */
  @Test
  public void testGetCols() {
    assertEquals(4, env.getNumCols());
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
  
  /**
   * Test that lifeforms can move north.
   */
  @Test
  public void moveNorth() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertEquals(1, env.getLifeForm(1, 1).getRow());
    assertEquals(1, env.getLifeForm(1, 1).getCol());
    env.selectCell(1,1);
    assertTrue(env.move());
    assertEquals(lf, env.getCell(0, 1).getLifeForm());
    env.clearBoard();
  }
  
  /**
   * Test that lifeforms can move south.
   */
  @Test
  public void moveSouth() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    lf.turn(3);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertEquals(1, env.getLifeForm(1, 1).getRow());
    assertEquals(1, env.getLifeForm(1, 1).getCol());
    env.selectCell(1,1);
    assertTrue(env.move());
    assertEquals(lf, env.getCell(2, 1).getLifeForm());
    env.clearBoard();
  }
  
  /**
   * Test that lifeforms can move east.
   */
  @Test
  public void moveEast() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    lf.turn(2);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertEquals(1, env.getLifeForm(1, 1).getRow());
    assertEquals(1, env.getLifeForm(1, 1).getCol());
    env.selectCell(1,1);
    assertTrue(env.move());
    assertEquals(lf, env.getCell(1, 2).getLifeForm());
    env.clearBoard();
  }
  
  /**
   * Test that lifeforms can move west.
   */
  @Test
  public void moveWest() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    lf.turn(4);
    assertTrue(env.addLifeForm(lf, 1, 1));
    assertEquals(1, env.getLifeForm(1, 1).getRow());
    assertEquals(1, env.getLifeForm(1, 1).getCol());
    env.selectCell(1,1);
    assertTrue(env.move());
    assertEquals(lf, env.getCell(1, 0).getLifeForm());
    env.clearBoard();
  }
  
  /**
   * Test lifeform at edges (0,0) (0,3) (3,3) (3,0)
   */
  @Test
  public void borderCase() {
    env.clearBoard();
    MockLifeForm lf = new MockLifeForm("LifeForm", 10);
    env.addLifeForm(lf, 0, 0);
    env.selectCell(0, 0);
    assertFalse(env.move());
    env.removeLifeForm(0, 0);
    lf.turn(2);
    env.addLifeForm(lf, 0, 3);
    env.selectCell(0, 3);
    assertFalse(env.move());
    env.removeLifeForm(0, 3);
    lf.turn(3);
    env.addLifeForm(lf, 3, 3);
    env.selectCell(3, 3);
    assertFalse(env.move());
    env.removeLifeForm(3, 3);
    lf.turn(4);
    env.addLifeForm(lf, 3, 0);
    env.selectCell(3, 0);
    assertFalse(env.move());
    env.removeLifeForm(3, 0);
  }
}
