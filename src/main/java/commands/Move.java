package commands;

import environment.Environment;

import javax.swing.JButton;

public class Move extends JButton implements Command {
  public void execute(Environment env) {
    env.move();
  }
}
