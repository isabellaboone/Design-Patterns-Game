package commands;

import environment.Environment;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Reload extends JButton implements Command {
  public void execute(Environment env) {
    if(!env.getSelectedCell().getLifeForm().hasWeapon()) {
      System.out.println(env.getSelectedCell().getLifeForm().getName() + " does not have a weapon!");
    } else {
      env.getSelectedCell().getLifeForm().reload();
    }
  }
}
