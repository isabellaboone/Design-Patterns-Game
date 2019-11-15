package game;

import java.awt.Graphics;

import javax.swing.JFrame;

import environment.Environment;
import gui.GUI;
import gui.commandGui;
import lifeform.*;

public class Runner extends JFrame{
  static Environment e;
  static GUI gui;
  public static void main(String[] args) {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
  
  static void start() {
    e = e.getEnvironment(10, 10);
    gui = new GUI(e);
    LifeForm c = new Human("Chase", 200, 20);
    LifeForm j = new Human("Joel-chan", 10000, 1000);
    LifeForm m = new Human("Morgan", 150, 30);
    LifeForm i = new Human("Isabella", 120, 45);
    LifeForm a = new Human("Andrew", 2, 0);
    e.addLifeForm(c, 1, 1);
    e.addLifeForm(j, 2, 2);
    e.addLifeForm(m, 6, 9);
    e.addLifeForm(i, 3, 5);
    e.addLifeForm(a, 8, 3);
    commandGui commands = new commandGui(); 
    
  }
}
