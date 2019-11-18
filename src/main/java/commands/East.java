package commands;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import environment.Environment;

public class East extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(2);
  }
}
