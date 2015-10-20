package carterv.console.commands;

import carterv.console.*;

public class Echo extends Command
{
   public Echo(Console c)
   {
      super(c);
   }
   
   public String name()
   {
      return "echo";
   }
   
   public int numArgs()
   {
      return -1;
   }
   
   public String[] argNames()
   {
      return new String[] {"message"};
   }
   
   public String helpString()
   {
      return "Prints a message to the console";
   }
   
   public void execute(String[] args)
   {
      String message = "";
      for (String s : args) message += " " + s;
      getConsole().addOutput(message);
   }
}