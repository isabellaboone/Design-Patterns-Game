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
   * Attack command - Makes the selected cell attack an enemy in the direction it
   * is facing.
   */
  public void execute(Environment env) {
    LifeForm player = env.getSelectedCell().getLifeForm();
    // Store player (selected cell) in a variable for readability.
    try {
      if (env.findTarget() == null || env.findTarget().getLifeForm() == null) {
        // If find target could not find a target it will be marked as null
        if(player.hasWeapon()) {
          System.out.println(player.getName() + " shot at nothing.");
          player.fire(0);
        } else {
          System.out.println(player.getName() + " swung at nothing.");
        }
      } else {
        // If the target is not null
        LifeForm victim = env.findTarget().getLifeForm();
        // Store victim (find target) in a variable for readability.
        int before = victim.getCurrentLifePoints();
        // Store the victims health before the hit to calculate the damage
        if (((victim instanceof Human) && (player instanceof Human))
            || ((victim instanceof Alien) && (player instanceof Alien))) {
          // If the player and victim are of the same subclass, this cannot happen
          System.out.println("LifeForm cannot attack an ally.");
        } else if (((victim instanceof Alien) && (player instanceof Human))
            || ((victim instanceof Human) && (player instanceof Alien))) {
          // Redundant else if that ensures a human and alien can only attack eachother
          int distance = (int) (env.getDistance(player, victim));
          // Distance between lifeforms, done for readability

          player.attack(victim, distance);

          int after = victim.getCurrentLifePoints();
          // Victims health after hit

          // Print statements
          if (player.hasWeapon()) {
            System.out.println(player.getName() + " shot " + victim.getName() + " with a "
                + player.getWeapon().toString() + " for " + (before - after) + " damage!");
          } else {
            System.out.println(player.getName() + " hit " + victim.getName() 
                + " for " + (before - after) + " damage!");
          }
        }
      }

    } catch (WeaponException e1) {
      e1.printStackTrace();
    }

  }

}
