package commands;

import environment.Environment;

import javax.swing.JButton;

public class West extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(4);
  }
}
