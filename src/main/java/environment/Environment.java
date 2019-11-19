package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A class that creates an Environment type.
 * 
 * @author andrewjanuszko
 */
public class Environment extends Object {

  private Cell[][] cell;
  private static Environment env;
  private Cell selectedCell;

  /**
   * Environment constructor — template for Environment type.
   * 
   * @param row holds the y position in the 2D array.
   * @param col holds the x position in the 2D array.
   */
  private Environment(int row, int col) {
    cell = new Cell[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        cell[i][j] = new Cell();
      }
    }
  }

  /**
   * Allows users to add LifeForms to the environment.
   * 
   * @param lf  — holds the LifeForm to be added.
   * @param row — the y position to store it at in the 2D array.
   * @param col — the x position to store it at in the 2D array.
   * @return true if added successfully, false if not added.
   */
  public boolean addLifeForm(LifeForm lf, int row, int col) {
    if (getLifeForm(row, col) == lf) {
      return false;
    }
    if (getLifeForm(row, col) == null) {
      cell[row][col].addLifeForm(lf);
      lf.setLocation(row, col);
    }
    return (cell[row][col].getLifeForm() == lf) ? true : false;
  }

  /**
   * Add a weapon to the the lifeform at the position of row, col.
   * 
   * @param weapon - weapon to add
   * @param row    - the y position to store it at in the 2D array.
   * @param col    - the x position to store it at in the 2D array.
   * @return - whether or not the addition was successful.
   */
  public boolean addWeapon(Weapon weapon, int row, int col) {
    if (env.getNumRows() > row && env.getNumCols() > col && col >= 0 && row >= 0) {
      return cell[row][col].addWeapon(weapon);
    }
    return false;
  }

  /**
   * Removes all LifeForms and Weapons. Used for resets.
   */
  public void clearBoard() {
    for (int i = 0; i < getNumRows(); ++i) {
      for (int j = 0; j < getNumCols(); ++j) {
        cell[i][j] = new Cell();
      }
    }
  }

  /**
   * Get the distance between a lifeform at [row1][col1] and the other lifeform at
   * [row2][col2].
   * 
   * @param row1 - the y position of the first lifeform.
   * @param col1 - the x position of the first lifeform.
   * @param row2 - the y position of the second lifeform.
   * @param col2 - the x position of the second lifeform.
   * @return - the distance between the lifeforms.
   */
  public double getDistance(int row1, int col1, int row2, int col2) {
    return 5 * Math.sqrt(Math.pow(col2 - col1, 2) + Math.pow(row2 - row1, 2));
  }

  /**
   * Gets distance between two life forms.
   * 
   * @param lf1 - first life form.
   * @param lf2 - second life form.
   * @return distance.
   */
  public double getDistance(LifeForm lf1, LifeForm lf2) {
    return 5 * Math.sqrt(Math.pow(lf2.getCol() - lf1.getCol(), 2) + Math.pow(lf2.getRow() - lf1.getRow(), 2));
  }

  /**
   * Creates a singleton instance of the environment.
   * 
   * @param rows the num of rows in the environment.
   * @param cols the num of cols in the environment.
   * @return the Singleton instance of the Environment.
   */
  public static Environment getEnvironment(int rows, int cols) {
    if (env == null) {
      env = new Environment(rows, cols);
      env.selectCell(0, 0);
    }
    return env;
  }

  /**
   * Allows users to retrive the LifeForm they stored.
   * 
   * @param row — the y position to get from the 2D array.
   * @param col — the x position to get from the 2D array.
   * @return the LifeForm from the array.
   */
  public LifeForm getLifeForm(int row, int col) {
    return cell[row][col].getLifeForm();
  }

  /**
   * Get columns.
   * 
   * @return number of columns.
   */
  public int getNumCols() {
    return cell[0].length;
  }

  /**
   * Get rows.
   * 
   * @return number of rows.
   */
  public int getNumRows() {
    return cell.length;
  }

  /**
   * Gets array of weapons.
   * 
   * @param row the row of the cell
   * @param col the col of the cell
   * @return the weapons in the cell.
   */
  public Weapon[] getWeapons(int row, int col) {
    Weapon[] weapons = new Weapon[2];
    weapons[0] = cell[row][col].getWeapon1();
    weapons[1] = cell[row][col].getWeapon2();
    return weapons;
  }

  /**
   * Allows users to remove LifeForms from the environment.
   * 
   * @param row — the y position to remove from the 2D array.
   * @param col — the x position to remove from the 2D array.
   */
  public void removeLifeForm(int row, int col) {
    cell[row][col].removeLifeForm();
  }

  /**
   * Removes a weapon from a cell.
   * 
   * @param weapon the weapon to be removed.
   * @param row    the row of the weapon.
   * @param col    the col of the weapon.
   * @return the weapon in the cell.
   */
  public Weapon removeWeapon(Weapon weapon, int row, int col) {
    return cell[row][col].removeWeapon(weapon);
  }

  /**
   * Returns the number of entities in the environment.
   * 
   * @return the number of entities in the environment.
   */
  public int getNumberOfEntities() {
    int sum = 0;
    for (int i = 0; i < getNumRows(); i++) {
      for (int j = 0; j < getNumCols(); j++) {
        if (cell[i][j].hasLifeForm()) {
          ++sum;
        }
      }
    }
    return sum;
  }

  /**
   * Returns a cell based on row, col.
   * 
   * @param r the row of the cell.
   * @param c the col of the cell.
   * @return the cell based on row, col.
   */
  public Cell getCell(int r, int c) {
    return cell[r][c];
  }

  /**
   * Selects a cell from row, col.
   * 
   * @param r  the row of the cell.
   * @param co the col of the cell.
   */
  public void selectCell(int r, int co) {

    selectedCell = cell[r][co];
    System.out.println("Selected (" + r + ", " + co + ")");
  }

  /**
   * Returns the selected cell.
   * 
   * @return the selected cell.
   */
  public Cell getSelectedCell() {
    return selectedCell;
  }

  /**
   * Moves 1 cell (5 meters) in the current direction of the LifeForm.
   * 
   * @return true if the LifeForm moved, false if it did not.
   */
  public boolean move() {
    String[] directions = { "North", "East", "South", "West" };
    Cell selectedCell = getSelectedCell();
    Cell newCell;
    if (selectedCell.hasLifeForm()) {
      int maxMove = selectedCell.getLifeForm().getMoveSpeed();
      int direction = selectedCell.getDirection();
      int row = selectedCell.getLifeForm().getRow();
      int col = selectedCell.getLifeForm().getCol();
      int maxRow = getNumRows();
      int maxCol = getNumCols();
      switch (direction) {
      case 1:
        if (row - 1 < 0 || cell[row - 1][col].hasLifeForm() || selectedCell.getLifeForm().getMovesLeft() == 0) {
          System.out.println("Failed to move " + directions[direction - 1] + ".");
          return false;
        } else {
          newCell = getCell(row - 1, col);
          newCell.addLifeForm(selectedCell.getLifeForm());
          newCell.getLifeForm().setLocation(row - 1, col);
          env.selectCell(row - 1, col);
          break;
        }
//          for(int i = maxMove; i >= 0; --i) {
//            if(i == 0) {
//              System.out.println("Failed to move " + directions[direction - 1] + ".");
//              return false;
//            }
//            if(row - i >= 0 && !cell[row - i][col].hasLifeForm() && selectedCell.getLifeForm().getMovesLeft() != 0) {
//              newCell = getCell(row - i, col);
//              newCell.addLifeForm(selectedCell.getLifeForm());
//              newCell.getLifeForm().setLocation(row - i, col);
//              env.selectCell(row - i, col);
//              break;
//            }
//          }
//          break;
      case 2:
        if (col + 1 == maxCol || cell[row][col + 1].hasLifeForm() || selectedCell.getLifeForm().getMovesLeft() == 0) {
          System.out.println("Failed to move " + directions[direction - 1] + ".");
          return false;
        } else {
          newCell = getCell(row, col + 1);
          newCell.addLifeForm(selectedCell.getLifeForm());
          newCell.getLifeForm().setLocation(row, col + 1);
          env.selectCell(row, col + 1);
          break;
        }
      case 3:
        if (row + 1 == maxRow || cell[row + 1][col].hasLifeForm() || selectedCell.getLifeForm().getMovesLeft() == 0) {
          System.out.println("Failed to move " + directions[direction - 1] + ".");
          return false;
        } else {
          newCell = getCell(row + 1, col);
          newCell.addLifeForm(selectedCell.getLifeForm());
          newCell.getLifeForm().setLocation(row + 1, col);
          env.selectCell(row + 1, col);
          break;
        }
      case 4:
        if (col - 1 < 0 || cell[row][col - 1].hasLifeForm() || selectedCell.getLifeForm().getMovesLeft() == 0) {
          System.out.println("Failed to move " + directions[direction - 1] + ".");
          return false;
        } else {
          newCell = getCell(row, col - 1);
          newCell.addLifeForm(selectedCell.getLifeForm());
          newCell.getLifeForm().setLocation(row, col - 1);
          env.selectCell(row, col - 1);
          break;
        }
      default:
        System.out.println("Defaulted. Input direction '" + direction + "' is not in [ 1, 2, 3, 4 ].");
        return false;
      }
      selectedCell.removeLifeForm();
      System.out.println("Moved " + directions[direction - 1] + ".");
      return true;
    }
    return false;
  }

  /**
   * Allows the selected cell to find the nearest target?
   * 
   * @return the selected target.
   */
  public Cell findTarget() {
    Cell target = null;
    int row, col;
    row = selectedCell.getLifeForm().getRow();
    col = selectedCell.getLifeForm().getCol();

    if (selectedCell.getLifeForm().getDirection() == 1) {
      if(row == 0) {
        return null;
      } else {
        target = cell[--row][col];
      }

      while (target.hasLifeForm() == false && target != cell[0][col]) {
        target = cell[--row][col];

      }
    } else if (selectedCell.getLifeForm().getDirection() == 2) {
      target = cell[row][++col];

      while (target.hasLifeForm() == false && target != cell[row][getNumCols() - 1]) {
        target = cell[row][++col];
      }
    } else if (selectedCell.getLifeForm().getDirection() == 3) {
      target = cell[++row][col];
      while (target.hasLifeForm() == false && target != cell[getNumRows() - 1][col]) {
        target = cell[++row][col];
      }
    } else if (selectedCell.getLifeForm().getDirection() == 4) {
      target = cell[row][--col];
      while (target.hasLifeForm() == false && target != cell[row][0]) {
        target = cell[row][--col];
      }
    }
    
    String victim = env.getCell(row, col).getLifeForm().getName(), player = env.getSelectedCell().getLifeForm().getName();
//    System.out.println("'" + player + "' hit '" + victim + "' (" + row + "," + col + ") ");
    return target;
  }
}
