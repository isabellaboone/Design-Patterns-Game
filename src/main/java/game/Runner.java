package game;

import java.awt.Graphics;

import javax.swing.JFrame;

import environment.Environment;
import gui.GUI;
import gui.commandGui;

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
    commandGui commands = new commandGui(); 
    
  }
}
