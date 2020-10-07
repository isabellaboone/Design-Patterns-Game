package commands;

import environment.Environment;

import javax.swing.JButton;

/**
 * Command to make the lifeform face the North direction. 
 */
@SuppressWarnings("serial")
public class North extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(1);
  }
}
