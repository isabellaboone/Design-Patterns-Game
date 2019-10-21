package gameplay;

public interface Timer {
  
  void addTimeObserver(TimerObserver o);
  
  void timeChanged();
  
  void removeTimeObserver(TimerObserver o);

}
