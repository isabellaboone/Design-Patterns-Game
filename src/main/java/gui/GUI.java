package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import environment.*;
import lifeform.*;

public class GUI extends JFrame {
  Environment env;
  static GridBagConstraints x = new GridBagConstraints();
  Cell p = new Cell();

  boolean q = p.addLifeForm(new Human("Bob", 100, 10));

  public GUI(Environment env) {
    this.env = env;
    setLayout(new GridBagLayout());
    drawEnvironment();
    drawStats(p);
    drawLegend();
    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void drawEnvironment() {

    JPanel board = new JPanel(new GridBagLayout());
    JLabel[][] labelArray = new JLabel[env.getNumRows()][env.getNumCols()];
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        // labelArray[r][c] = new JLabel(" ("+r+":"+c+") ");
        JLabel imageLabel = new JLabel(createSquare(env.getCell(r, c)));
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

  public void drawStats(Cell c) {
    JLabel stats = new JLabel(c.getStats());
    stats.setLocation(0, 0);
    stats.setOpaque(true);
    stats.setBackground(new Color(200, 200, 200));
    x.anchor = x.FIRST_LINE_START;
    x.weighty = 1.0;
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
    g.setColor(new Color(100, 100, 100));
    g.fillRect(0, 0, 50, 50);
    g.setColor(Color.WHITE);
    g.drawRect(49, 0, 1, 50);
    g.drawRect(0, 49, 50, 1);

    return new ImageIcon(i);
  }

  private ImageIcon legendImage() {
    BufferedImage i = new BufferedImage(500, 150, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = i.getGraphics();
    return new ImageIcon(i);
  }
}
