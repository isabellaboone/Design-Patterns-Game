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
      int before = victim.getCurrentLifePoints();
      if (((victim instanceof Human) && (player instanceof Human))
          || ((victim instanceof Alien) && (player instanceof Alien))) {
        System.out.println("I can't attack another human!");
      } else if (((victim instanceof Alien) && (player instanceof Human))
          || ((victim instanceof Human) && (player instanceof Alien))) {
        int distance = (int) (env.getDistance(player, victim));
        // This is an admittedly cheaty way to calculate the damage done, buuuuuuut
        player.attack(victim, distance);

        int after = victim.getCurrentLifePoints();
        System.out.println("'" + player.getName() + "' hit '" + victim.getName() + "' for " + (before - after) + " damage!");
      }
    } catch (WeaponException e1) {
      e1.printStackTrace();
    }

  }

}
