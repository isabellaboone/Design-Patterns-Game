package commands;

import environment.Environment;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Reload extends JButton implements Command {

  /**
   * Runs the commands.
   */
  public void execute(Environment env) {
    if (!env.getSelectedCell().getLifeForm().hasWeapon()) {
      // If the lifeform does not have a weapon
      System.out.println(env.getSelectedCell().getLifeForm().getName() + " does not have a weapon!");
    } else {
      // Otherwise, the lifeform does have a weapon, you can reload
      env.getSelectedCell().getLifeForm().reload();
    }
  }
}
