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

import commands.*;
import environment.Environment;
import exceptions.WeaponException;

public class commandGui extends JFrame implements ActionListener {
  
  
  JButton North, South, East, West, Move, Reload, Attack, Drop, Pickup;
  Environment env;
  GUI g;
  Remote remote; 
  
  public commandGui(Environment map, GUI gui, Remote r) {
    JFrame frame = new JFrame("Controller"); 
    JPanel turnButtons = new JPanel();
    JPanel commandButtons = new JPanel();
    env = map;
    g = gui;
    remote = r; 
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
    frame.setLocation(60, 615);
    pack(); 
    frame.setVisible(true); 
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(env.getSelectedCell().hasLifeForm()) {
      if(e.getSource() == North) {
        remote.setCommand(new North(), env);
      } else if(e.getSource() == East) {
        remote.setCommand(new East(), env);
      } else if (e.getSource() == South) {
        remote.setCommand(new South(), env);
      } else if (e.getSource() == West) {
        remote.setCommand(new West(), env);
      } else if (e.getSource() == Reload) {
        remote.setCommand(new Reload(), env);
      } else if (e.getSource() == Drop) {
        remote.setCommand(new Drop(), env);
      } else if (e.getSource() == Attack) {
        remote.setCommand(new Attack(), env);
      } else if (e.getSource() == Pickup) {
        remote.setCommand(new Pickup(), env);
      } else if (e.getSource() == Move) {
        remote.setCommand(new Move(), env);
      } else {
        remote.setCommand(null, env);
      }
      
      remote.buttonPressed();
    } else {
      System.out.println("There is no lifeform in the selected cell. Try Again.");
    }
    
    // Redraw gui to reflect changes 
    g.redrawBoard();
    g.redrawStats();
  }
}
