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
import recovery.RecoveryLinear;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Scope;
import weapon.Weapon;



@SuppressWarnings("serial")
public class Runner extends JFrame {
  static Environment e;
  static Gui gui;

  public static void main(String[] args) 
      throws RecoveryRateException, AttachmentException, WeaponException {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
  
  static void start() throws RecoveryRateException, AttachmentException, WeaponException { 
    e = Environment.getEnvironment(10, 10);
    gui = new Gui(e);
    //**********************The Remote******************************************
    Remote r = new Remote(e);
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
    
    //****************************************************************
    LifeForm tuner = new Human("Tuner", 1000, 0);
    e.addLifeForm(tuner, 1, 1);
    
    LifeForm picker = new Human("Pick and Drop", 1000, 0);
    e.addLifeForm(picker, 2, 2);
    Weapon w1 = new Pistol();
    e.addWeapon(w1, 2, 3);
    Weapon w2 = new ChainGun();
    e.addWeapon(w2, 2, 4);
    Weapon w3 = new PlasmaCannon();
    e.addWeapon(w3, 2, 5);
    Weapon w4 = new Pistol();
    e.addWeapon(w4, 2, 5);
    
    LifeForm fighter = new Human("Fighter", 1000, 0);
    e.addLifeForm(fighter, 3, 6);
    Weapon gun = new Pistol();
    fighter.pickUpWeapon(gun);
    LifeForm target1 = new Alien("Target 1", 1000);
    e.addLifeForm(target1, 3, 8);
    LifeForm target2 = new Alien("Target 2", 1000);
    e.addLifeForm(target2, 6, 6);
    
    LifeForm mover = new Human("Mover", 1000, 0);
    e.addLifeForm(mover, 9, 9);
    
    Alien wall = new Alien("Wall", 1000);
    e.addLifeForm(wall, 9, 7);
    
    
    
    
    gui.redrawBoard();
    
    CommandGui commands = new CommandGui(e, gui, r); 
    
  }
}
