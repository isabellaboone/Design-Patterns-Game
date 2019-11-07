package movement;

public enum Directions {
  NORTH(1),
  EAST(2),
  SOUTH(3),
  WEST(4);
  
  private int value;
  
  private Directions(int value) {
    this.value = value;
  }

  public static Directions toString(int direction) {
    switch(direction) {
    case 1: return NORTH;
    case 2: return EAST;
    case 3: return SOUTH;
    case 4: return WEST;
    default: return null;
    }
  }
}


