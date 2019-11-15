package game;

import java.awt.Graphics;

import javax.swing.JFrame;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import gui.GUI;
import gui.commandGui;
import lifeform.*;
import recovery.*;
import weapon.*;

public class Runner extends JFrame{
  static Environment e;
  static GUI gui;
  public static void main(String[] args) throws RecoveryRateException, AttachmentException {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
  
  static void start() throws RecoveryRateException, AttachmentException {
    e = e.getEnvironment(10, 10);
    gui = new GUI(e);
    LifeForm c = new Human("Chase", 200, 20);
    LifeForm j = new Human("Joel-chan", 10000, 1000);
    LifeForm m = new Human("Morgan", 150, 30);
    LifeForm i = new Human("Isabella", 120, 45);
    LifeForm a = new Human("Andrew", 2, 0);
    RecoveryBehavior rl = new RecoveryLinear(2);
    Weapon pc = new PowerBooster(new PowerBooster(new PlasmaCannon()));
    
    LifeForm jun = new Alien("America's Sweetheart: Jun", 10000, rl, 2);
    LifeForm kim = new Alien("Rat King: Kim", 3000, rl, 10);
    kim.pickUpWeapon(pc);
    e.addLifeForm(c, 1, 1);
    e.addLifeForm(j, 2, 2);
    e.addLifeForm(m, 6, 9);
    e.addLifeForm(i, 3, 5);
    e.addLifeForm(a, 8, 3);
    e.addLifeForm(jun, 5, 2);
    e.addLifeForm(kim, 3, 1);
    
    gui.redrawBoard();
    commandGui commands = new commandGui(); 
    
  }
}
