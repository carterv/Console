package carterv.console.commands;

import carterv.console.*;
import java.util.ArrayList;

public class Help extends Command
{
   public Help(Console c)
   {
      super(c);
   }
   
   public String name()
   {
      return "help";
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
      return "Lists all available commands";
   }
   
   public void execute(String[] args)
   {
      ArrayList<Command> commands = getConsole().getCommands();
      for (Command c : commands)
      {
         String syntax = c.name();
         for (String s : c.argNames())
         {
            syntax += " " + s;
         }
         getConsole().addOutput(syntax);
         getConsole().addOutput("  " + c.helpString());
      }
   }
}