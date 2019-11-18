package commands;

import javax.swing.JButton;

public class Reload extends JButton implements Command {
  public void execute() {
    System.out.println("Reload");
    // Logic 
  }
}
