package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class commandGui extends JFrame implements ActionListener {
  String UNSELECTED_NORTH = "/CommandButtons/unselected_north.png",
         UNSELECTED_WEST = "/CommandButtons/unselected_west.png",
         UNSELECTED_SOUTH = "/CommandButtons/unselected_north.png",
         UNSELECTED_EAST = "/CommandButtons/unselected_north.png",
         SELECTED_NORTH = "/CommandButtons/unselected_north.png",
         SELECTED_WEST = "/CommandButtons/unselected_north.png",
         SELECTED_SOUTH = "png",
         SELECTED_EAST = "C:\\Users\\Isabella\\Documents\\Eclipse Workspace\\SampleGui\\PNG files for project\\selected_east.png";
  
  JButton North, South, East, West; 
  
  public commandGui() {
    JFrame frame = new JFrame("Frame"); 
    JPanel turnButtons = new JPanel(); 
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //setLayout(new BorderLayout()); 
    
    // Create button, add an action listener and add it
    North = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
    West = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
    South = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
    East = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    
    North.addActionListener(this);
    West.addActionListener(this);
    South.addActionListener(this);
    East.addActionListener(this);
    
    add("North", North);
    add("West", West); 
    add("South", South); 
    add("East", East); 
    
    pack(); 
    setVisible(true); 
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == North) {
      North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_north.png")));
      West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
      South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
      East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    } else if (e.getSource() == West) {
      North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
      West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_west.png")));
      South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
      East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    } else if (e.getSource() == South) {
        North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
        West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
        South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_south.png")));
        East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    } else if (e.getSource() == East) {
      North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
      West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
      South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
      East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_east.png")));
    }
  
  }
}
