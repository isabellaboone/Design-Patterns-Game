package commands;

import environment.Environment;

import javax.swing.JButton;

/**
 * Command to make the lifeform move.  
 */
@SuppressWarnings("serial")
public class Move extends JButton implements Command {
  public void execute(Environment env) {
    env.move();
  }
}
