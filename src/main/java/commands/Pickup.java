package commands;

import javax.swing.JButton;

public class Pickup extends JButton implements Command {
  public void execute() {
    System.out.println("Pickup");
    // Logic 
  }
}
