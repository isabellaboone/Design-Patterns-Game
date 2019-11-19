package commands;

import environment.Environment;

/**
 * Remote Control for Commands, it accepts command and executes.  
 * Invoker - accepts commands and executes them. 
 */
public class Remote {
  Command[] command; 
  Environment env; 
  
  /**
   * Constructs a remote that holds an array of commands.
   * @param env an environment
   */
  public Remote(Environment env) {
    this.env = env;
    command = new Command[9];
    for (int i = 0; i < 9; i++) {
      command[i] = null;
    }
    
  }
  
  public void setCommand(int slot, Command c) {
    this.command[slot] = c; 
  }
  
  public void buttonPressed(int slot) {
    command[slot].execute(env);
  }
}
