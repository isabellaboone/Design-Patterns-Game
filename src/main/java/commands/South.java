package commands;

import javax.swing.JButton;

public class South extends JButton implements Command {
  public void execute() {
    System.out.println("South");
    // Logic 
  }
}
