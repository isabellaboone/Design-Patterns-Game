package commands;

import environment.Cell;
import environment.Environment;

import javax.swing.JButton;

import weapon.Weapon;

/**
 * Command to make the lifeform pick up a weapon.
 */
@SuppressWarnings("serial")
public class Pickup extends JButton implements Command {
  public void execute(Environment env) {
    Cell cell = env.getSelectedCell(); // Readability

    if (cell.getWeaponsCount() == 0) {
      // If the cell has a weapon count of 0
      System.out.println("No weapons to pick up in this cell.");
      return; // Exit out of the method
    }
    
    if (cell.getLifeForm().hasWeapon()) {
      /* If the lifeform has a weapon, it will need to swap with
         what is on the ground of the cell. */

      if (cell.getWeapon1() != null) {
        // If weapon1 slot has a weapon (not null), perform a swap
        Weapon a = cell.getWeapon1();
        cell.removeWeapon(a);
        cell.addWeapon(cell.getLifeForm().dropWeapon());
        cell.getLifeForm().pickUpWeapon(a);

      } else if (cell.getWeapon2() != null) {
        // Otherwise, if the second slot is not null, perform that swap
        Weapon a = cell.getWeapon2();
        cell.removeWeapon(a);
        cell.addWeapon(cell.getLifeForm().dropWeapon());
        cell.getLifeForm().pickUpWeapon(a);
      }
    } else {
      // Else, the lifeform does have a weapon
      
      if (cell.getWeapon1() != null) {
        // If weapon1 slot has a weapon, pick it up and remove it from cell
        cell.getLifeForm().pickUpWeapon(cell.getWeapon1());
        cell.removeWeapon(cell.getWeapon1());

      } else if (cell.getWeapon2() != null) {
       // If weapon2 slot has a weapon, pick it up and remove it from cell
        cell.getLifeForm().pickUpWeapon(cell.getWeapon2());
        cell.removeWeapon(cell.getWeapon2());
      }
    }

  }
}
