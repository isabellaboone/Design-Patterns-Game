package commands;

import javax.swing.JButton;

import environment.Environment;

public class Pickup extends JButton implements Command {
  public void execute(Environment env) {
    if (env.getSelectedCell().getWeapon1() != null && !env.getSelectedCell().getLifeForm().hasWeapon()) { 
      /* check if cell has a weapon1 and lifeform has no weapon */
      env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon1());
      env.getSelectedCell().removeWeapon( env.getSelectedCell().getWeapon1());
    } else if (env.getSelectedCell().getWeapon2() != null && !env.getSelectedCell().getLifeForm().hasWeapon()) {
      /* check if cell has a weapon2 and lifeform has no weapon */
      env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon2());
      env.getSelectedCell().removeWeapon( env.getSelectedCell().getWeapon2());
    }
    
  }
}
