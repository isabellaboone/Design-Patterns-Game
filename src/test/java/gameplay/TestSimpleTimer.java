package gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * timer tests.
 * @author andrewjanuszko
 */
public class TestSimpleTimer {

  /**
   * test init.
   */
  @Test
  public void testInitialization() {
    SimpleTimer s = new SimpleTimer();
    assertEquals(0, s.getRound());
    assertEquals(0, s.getNumObservers());
  }
  
  /**
   * test time oberver addition.
   */
  @Test
  public void testAddTimerObserver() {
    SimpleTimer s = new SimpleTimer();
    MockSimpleTimerObserver m1 = new MockSimpleTimerObserver();
    s.addTimeObserver(m1);
    assertEquals(0, s.getRound());
    assertEquals(1, s.getNumObservers());
    s.timeChanged();
    assertEquals(1, s.getRound());
    assertEquals(1, m1.time);
    s.timeChanged();
    assertEquals(2, s.getRound());
    assertEquals(2, m1.time);
  }
  
  /**
   * test remove.
   */
  @Test
  public void testRemoveTimerObserver() {
    SimpleTimer s = new SimpleTimer();
    MockSimpleTimerObserver m1 = new MockSimpleTimerObserver();
    MockSimpleTimerObserver m2 = new MockSimpleTimerObserver();
    s.addTimeObserver(m1);
    s.addTimeObserver(m2);
    assertEquals(0, s.getRound());
    assertEquals(2, s.getNumObservers());
    s.timeChanged();
    assertEquals(1, s.getRound());
    assertEquals(1, m1.time);
    assertEquals(1, m2.time);
    s.removeTimeObserver(m1);
    s.timeChanged();
    assertEquals(2, s.getRound());
    assertEquals(1, m1.time);
    assertEquals(2, m2.time);
  }
  
  /**
   * test thread.
   * @throws InterruptedException if broken.
   */
  @Test
  public void testAsThread() throws InterruptedException {
    SimpleTimer s = new SimpleTimer(1000);
    s.start();
    Thread.sleep(250);
    for (int i = 0; i < 5; i++) {
      assertEquals(i, s.getRound());
      Thread.sleep(1000);
    }
  }
}