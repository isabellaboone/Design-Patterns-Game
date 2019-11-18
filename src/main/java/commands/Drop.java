package commands;

import javax.swing.JButton;
import javax.swing.JMenuItem; 

public class Drop extends JButton implements Command {
  public void execute() {
    System.out.println("Drop");
    // Logic 
  }
}
