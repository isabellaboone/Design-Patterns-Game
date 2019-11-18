package commands;

import javax.swing.JButton;

import environment.Environment;

public class Reload extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().reload();
  }
}
