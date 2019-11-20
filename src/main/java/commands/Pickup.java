package commands;

import environment.Environment;

import javax.swing.JButton;

import weapon.Weapon;

public class Pickup extends JButton implements Command {
  /**
   * pick up a weapon in the selected cell or swap it.
   */
  public void execute(Environment env) {
    if (env.getSelectedCell().getWeaponsCount() == 0) {
      // If the cell has a weapon count of 0
      System.out.println("No weapons to pick up in this cell.");
      return;
    }
    if (env.getSelectedCell().getLifeForm().hasWeapon()) {
      // If the selected lifeform has a weapon, swap it with 
      // what is on the ground. 
      
      if (env.getSelectedCell().getWeapon1() != null) {
        // If weapon1 slot has a weapon (not null), perform a swap 
        Weapon a = env.getSelectedCell().getWeapon1(); 
        Weapon b = env.getSelectedCell().getLifeForm().getWeapon();
        env.getSelectedCell().removeWeapon(a);
        env.getSelectedCell().addWeapon(b);
        env.getSelectedCell().getLifeForm().dropWeapon();
        env.getSelectedCell().getLifeForm().pickUpWeapon(a);
        
      } else if (env.getSelectedCell().getWeapon2() != null) {
        // Otherwise, if the second slot is not null, perform that swap
        Weapon a = env.getSelectedCell().getWeapon2();
        Weapon b = env.getSelectedCell().getLifeForm().getWeapon();
        env.getSelectedCell().removeWeapon(a);
        env.getSelectedCell().addWeapon(b);
        env.getSelectedCell().getLifeForm().dropWeapon();
        env.getSelectedCell().getLifeForm().pickUpWeapon(a);      }
    }
    
    // If the lifeform does not have a weapon
    if (env.getSelectedCell().getWeapon1() != null 
        && !env.getSelectedCell().getLifeForm().hasWeapon()) { 
      // check if cell has a weapon1 and lifeform has no weapon 
      env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon1());
      env.getSelectedCell().removeWeapon(env.getSelectedCell().getWeapon1());
    } else if (env.getSelectedCell().getWeapon2() != null 
        && !env.getSelectedCell().getLifeForm().hasWeapon()) {
      // check if cell has a weapon2 and lifeform has no weapon 
      env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon2());
      env.getSelectedCell().removeWeapon(env.getSelectedCell().getWeapon2());
    }
    
  }
}
