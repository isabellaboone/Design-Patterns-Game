package gameplay;

import java.util.ArrayList;

public class SimpleTimer extends Thread implements Timer {
  
  private ArrayList<TimerObserver> theObservers = new ArrayList<TimerObserver>();
  private int round;
  private int sleep;
  
  /**
   * Constructor for a timer.
   */
  public SimpleTimer() {
    this.round = 0;
  }
  
  /**
   * Constructor for a timer.
   * @param sleep holds the thread sleep
   */
  public SimpleTimer(int sleep) {
    this();
    this.sleep = sleep;
    
  }

  /**
   * Add observer.
   */
  public void addTimeObserver(TimerObserver observer) {
    theObservers.add(observer);
  }

  /**
   * Time changed.
   */
  public void timeChanged() {
    updateRound();
    theObservers.forEach(item -> item.updateTime(round));
  }

  /**
   * Remove time.
   */
  public void removeTimeObserver(TimerObserver observer) {
    theObservers.remove(observer);
  }
  
  /**
   * get number of observers.
   * @return the size of the observers.
   */
  public int getNumObservers() {
    return theObservers.size();
    
  }
  
  /**
   * gets the round.
   * @return the round.
   */
  public int getRound() {
    return round;
  }
  
  /**
   * updates the round.
   */
  public void updateRound() {
    ++round;
  }
  
  /**
   * runs the thread.
   */
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(sleep);
        timeChanged();
      } catch (InterruptedException ie) {
        System.out.println("Oof it broke.");
      }
    }
    
  }

}
