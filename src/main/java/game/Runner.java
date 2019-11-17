package game;

import java.awt.Graphics;

import javax.swing.JFrame;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import gui.GUI;
import gui.commandGui;
import lifeform.*;
import recovery.*;
import weapon.*;

public class Runner extends JFrame{
  static Environment e;
  static GUI gui;
  public static void main(String[] args) throws RecoveryRateException, AttachmentException, WeaponException {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
  
  static void start() throws RecoveryRateException, AttachmentException, WeaponException {
    e = e.getEnvironment(10, 10);
    gui = new GUI(e);
    LifeForm c = new Human("Chase", 200, 20);
    LifeForm j = new Human("Joel-chan", 10000, 1000);
    LifeForm m = new Human("Morgan", 150, 30);
    LifeForm i = new Human("Isabella", 120, 45);
    LifeForm a = new Human("Andrew", 2, 0);
    RecoveryBehavior rl = new RecoveryLinear(2);
    Weapon pc = new PowerBooster(new PowerBooster(new PlasmaCannon()));
    Weapon cg = new PowerBooster(new PowerBooster(new ChainGun()));
    LifeForm jun = new Alien("America's Sweetheart: Jun", 10000, rl, 2);
    LifeForm kim = new Alien("Rat King: Kim", 3000, rl, 10);
    // dummies to test firing
    LifeForm d1 = new Human("Dummy 1", 1000, 0);
    LifeForm d2 = new Human("Dummy 2", 1000, 0);
    e.addLifeForm(d1, 9, 9);
    e.addLifeForm(d2, 9, 8);
    
    //
    
    
    jun.pickUpWeapon(pc);
    m.pickUpWeapon(cg);
    kim.turn(4);
    e.addLifeForm(c, 0, 0);
    e.addLifeForm(j, 2, 2);
    e.addLifeForm(m, 6, 8);
    e.addLifeForm(i, 3, 5);
    e.addLifeForm(a, 8, 3);
    e.addLifeForm(jun, 6, 2);
    e.addLifeForm(kim, 3, 1);
 

    gui.redrawBoard();
    commandGui commands = new commandGui(e, gui); 
    
  }
}
