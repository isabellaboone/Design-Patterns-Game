package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import environment.*;
import lifeform.*;
import weapon.Pistol;

/*
 * Possibly do:
 * make hovering work.
 */

public class GUI extends JFrame {

  Environment env;
  static GridBagConstraints x = new GridBagConstraints();
  JLabel[][] labelArray;
  JLabel stats;
  JPanel board = new JPanel(new GridBagLayout());
  final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4;

  public GUI(Environment env) {
    this.env = env;
    setLayout(new GridBagLayout());
    drawEnvironment();
    setMouseListener();
    drawStats(env.getCell(0, 0));
    drawLegend();

    pack();
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void drawEnvironment() {
    JLabel imageLabel;
    labelArray = new JLabel[env.getNumRows()][env.getNumCols()];
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        imageLabel = new JLabel(createSquare(env.getCell(r, c)));
        labelArray[r][c] = imageLabel;
        x.gridx = c;
        x.gridy = r;
        board.add(labelArray[r][c], x);
      }
    }
    x.gridx = 0;
    x.gridy = 0;
    add(board, x);
  }

  /*
   * Redraws the board.
   */
  public void redrawBoard() {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        labelArray[r][c].setIcon(createSquare(env.getCell(r, c)));
      }
    }

  }

  public void redrawStats() {
    stats.setText(env.getSelectedCell().getStats());
  }

  private void drawStats(Cell c) {
    stats = new JLabel(c.getStats());
    stats.setLocation(0, 0);
    stats.setOpaque(true);
    stats.setBackground(new Color(255, 255, 255));
    x.anchor = x.FIRST_LINE_START;
    x.gridx = 1;
    x.gridy = 0;
    add(stats, x);

  }

  /*
   * draws legend.
   */
  public void drawLegend() {
    JLabel legend = new JLabel(legendImage());
    legend.setLocation(0, 0);
    legend.setOpaque(true);
    legend.setBackground(new Color(200, 200, 200));
    x.anchor = x.FIRST_LINE_START;
    x.weighty = 1.0;
    x.gridx = 0;
    x.gridy = 1;
    add(legend, x);

  }

  private ImageIcon createSquare(Cell c) {
    BufferedImage i = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = i.getGraphics();

    // selected cell
    if (c == env.getSelectedCell()) {
      g.setColor(new Color(150, 200, 150));
      g.fillRect(0, 0, 50, 50);
      g.setColor(Color.WHITE);
      g.drawRect(49, 0, 1, 50);
      g.drawRect(0, 49, 50, 1);
    } else {
      g.setColor(new Color(204, 204, 204));
      g.fillRect(0, 0, 50, 50);
      g.setColor(Color.WHITE);
      g.drawRect(49, 0, 1, 50);
      g.drawRect(0, 49, 50, 1);
    }

    // life forms
    if (c.hasLifeForm()) {

      // life form weapons
      if (c.getLifeForm().hasWeapon()) {
        if (c.getDirection() == NORTH) {
          g.setColor(new Color(153, 153, 153));
          g.fillRect(35, 5, 10, 20);
        } else if (c.getDirection() == EAST) {
          g.setColor(new Color(153, 153, 153));
          g.fillRect(25, 35, 20, 10);
        } else if (c.getDirection() == SOUTH) {
          g.setColor(new Color(153, 153, 153));
          g.fillRect(35, 25, 10, 20);
        } else if (c.getDirection() == WEST) {
          g.setColor(new Color(153, 153, 153));
          g.fillRect(5, 5, 20, 10);
        }

      }

      // draw life forms
      if (c.getLifeForm() instanceof Alien) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(10, 10, 30, 30);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(10, 10, 30, 30);
      } else if (c.getLifeForm() instanceof Human) {
        g.setColor(new Color(0, 255, 255));
        g.fillOval(10, 10, 30, 30);
        g.setColor(new Color(0, 0, 0));
        g.drawOval(10, 10, 30, 30);
      }

      // direction facing arrow
      if (c.getDirection() == NORTH) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(25, 23, 23, 27);
        g.drawLine(25, 23, 27, 27);
      } else if (c.getDirection() == EAST) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(27, 25, 23, 23);
        g.drawLine(27, 25, 23, 27);
      } else if (c.getDirection() == SOUTH) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(25, 27, 23, 23);
        g.drawLine(25, 27, 27, 23);
      } else if (c.getDirection() == WEST) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(23, 25, 27, 23);
        g.drawLine(23, 25, 27, 27);
      }
    }

    // weapons
    if (c.hasWeapon()) {
      // pistol
      if (c.getWeapon1().toString().contains("Pistol")) {
        // handle
        g.setColor(new Color(153, 153, 153));
        g.fillRect(12, 15, 7, 22);
        g.fillRect(19, 18, 20, 10);
        // base
        g.setColor(new Color(0, 0, 0));
        g.drawRect(12, 15, 7, 22);
        g.drawRect(19, 18, 20, 10);
        // filler
        g.setColor(new Color(153, 153, 153));
        g.fillRect(13, 19, 10, 9);
      }

      // plasma canon
      if (c.getWeapon1().toString().contains("Plasma")) {
        // handle
        g.setColor(new Color(153, 153, 153));
        g.fillRect(17, 28, 5, 7);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(17, 28, 5, 7);

        // base
        g.setColor(new Color(0, 0, 0));
        g.drawRect(12, 18, 25, 10);

        // tiptop
        g.setColor(new Color(153, 153, 153));
        g.fillRect(33, 15, 8, 6);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(33, 15, 8, 6);
        // tipbottom
        g.setColor(new Color(153, 153, 153));
        g.fillRect(33, 25, 8, 6);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(33, 25, 8, 6);

        // base again?
        g.setColor(new Color(153, 153, 153));
        g.fillRect(12, 18, 25, 10);
        g.setColor(new Color(0, 0, 0));
        g.drawLine(12, 18, 33, 18);
        g.drawLine(12, 18, 12, 28);
      }

    }
    return new ImageIcon(i);
  }

  private ImageIcon legendImage() {
    BufferedImage i = new BufferedImage(500, 150, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = i.getGraphics();
    return new ImageIcon(getClass().getResource("CommandButtons/legend.png"));
  }

  private void onMouseClicked(MouseEvent e) {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        if (e.getSource() == labelArray[r][c]) {
          env.selectCell(r, c);
          redrawBoard();
          redrawStats();
        }
      }
    }
  }

  public void setMouseListener() {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        labelArray[r][c].addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            onMouseClicked(e);
          }
        });
      }
    }
  }
}
