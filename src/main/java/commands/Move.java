package commands;

import javax.swing.JButton;

import environment.Environment;

public class Move extends JButton implements Command {
  public void execute(Environment env) {
    env.move();
  }
}
