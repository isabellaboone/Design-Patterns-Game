package movement;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.MovementException;

public interface Movement {
  
  public boolean turn(int direction) throws MovementException;
  public int getDirection();
  
}
