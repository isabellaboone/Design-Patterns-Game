package movement;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MovementException;
import lifeform.MockLifeForm;

public class TestMovement {
  
  final MockLifeForm player = new MockLifeForm("Player", 10);

  /**
   * 
   * @throws MovementException
   */
  @Test
  public void testTurning() throws MovementException {
    try {
      assertTrue(player.turn(2));
      assertFalse(player.turn(2));
      assertTrue(player.turn(1));
      assertFalse(player.turn(1));
      assertTrue(player.turn(-2));
      assertFalse(player.turn(-2));
      assertTrue(player.turn(-1));
      assertFalse(player.turn(-1));
      player.turn(0);
    } catch (MovementException me) {
      System.out.println(me.toString());
    }
  }

  @Test
  public void testDirection() throws MovementException {
    assertEquals(1, player.getDirection());
    assertTrue(player.turn(2));
    assertEquals(2, player.getDirection());
  }
}
