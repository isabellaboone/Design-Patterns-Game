package commands;

import environment.Environment;

import javax.swing.JButton;

/**
 * Command to make the lifeform face south.  
 */
@SuppressWarnings("serial")
public class South extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(3);
  }
}
