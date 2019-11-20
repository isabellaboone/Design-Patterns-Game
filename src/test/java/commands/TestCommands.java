package commands;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.*;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import lifeform.*;
import recovery.*;
import weapon.*;

public class TestCommands {

  @Test
  public void testAttack() throws AttachmentException, RecoveryRateException {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    r.setCommand(1, new East());
    r.setCommand(6, new Attack());
    RecoveryBehavior r1 = new RecoveryLinear(2);
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    LifeForm a = new Human("Human", 140, 10);
    LifeForm b = new Alien("Alien", 100, r1, 10);
    
    // Add Lifeforms to the board
    e.addLifeForm(a, 0, 0);
    e.addLifeForm(b, 0, 2);
    
    e.selectCell(0, 0);
    e.getSelectedCell().getLifeForm().pickUpWeapon(p1); // Pick up weapon
    
    r.buttonPressed(1); // Face east, the direction of b
    
    assertEquals(e.getLifeForm(0, 2), e.findTarget().getLifeForm()); 
    // Verifying that findTarget works
    
    int hp = e.findTarget().getLifeForm().getCurrentLifePoints();
    
    r.buttonPressed(6); // Attack 
    
    assertFalse(hp == e.findTarget().getLifeForm().getCurrentLifePoints());
    // The lifeform has taken damage after the attack button was pressed.
  }
  
  @Test
  public void testDrop() throws AttachmentException, RecoveryRateException {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    r.setCommand(5, new Drop());
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    LifeForm a = new Human("Human", 140, 10);
    
    // Add the lifeform
    e.addLifeForm(a, 0, 0);
    
    e.getSelectedCell().getLifeForm().pickUpWeapon(p1); // Give the weapon
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    // Lifeform has weapon
    
    r.buttonPressed(5); // Drop the weapon
    
    assertFalse(e.getSelectedCell().getLifeForm().hasWeapon());
    // Lifeform no longer has a weapon
    
  }

  @Test
  public void testMove() {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    r.setCommand(0, new North());
    r.setCommand(1, new East());
    r.setCommand(2, new South());
    r.setCommand(3, new West());
    r.setCommand(8, new Move());
    LifeForm a = new Human("Human", 140, 10);
    e.addLifeForm(a, 0, 0);
    
    r.buttonPressed(1);
    // Verify coordinates
    assertEquals(0, e.getSelectedCell().getLifeForm().getRow());
    assertEquals(0, e.getSelectedCell().getLifeForm().getCol());
    r.buttonPressed(8); // Move
    // Verify Coordinates
    assertEquals(0, e.getSelectedCell().getLifeForm().getRow());
    assertEquals(1, e.getSelectedCell().getLifeForm().getCol());
    r.buttonPressed(2); 
    r.buttonPressed(8);
    assertEquals(1, e.getSelectedCell().getLifeForm().getRow());
    assertEquals(1, e.getSelectedCell().getLifeForm().getCol());
  }

  @Test
  public void testNorth() {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    
    // Remote
    r.setCommand(0, new North());
    r.setCommand(1, new East());
    r.setCommand(2, new South());
    r.setCommand(3, new West());
    r.setCommand(4, new Reload());
    r.setCommand(5, new Drop());
    r.setCommand(6, new Attack());
    r.setCommand(7, new Pickup());
    r.setCommand(8, new Move());
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(3); // Press the West button
    assertEquals(4, e.getSelectedCell().getDirection());
    
    r.buttonPressed(0); // Press the West button
    assertEquals(1, e.getSelectedCell().getDirection());
  }

  @Test
  public void testPickup() throws AttachmentException {
    Environment e = Environment.getEnvironment(3, 3); 
    Remote r = new Remote(e); 
    r.setCommand(1, new East());
    r.setCommand(5, new Drop());
    r.setCommand(7, new Pickup());
    r.setCommand(8, new Move());
    
    LifeForm a = new Human("Human", 140, 10); 
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    
    e.selectCell(0, 0);
    e.addLifeForm(a, 0, 0);
    e.addWeapon(p1, 0, 1);
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    
    r.buttonPressed(5);
    
    assertFalse(e.getSelectedCell().getLifeForm().hasWeapon());
    
    r.buttonPressed(1);
    r.buttonPressed(8);
    r.buttonPressed(7);
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
  }

  @Test
  public void testSouth() {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    r.setCommand(0, new North());
    r.setCommand(1, new East());
    r.setCommand(2, new South());
    r.setCommand(3, new West());
    r.setCommand(4, new Reload());
    r.setCommand(5, new Drop());
    r.setCommand(6, new Attack());
    r.setCommand(7, new Pickup());
    r.setCommand(8, new Move());
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(2); // Press the south button
    
    assertEquals(3, e.getSelectedCell().getDirection());
  }

  @Test
  public void testWest() {
    Environment e = Environment.getEnvironment(3, 3);
    Remote r = new Remote(e);
    
    // Remote
    r.setCommand(0, new North());
    r.setCommand(1, new East());
    r.setCommand(2, new South());
    r.setCommand(3, new West());
    r.setCommand(4, new Reload());
    r.setCommand(5, new Drop());
    r.setCommand(6, new Attack());
    r.setCommand(7, new Pickup());
    r.setCommand(8, new Move());
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    r.buttonPressed(0);
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(3); // Press the West button
    
    assertEquals(4, e.getSelectedCell().getDirection());
  }
}
