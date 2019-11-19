package commands;

import environment.Environment;

import exceptions.WeaponException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

import javax.swing.JButton;

public class Attack extends JButton implements Command {

  /**
   * selected lifeform attacks.
   */
  public void execute(Environment env) {
    LifeForm player = env.getSelectedCell().getLifeForm(), victim = env.findTarget().getLifeForm();
    try {
      if (victim instanceof Human) {
        System.out.println("I can't attack another human!");
      } else if (victim instanceof Alien) {
        int distance = (int) (env.getDistance(player, victim));
        player.attack(victim, distance);
      }
    } catch (WeaponException e1) {
      e1.printStackTrace();
    }

  }

}
