package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.*;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import lifeform.*;
import recovery.*;
import weapon.*;

public class TestCommands {
  private static Environment e;
  private Remote r; 
  
  @Before
  public synchronized void createEnvironment() {
    e = Environment.getEnvironment(4, 4);
    r = new Remote(e); 
    r.setCommand(0, new North());
    r.setCommand(1, new East());
    r.setCommand(2, new South());
    r.setCommand(3, new West());
    r.setCommand(4, new Reload());
    r.setCommand(5, new Drop());
    r.setCommand(6, new Attack());
    r.setCommand(7, new Pickup());
    r.setCommand(8, new Move());
  }
  
  @Test
  public void testMove() {
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
    e.clearBoard();
  }
  
  public void testReload() {
    LifeForm a = new Human("Human", 140, 10);
    e.addLifeForm(a, 0, 0);
    assertEquals(e.getSelectedCell().getLifeForm().getWeapon().getCurrentAmmo(), 
        e.getSelectedCell().getLifeForm().getWeapon().getMaxAmmo());
    r.buttonPressed(6);
    assertEquals(e.getSelectedCell().getLifeForm().getWeapon().getCurrentAmmo() - 1, 
        e.getSelectedCell().getLifeForm().getWeapon().getMaxAmmo() - 1);
    
  }
  
  @Test
  public void testNorth() {
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(3); // Press the South button
    assertEquals(4, e.getSelectedCell().getDirection());
    
    r.buttonPressed(0); // Press the North button
    assertEquals(1, e.getSelectedCell().getDirection());
    e.clearBoard();
  }
  
  @Test
  public void testEast() {
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(3); // Press the West button
    assertEquals(4, e.getSelectedCell().getDirection());
    
    r.buttonPressed(1); // Press the East button
    assertEquals(2, e.getSelectedCell().getDirection());
  }
  
  @Test
  public void testSouth() {
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(2); // Press the East button
    
    assertEquals(3, e.getSelectedCell().getDirection());
    e.clearBoard();
  }
  
  @Test
  public void testWest() {
    
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    r.buttonPressed(0);
    assertEquals(1, e.getSelectedCell().getDirection());
    
    r.buttonPressed(3); // Press the West button
    
    assertEquals(4, e.getSelectedCell().getDirection());
    e.clearBoard();
  }
  
  @Test
  public void testDropWithSpace() throws AttachmentException, RecoveryRateException {
    LifeForm a = new Human("Human", 140, 10); 
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    e.selectCell(0, 0); 
    e.addLifeForm(a, 0, 0);
    
    e.getSelectedCell().getLifeForm().pickUpWeapon(p1); // Pick up weapon 
        
    assertEquals(0, e.getSelectedCell().getWeaponsCount());     
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    
    r.buttonPressed(5);
    
    assertEquals(1, e.getSelectedCell().getWeaponsCount());     
    assertFalse(e.getSelectedCell().getLifeForm().hasWeapon());
        
    e.clearBoard();
  }
  
  @Test
  public void testDropWithoutSpace() throws AttachmentException, RecoveryRateException {
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    Weapon p2 = new PowerBooster(new PowerBooster(new ChainGun()));
    Weapon p3 = new Scope(new Scope(new Pistol()));
    LifeForm a = new Human("Human", 140, 10);
    
    e.addLifeForm(a, 0, 0);
    
    // Add 2 weapons to cell and make it full
    e.addWeapon(p1, 1, 1);
    e.addWeapon(p2, 1, 1);
    
    // Give the lifeform a weapon
    e.getSelectedCell().getLifeForm().pickUpWeapon(p3);
    
    // Move to 1, 1
    r.buttonPressed(1); // east
    r.buttonPressed(8); // move
    r.buttonPressed(2); // south
    r.buttonPressed(8); // move
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    assertEquals(2, e.getCell(1, 1).getWeaponsCount());
    
    r.buttonPressed(5); // drop
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    assertEquals(2, e.getSelectedCell().getWeaponsCount());
    
    e.clearBoard();
  }

  @Test
  public void testPickup() throws AttachmentException {
    // With available slots
    LifeForm a = new Human("Human", 140, 10); 
    Weapon p1 = new Scope(new PowerBooster(new Pistol()));
    
    e.selectCell(0, 0);
    e.addLifeForm(a, 0, 0);
    e.addWeapon(p1, 0, 1);
    
    assertFalse(e.getSelectedCell().getLifeForm().hasWeapon());
    
    r.buttonPressed(1);
    r.buttonPressed(8);
    r.buttonPressed(7);
    
    assertTrue(e.getSelectedCell().getLifeForm().hasWeapon());
    
    Weapon p2 = new PowerBooster(new PowerBooster(new Pistol()));
    Weapon p3 = new Scope(new Scope(new Pistol())); 
    
    e.addWeapon(p2, 0, 1);
    e.addWeapon(p3, 0, 1);
    assertEquals(2, e.getCell(0, 1).getWeaponsCount());
    
    r.buttonPressed(3); // west
    r.buttonPressed(8); // move
    r.buttonPressed(7); // pickup
    
    Weapon w1 = e.getCell(0, 1).getWeapon1(), 
        w2 = e.getCell(0, 1).getWeapon2(),
        w3 = e.getSelectedCell().getLifeForm().getWeapon();
    
    // Ensure the swap works correctly 
    assertEquals(p2, w1);
    assertEquals(p1, w3);
    assertEquals(p3, w2); 
    
    e.clearBoard();
  }
}