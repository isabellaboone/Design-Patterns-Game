package commands;

import javax.swing.JButton;

public class North extends JButton implements Command {
  public void execute() {
    System.out.println("North");
    // Logic 
  }
}
