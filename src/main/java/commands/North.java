package commands;

import javax.swing.JButton;

import environment.Environment;

public class North extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(1);
  }
}
