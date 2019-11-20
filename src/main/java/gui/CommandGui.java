package gui;

import commands.Remote;
import environment.Environment;
import exceptions.WeaponException;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommandGui extends JFrame implements ActionListener {

  JButton north;
  JButton south;
  JButton east;
  JButton west;
  JButton move;
  JButton reload;
  JButton attack;
  JButton drop;
  JButton pickup;
  Environment env;
  Gui gui;
  Remote remote;

  /**
   * constructs the CommandGUI.
   * 
   * @param map the environment that is passed in.
   * @param gui the main game display.
   * @param r   the remote of commands.
   */
  public CommandGui(Environment map, Gui gui, Remote r) {
    this.env = map;
    this.gui = gui;
    this.remote = r;
    
    JFrame frame = new JFrame("Controller");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 200);
    frame.setLayout(new FlowLayout());
    JPanel turnButtons = new JPanel();
    turnButtons.setLayout(new BorderLayout());

    // Create button
    north = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_north.png")));
    west = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_west.png")));
    south = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_south.png")));
    east = new JButton(new ImageIcon(getClass().getResource("CommandButtons/unselected_east.png")));
    move = new JButton(new ImageIcon(getClass().getResource("CommandButtons/move.png")));
    reload = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Reload.png")));
    attack = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Attack.png")));
    drop = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Drop.png")));
    pickup = new JButton(new ImageIcon(getClass().getResource("CommandButtons/Pickup.png")));

    // Add action listeners 
    north.addActionListener(this);
    west.addActionListener(this);
    south.addActionListener(this);
    east.addActionListener(this);
    move.addActionListener(this);
    reload.addActionListener(this);
    attack.addActionListener(this);
    drop.addActionListener(this);
    pickup.addActionListener(this);

    turnButtons.add("Center", move);
    turnButtons.add("North", north);
    turnButtons.add("West", west);
    turnButtons.add("South", south);
    turnButtons.add("East", east);
    JPanel commandButtons = new JPanel();
    commandButtons.add(reload);
    commandButtons.add(attack);
    commandButtons.add(drop);
    commandButtons.add(pickup);

    frame.add(turnButtons);
    frame.add(commandButtons);
    frame.setLocation(60, 615);
    pack();
    frame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (env.getSelectedCell().hasLifeForm()) {
      if (e.getSource() == north) {
        remote.buttonPressed(0);
      } else if (e.getSource() == east) {
        remote.buttonPressed(1);
      } else if (e.getSource() == south) {
        remote.buttonPressed(2);
      } else if (e.getSource() == west) {
        remote.buttonPressed(3);
      } else if (e.getSource() == reload) {
        remote.buttonPressed(4);
      } else if (e.getSource() == drop) {
        remote.buttonPressed(5);
      } else if (e.getSource() == attack) {
        remote.buttonPressed(6);
      } else if (e.getSource() == pickup) {
        remote.buttonPressed(7);
      } else if (e.getSource() == move) {
        remote.buttonPressed(8);
      }
    } else {
      System.out.println("There is no lifeform in the selected cell. Try Again.");
    }

    gui.redrawBoard();
    gui.redrawStats();
  }
}
