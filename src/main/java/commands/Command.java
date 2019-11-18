package commands;

import environment.Environment;

public interface Command {
  public void execute(Environment env); 
}
