package commands;

import environment.Environment;

import exceptions.WeaponException;

import javax.swing.JButton;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;


@SuppressWarnings("serial")
public class Attack extends JButton implements Command {

  /**
   * selected lifeform attacks.
   */
  public void execute(Environment env) {

    LifeForm player = env.getSelectedCell().getLifeForm();
    try {
      if (env.findTarget() == null || env.findTarget().getLifeForm() == null) {
        System.out.println("There are no enemies to attack.");
      } else {
        LifeForm victim = env.findTarget().getLifeForm();
        int before = victim.getCurrentLifePoints();
        if (((victim instanceof Human) && (player instanceof Human))
            || ((victim instanceof Alien) && (player instanceof Alien))) {
          System.out.println("LifeForm cannot attack an ally.");
        } else if (((victim instanceof Alien) && (player instanceof Human))
            || ((victim instanceof Human) && (player instanceof Alien))) {
          int distance = (int) (env.getDistance(player, victim));
          // This is an admittedly cheaty way to calculate the damage done, buuuuuuut
          player.attack(victim, distance);

          int after = victim.getCurrentLifePoints();
          if (player.hasWeapon()) {
            System.out.println(
                "'" + player.getName()
                + "' shot '" + victim.getName()
                + "' with a '" + player.getWeapon().toString()
                + "' for "
                + (before - after)
                + " damage!");
          } else {
            System.out.println(
                "'" + player.getName()
                + "' hit '"
                + victim.getName()
                + "' for "
                + (before - after) 
                + " damage!");
          }
        }
      }
      
    } catch (WeaponException e1) {
      e1.printStackTrace();
    }

  }

}
