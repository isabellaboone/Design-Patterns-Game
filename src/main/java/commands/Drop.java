package commands;

import javax.swing.JButton;

import environment.Environment;

public class Drop extends JButton implements Command {
  public void execute(Environment env) {
    env.getSelectedCell().addWeapon(env.getSelectedCell().getLifeForm().dropWeapon());
    System.out.println("Drop");
  }
}
