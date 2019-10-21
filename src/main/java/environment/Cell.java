package environment;

import lifeform.LifeForm;

/**
 * A class that creates a Cell type.
 * @author andrewjanuszko
 */
public class Cell {
  
  LifeForm entity;

  /**
   * Allows the user to return the stored
   * LifeForm.
   * @return the LifeForm
   */
  public LifeForm getLifeForm() {
    return entity;
  }

  /**
   * Allows the user to add a LifeForm.
   * @param entity — the LifeForm to be stored.
   * @return true is the LifeForm was added, false if a LifeForm is saved.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (this.entity == null) {
      this.entity = entity;
    }
    return (this.entity == entity) ? true : false;
  }
  
  /**
   * Allows the user to remove a LifeForm.
   */
  void removeLifeForm() {
    entity = null;
  }
  
}
