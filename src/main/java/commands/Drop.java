package commands;

import javax.swing.JButton;

import environment.Environment;

public class Drop extends JButton implements Command {
  public void execute(Environment env) {
    if(env.getSelectedCell().getWeaponsCount() < 2) {
      env.getSelectedCell().addWeapon(env.getSelectedCell().getLifeForm().dropWeapon());
    } else {
      System.out.println("Cell is full! The weapon cannot be dropped. Move to another cell and try again.");
    }
  }
}
