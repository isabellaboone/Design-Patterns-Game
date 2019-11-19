package commands;

import environment.Environment;

import javax.swing.JButton;

public class Drop extends JButton implements Command {
  /**
   * drop a held weapon in the selected cell.
   */
  public void execute(Environment env) {
    if ((env.getSelectedCell().getWeaponsCount() < 2)
        && (env.getSelectedCell().getLifeForm().hasWeapon())) {
      env.getSelectedCell().addWeapon(env.getSelectedCell().getLifeForm().dropWeapon());
    } else if (!env.getSelectedCell().getLifeForm().hasWeapon()) {
      System.out.println("No weapon to drop.");
    } else {
      System.out.println("Cell is full! The weapon cannot be dropped. Move to another cell"
          + " and try again.");
    } 
  }
}
