package game;

import environment.Environment;

public class Runner {
  static Environment e;
  
  public static void main(String[] args) {
    start();
  }
  
  static void start() {
    e = e.getEnvironment(10, 10);
  }
}
