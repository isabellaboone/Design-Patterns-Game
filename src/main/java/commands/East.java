package commands;

import javax.swing.JButton;

public class East extends JButton implements Command {
  public void execute() {
    System.out.println("East");
    // Logic 
  }
}
