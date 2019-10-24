package environment;

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

  /**
   * Tests to see if we can initialize Environments
   * correctly.
   */
  @Test
  public void testInitialization() {
    Environment env = Environment.getEnvironment(1, 1);
    assertNull(env.getLifeForm(0, 0));
  }

  /**
   * Tests to see if we can add LifeForms to
   * Environments correctly.
   */
  @Test
  public void testAddLifeForm() {
    Environment env = Environment.getEnvironment(2, 3);
    MockLifeForm lf = new MockLifeForm("lf", 10);
  }
  
  /**
   * Tests the border cases of the Environment.
   */
  @Test
  public void testBorderCases() {
    Environment env = Environment.getEnvironment(3, 3);
  }
  
  /**
   * Tests to see if we can remove LifeForms
   * from the environment correctly.
   */
  @Test
  public void testRemoveLifeForm() {
    Environment env = Environment.getEnvironment(3, 3);
  }
  
  /**
   * Tests to see if the code can prevent
   * users from overwriting their Environment
   * without removing LifeForms.
   */
  @Test
  public void testOverwriteLifeForm() {
    Environment env = Environment.getEnvironment(3, 3);
  }
  
}
