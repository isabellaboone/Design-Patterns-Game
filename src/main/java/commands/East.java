package commands;

import environment.Environment;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class East extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(2);
  }
}
