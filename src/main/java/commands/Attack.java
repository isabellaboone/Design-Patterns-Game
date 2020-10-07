package commands;

import environment.Environment;

import exceptions.WeaponException;

import javax.swing.JButton;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

/**
 * Attack command - makes the selected cell attack an enemy in the direction it is facing.
 *
 */
@SuppressWarnings("serial")
public class Attack extends JButton implements Command {
  public void execute(Environment env) {
    
    LifeForm player = env.getSelectedCell().getLifeForm();

    try {
      if (env.findTarget() == null || env.findTarget().getLifeForm() == null) {
        // If find target fails, the player will shoot at nothing
        if(player.hasWeapon()) {
          System.out.println(player.getName() + " shot at nothing.");
          player.fire(0);
        } else {
          System.out.println(player.getName() + " swung at nothing.");
        }
      } else {
        // Otherwise, if a target was found 
        LifeForm victim = env.findTarget().getLifeForm();
        
        int before = victim.getCurrentLifePoints(), // Store victim's health before hit 
            distance = (int) (env.getDistance(player, victim)); // Distance between lifeforms
        
        if (((victim instanceof Human) && (player instanceof Human))
            || ((victim instanceof Alien) && (player instanceof Alien))) {
          // If the player and victim are of the same subclass, (friendly fire)
          System.out.println("LifeForm cannot attack an ally.");
        } else if (((victim instanceof Alien) && (player instanceof Human))
            || ((victim instanceof Human) && (player instanceof Alien))) {
          // Redundant else if that ensures a human and alien can only attack each other

          player.attack(victim, distance);

          int after = victim.getCurrentLifePoints(); // Victims health after hit 
          
          // Print the event
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
