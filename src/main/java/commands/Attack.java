package commands;

import environment.Environment;

import exceptions.WeaponException;

import javax.swing.JButton;

public class Attack extends JButton implements Command {
  
  
  /**
   * selected lifeform attacks.
   */
  public void execute(Environment env) {
    try {
      env.getSelectedCell().getLifeForm().attack(env.findTarget().getLifeForm(), 
          (int)(env.getDistance(
              env.getSelectedCell().getLifeForm(), env.findTarget().getLifeForm())));
    } catch (WeaponException e1) {
      e1.printStackTrace();
    }
  }

}
