package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class commandGui extends JFrame implements ActionListener {
  
  
  JButton North, South, East, West, Move, Reload, Attack, Drop, Pickup;
  
  public commandGui() {
    JFrame frame = new JFrame("Frame"); 
    JPanel turnButtons = new JPanel();
    JPanel commandButtons = new JPanel();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,200);
    frame.setLayout(new FlowLayout());
    turnButtons.setLayout(new BorderLayout()); 
    
    // Create button, add an action listener and add it
    North = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
    West = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
    South = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
    East = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    Move = new JButton(new ImageIcon(getClass().getResource("CommandButtons/move.png")));
    Reload = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Reload.png")));
    Attack = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Attack.png")));
    Drop = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Drop.png")));
    Pickup = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Pickup.png")));
    
    North.addActionListener(this);
    West.addActionListener(this);
    South.addActionListener(this);
    East.addActionListener(this);
    Move.addActionListener(this);
    Reload.addActionListener(this);
    Attack.addActionListener(this);
    Drop.addActionListener(this);
    Pickup.addActionListener(this);
    
    
    turnButtons.add("Center", Move);
    turnButtons.add("North", North);
    turnButtons.add("West", West); 
    turnButtons.add("South", South); 
    turnButtons.add("East", East); 
    commandButtons.add(Reload); 
    commandButtons.add(Attack);
    commandButtons.add(Drop);
    commandButtons.add(Pickup);
   
    
    frame.add(turnButtons);
    frame.add(commandButtons);
    pack(); 
    frame.setVisible(true); 
    
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
    } else if (e.getSource() == Move) {
      //
    }
  
  }
}
