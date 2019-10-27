package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.MockLifeForm;

/**
 * The JUnit 4 test file for Environment.class
 * @author andrewjanuszko
 *
 */
public class TestEnvironment {

  private Environment env = Environment.getEnvironment(3, 3);

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
        System.out.println("i: " + i + "  j: " + j);
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
  }
  
  /**
   * Tests to see if the code can prevent
   * users from overwriting their Environment
   * without removing LifeForms.
   */
  @Test
  public void testOverwriteLifeForm() {
  }
  
}
