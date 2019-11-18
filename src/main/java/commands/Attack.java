package commands;

import javax.swing.JButton;

import environment.Environment;
import exceptions.WeaponException;

public class Attack extends JButton implements Command {
  public void execute(Environment env) {
    try {
      env.getSelectedCell().getLifeForm().attack(env.findTarget().getLifeForm(), (int)(env.getDistance(env.getSelectedCell().getLifeForm(), env.findTarget().getLifeForm())));
    } catch (WeaponException e1) {
      e1.printStackTrace();
    }
  }

}
