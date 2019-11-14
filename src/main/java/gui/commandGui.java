package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class commandGui {
  String UNSELECTED_NORTH = "/CommandButtons/unselected_north.png",
         UNSELECTED_WEST = "/CommandButtons/unselected_west.png",
         UNSELECTED_SOUTH = "/CommandButtons/unselected_north.png",
         UNSELECTED_EAST = "/CommandButtons/unselected_north.png",
         SELECTED_NORTH = "/CommandButtons/unselected_north.png",
         SELECTED_WEST = "/CommandButtons/unselected_north.png",
         SELECTED_SOUTH = "png",
         SELECTED_EAST = "C:\\Users\\Isabella\\Documents\\Eclipse Workspace\\SampleGui\\PNG files for project\\selected_east.png";
  
  JLabel textLabel; 
  JButton North, South, East, West; 
  ImageIcon icon; 
  
  public commandGui() {
    JFrame frame = new JFrame("Frame"); 
    JPanel turnButtons = new JPanel(new ##LAYOUT##); 
    
    JButton North = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
    JButton West =  new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
    JButton South = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
    JButton East =  new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    
    
    
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
}
