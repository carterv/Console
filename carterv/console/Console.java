package carterv.console;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Console
{
   private ArrayList<Command> commands;
   private LinkedList<String> output;
   
   public Console(String filepath)
   {
      commands = new ArrayList<Command>();
      output = new LinkedList<String>();
      
      //get a list of the files in the given path, add all to the commands ararylist
   }
   
   public boolean executeCommand(String command)
   {
      String parts = command.split(" ");
      if (parts.length == 0) return false;
      boolean flag = false;
      for (Command c : commands)
      {
         if (c.name().equals(parts[0]))
         {
            if (parts.length-1 == c.argNames().length)
            {
               c.execute(Arrays.copyOfRange(parts, 1, parts.length));
               flag = false;
               break;
            }
            else flag = true;
         }
      }
      if (flag)
      {
         addOutput("Error: Invalid Syntax");
         addOutput("Use 'help " + parts[0] + "'");
      }
   }
   
   public ArrayList<Command> getCommands()
   {
      return commands;
   }
   
   public void addOutput(String line)
   {
   
   }
   
   public boolean hasOutput()
   {
      return output.size() != 0;
   }
   
   public String nextLine()
   {
      return output.remove();
   }
}