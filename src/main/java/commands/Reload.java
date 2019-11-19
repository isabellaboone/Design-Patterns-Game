package commands;

import environment.Environment;

import javax.swing.JButton;

public class Reload extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().reload();
  }
}
