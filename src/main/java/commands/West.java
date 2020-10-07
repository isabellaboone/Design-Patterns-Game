package commands;

import environment.Environment;

import javax.swing.JButton;

/**
 * Command the lifeform to face West.
 */
@SuppressWarnings("serial")
public class West extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().getLifeForm().turn(4);
  }
}
