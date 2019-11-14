package game;

import environment.Environment;
import gui.GUI;
import gui.commandGui;

public class Runner {
  static Environment e;

  public static void main(String[] args) {
    start();
  }

  static void start() {
    e = e.getEnvironment(10, 10);
    GUI gui = new GUI(e);
    commandGui commands = new commandGui(); 
  }
}
