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
  
  public commandGui(Environment map, GUI gui) {
    JFrame frame = new JFrame("Controller"); 
    JPanel turnButtons = new JPanel();
    JPanel commandButtons = new JPanel();
    env = map;
    g = gui;
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
    /*
    if(env.getSelectedCell().hasLifeForm()) {
      Command c = ((Command) e.getSource());
      c.execute();
    } else {
      System.out.println("There is no lifeform in the selected cell. Try Again.");
    }
    */
    
    
    
    if(e.getSource() == North) {
      if (env.getSelectedCell().hasLifeForm() == false) {
        System.out.println("There is no lifeform in the selected cell. Try Again.");
      } else {
        North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_north.png")));
        West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
        South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
        East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
        env.getSelectedCell().getLifeForm().turn(1);
      }
    } else if (e.getSource() == West) {
        if (env.getSelectedCell().hasLifeForm() == false) {
          System.out.println("There is no lifeform in the selected cell. Try Again.");
        } else {
          North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
          West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_west.png")));
          South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
          East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
          env.getSelectedCell().getLifeForm().turn(4);
        }
    } else if (e.getSource() == South) {
        if (env.getSelectedCell().hasLifeForm() == false) {
          System.out.println("There is no lifeform in the selected cell. Try Again.");
        } else {
          North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
          West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
          South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_south.png")));
          East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
          env.getSelectedCell().getLifeForm().turn(3);
        }
    } else if (e.getSource() == East) {
      if (env.getSelectedCell().hasLifeForm() == false) {
        System.out.println("There is no lifeform in the selected cell. Try Again.");
      } else {
        North.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
        West.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
        South.setIcon(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
        East.setIcon(new ImageIcon(getClass().getResource("CommandButtons/selected_east.png")));
        env.getSelectedCell().getLifeForm().turn(2);
      }
    } else if (e.getSource() == Move) {
        env.move();
    } else if (e.getSource() == Reload) {
      env.getSelectedCell().getLifeForm().reload();
    } else if (e.getSource() == Attack) {
      // ***************************************************************************************************
      try {
        env.getSelectedCell().getLifeForm().attack(env.findTarget().getLifeForm(), (int)(env.getDistance(env.getSelectedCell().getLifeForm(), env.findTarget().getLifeForm())));
      } catch (WeaponException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
          
    } else if (e.getSource() == Drop) {
      env.getSelectedCell().addWeapon(env.getSelectedCell().getLifeForm().dropWeapon());
    } else if (e.getSource() == Pickup) {
      if (env.getSelectedCell().getWeapon1() != null && !env.getSelectedCell().getLifeForm().hasWeapon()) { 
        /* check if cell has a weapon1 and lifeform has no weapon */
        env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon1());
        env.getSelectedCell().removeWeapon( env.getSelectedCell().getWeapon1());
      } else if (env.getSelectedCell().getWeapon2() != null && !env.getSelectedCell().getLifeForm().hasWeapon()) {
        /* check if cell has a weapon2 and lifeform has no weapon */
        env.getSelectedCell().getLifeForm().pickUpWeapon(env.getSelectedCell().getWeapon2());
        env.getSelectedCell().removeWeapon( env.getSelectedCell().getWeapon2());
      }
    }

    g.redrawBoard();
    g.redrawStats();
  }
}
