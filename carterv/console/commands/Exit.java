package carterv.console.commands;

import carterv.console.*;

public class Exit extends Command
{
   public Exit(Console c)
   {
      super(c);
   }
   
   public String name()
   {
      return "exit";
   }
   
   public int numArgs()
   {
      return 0;
   }
   
   public String[] argNames()
   {
      return new String[] {};
   }
   
   public String helpString()
   {
      return "Exits the console";
   }
   
   public void execute(String[] args)
   {
      getConsole().toggleActive();
   }
}