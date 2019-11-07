package movement;

public interface Movement {

    final static Directions[] directions = Directions.values();
    
    public int getDirection();
    public boolean turn(int direction); //Key bound to 1, 2, 3, 4
    public boolean move(); // move with 0
}
