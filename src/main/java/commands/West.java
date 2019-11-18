package commands;

import javax.swing.JButton;

public class West extends JButton implements Command {
  public void execute() {
    System.out.println("West");
    // Logic 
  }
}
