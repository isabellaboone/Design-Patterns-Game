package commands;

import environment.Environment;

/**
 * Remote Control for Commands, it accepts command and executes.  
 * Invoker - accepts commands and executes them. 
 */
public class Remote {
  Command command; 
  Environment env; 
  
  public void setCommand(Command c, Environment env) {
    this.command = c;
    this.env = env; 
  }
  
  public void buttonPressed() {
    command.execute(env);
  }
}
