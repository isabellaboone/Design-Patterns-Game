package game;

import commands.Attack;
import commands.Command;
import commands.Drop;
import commands.East;
import commands.Move;
import commands.North;
import commands.Pickup;
import commands.Reload;
import commands.Remote;
import commands.South;
import commands.West;
import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import gui.CommandGui;
import gui.Gui;

import java.awt.Graphics;

import javax.swing.JFrame;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Scope;
import weapon.Stabilizer;
import weapon.Weapon;



@SuppressWarnings("serial")
public class Runner extends JFrame {
  static Environment e;
  static Gui gui;
  static Remote r; 

  public static void main(String[] args) 
      throws RecoveryRateException, AttachmentException, WeaponException {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
 
  static void start() throws RecoveryRateException, AttachmentException, WeaponException { 
    final int maximum = 10;
    final int minimum = 0;
    final int range = (maximum - minimum);
    e = Environment.getEnvironment(maximum, maximum);
    gui = new Gui(e);
    r = new Remote(e);
    makeRemote(r); 
    
    // Generate the lifeforms on the board.
    
    for (int i = 0; i < 10; ++i) {
      int recoveryRate = Double.valueOf((Math.random() * 5) + 1).intValue();
      final RecoveryBehavior[] behaviors = { new RecoveryNone(), 
          new RecoveryLinear(recoveryRate), new RecoveryFractional(recoveryRate / 100.00) };
      int row = Double.valueOf((Math.random() * range) + minimum).intValue();
      int column = Double.valueOf((Math.random() * range) + minimum).intValue();
      int health = Double.valueOf((Math.random() * 100) + 50).intValue();
      int behavior = Double.valueOf((Math.random() * 3) + 0).intValue();
      Alien alien = new Alien("Alien #" + (i + 1), health, behaviors[behavior], recoveryRate);
      if (!e.getCell(row, column).hasLifeForm()) {
        e.addLifeForm(alien, row, column);
        continue;
      } else {
        --i;
      }
    }
    
    for (int i = 0; i < 10; ++i) {
      int row = Double.valueOf((Math.random() * range) + minimum).intValue();
      int column = Double.valueOf((Math.random() * range) + minimum).intValue();
      int health = Double.valueOf((Math.random() * 100) + 50).intValue();
      int armor = Double.valueOf((Math.random() * 10) + 0).intValue();
      Human human = new Human("Human #" + (i + 1), health, armor);
      if (!e.getCell(row, column).hasLifeForm()) {
        e.addLifeForm(human, row, column);
      } else {
        --i;
      }
    }
    
    for (int i = 0; i < 10; ++i) {
      final int row = Double.valueOf((Math.random() * range) + minimum).intValue();
      final int column = Double.valueOf((Math.random() * range) + minimum).intValue();
      Weapon[] base = { new Pistol(), new ChainGun(), new PlasmaCannon() };
      final int index = Double.valueOf((Math.random() * 3) + 0).intValue();
      Weapon weapon = base[index];
      final int test1 = Double.valueOf((Math.random() * 2) + 0).intValue();
      if (test1 == 1) {
        Weapon[] baseOne = { new Scope(weapon), new PowerBooster(weapon), new Stabilizer(weapon) };
        final int attachmentIndex = Double.valueOf((Math.random() * 3) + 0).intValue();
        weapon = baseOne[attachmentIndex];
        final int test2 = Double.valueOf((Math.random() * 2) + 0).intValue();
        if (test2 == 1) {
          Weapon[] baseTwo = { new Scope(weapon), 
              new PowerBooster(weapon), new Stabilizer(weapon) };
          final int secondAttachmentIndex = Double.valueOf((Math.random() * 3) + 0).intValue();
          weapon = baseTwo[secondAttachmentIndex];
          if (e.getCell(row, column).getWeaponsCount() < 2 && !e.getCell(row, column).hasLifeForm()) {
            e.addWeapon(weapon, row, column);
          } else {
            --i;
          }
        } else {
          if (e.getCell(row, column).getWeaponsCount() < 2 && !e.getCell(row, column).hasLifeForm()) {
            e.addWeapon(weapon, row, column);
          } else {
            --i;
          }
        }
      } else {
        if (e.getCell(row, column).getWeaponsCount() < 2 && !e.getCell(row, column).hasLifeForm()) {
          e.addWeapon(weapon, row, column);
        } else {
          --i;
        }
      }
    }
  //****************************************************************
    
    
    
    
    gui.redrawBoard();
    
    CommandGui commands = new CommandGui(e, gui, r); 
    
  }
  
  /**
   * Make a remote. Put this in a method because its
   * an ugly block of code. We don't have to see it 
   * down here. shhhh. 
   * @param r - remote to build
   */
  public static void makeRemote(Remote r) {
    Command north = new North();
    Command east = new East();
    Command south = new South();
    Command west = new West();
    Command reload = new Reload();
    Command drop = new Drop();
    Command attack = new Attack();
    Command pickup = new Pickup();
    Command move = new Move();
    r.setCommand(0, north);
    r.setCommand(1, east);
    r.setCommand(2, south);
    r.setCommand(3, west);
    r.setCommand(4, reload);
    r.setCommand(5, drop);
    r.setCommand(6, attack);
    r.setCommand(7, pickup);
    r.setCommand(8, move);
  }
}
