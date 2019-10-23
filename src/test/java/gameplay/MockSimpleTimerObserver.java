package gameplay;

/**
 * Makes mock obsevrer tests.
 * @author andrewjanuszko
 */
class MockSimpleTimerObserver implements TimerObserver {

  int time = 0;
  
  /**
   * make mock observer.
   */
  MockSimpleTimerObserver() {
    this.time = 0;
  }
  
  /**
   * allows us to update time.
   */
  public void updateTime(int time) {
    this.time = time;
    
  }
  
}

