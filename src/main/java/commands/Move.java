package commands;

import javax.swing.JButton;

public class Move extends JButton implements Command {
  public void execute() {
    System.out.println("Move");
    // Logic 
  }
}
