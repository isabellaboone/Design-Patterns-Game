package environment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import lifeform.MockLifeForm;

import org.junit.Test;

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
    Environment e = new Environment(1,1);
    assertNull(e.getLifeForm(0, 0));
  }

  /**
   * Tests to see if we can add LifeForms to
   * Environments correctly.
   */
  @Test
  public void testAddLifeForm() {
    Environment e = new Environment(2,3);
    MockLifeForm lf = new MockLifeForm("Andrew", 19);
    assertTrue(e.addLifeForm(lf, 1, 2));
    assertTrue(e.getLifeForm(1, 2) == lf);
  }
  
  /**
   * Tests the border cases of the Environment.
   */
  @Test
  public void testBorderCases() {
    Environment e1 = new Environment(3,3);
    MockLifeForm lf1 = new MockLifeForm("Andrew", 19);
    assertTrue(e1.addLifeForm(lf1, 2, 2));
    assertTrue(e1.getLifeForm(2, 2) == lf1);
    
    Environment e2 = new Environment(3,3);
    MockLifeForm lf2 = new MockLifeForm("Andrew", 19);
    assertTrue(e2.addLifeForm(lf2, 0, 2));
    assertTrue(e2.getLifeForm(0, 2) == lf2);
    
    Environment e3 = new Environment(3,3);
    MockLifeForm lf3 = new MockLifeForm("Andrew", 19);
    assertTrue(e3.addLifeForm(lf3, 0, 0));
    assertTrue(e3.getLifeForm(0, 0) == lf3);
    
    Environment e4 = new Environment(3,3);
    MockLifeForm lf4 = new MockLifeForm("Andrew", 19);
    assertTrue(e4.addLifeForm(lf4, 2, 0));
    assertTrue(e4.getLifeForm(2, 0) == lf4);
  }
  
  /**
   * Tests to see if we can remove LifeForms
   * from the environment correctly.
   */
  @Test
  public void testRemoveLifeForm() {
    Environment e = new Environment(3,3);
    MockLifeForm lf = new MockLifeForm("Andrew", 19);
    assertTrue(e.addLifeForm(lf, 2, 2));
    assertTrue(e.getLifeForm(2, 2) == lf);
    e.removeLifeForm(2, 2);
    assertNull(e.getLifeForm(2, 2));
  }
  
  /**
   * Tests to see if the code can prevent
   * users from overwriting their Environment
   * without removing LifeForms.
   */
  @Test
  public void testOverwriteLifeForm() {
    Environment e = new Environment(3,3);
    MockLifeForm lf1 = new MockLifeForm("Andrew", 19);
    assertTrue(e.addLifeForm(lf1, 2, 2));
    assertTrue(e.getLifeForm(2, 2) == lf1);
    MockLifeForm lf2 = new MockLifeForm("Jun", 19);
    assertFalse(e.addLifeForm(lf2, 2, 2));
  }
  
}
