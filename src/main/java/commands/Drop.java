package commands;

import environment.Environment;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Drop extends JButton implements Command {
  /**
   * drop a held weapon in the selected cell.
   */
  public void execute(Environment env) {
    if ((env.getSelectedCell().getWeaponsCount() < 2) 
        && (env.getSelectedCell().getLifeForm().hasWeapon())) {
      // If the weapon count in the cell is less than 2 and the lifeform has a weapon
      env.getSelectedCell().addWeapon(env.getSelectedCell().getLifeForm().dropWeapon());
    } else if (!env.getSelectedCell().getLifeForm().hasWeapon()) {
      // Else if the selected lifeform does not have a weapon
      System.out.println("No weapon to drop.");
    } else {
      // Otherwise, the cell should be full
      System.out.println("Cell is full! The weapon cannot be dropped."
            + " Move to another cell and try again.");
    }
  }
}
