package carterv.console;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.File;
import java.net.*;

public class Console
{
   private ArrayList<Command> commands;
   private LinkedList<String> output;
   private boolean active;
   
   public Console(String filepath)
   {
      commands = new ArrayList<Command>();
      output = new LinkedList<String>();
      active = true;
      
      File classDir = new File(filepath);
      try
      {
         URL[] url = {classDir.toURI().toURL()};
         URLClassLoader urlLoader = new URLClassLoader(url);
         
         String filename;
         for (File f : classDir.listFiles())
         {
            filename = f.getName();
            if (filename.indexOf(".") > 0) filename = filename.substring(0, filename.lastIndexOf("."));
            if (filename.startsWith(".")) continue;
            
            Class<Command> c = ((Class<Command>)urlLoader.loadClass("carterv.console.commands." + filename));
            commands.add(c.getConstructor(Console.class).newInstance(this));
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void executeCommand(String command)
   {
      String[] parts = command.split(" ");
      if (parts.length == 0) return;
      boolean flag = false;
      for (Command c : commands)
      {
         if (c.name().equals(parts[0]))
         {
            if (parts.length-1 == c.numArgs() || c.numArgs() == -1)
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
      output.add(line);
   }
   
   public boolean hasOutput()
   {
      return output.size() != 0;
   }
   
   public String nextLine()
   {
      return output.remove();
   }
   
   public boolean isActive()
   {
      return active;
   }
   
   public void toggleActive()
   {
      active = !active;
   }
}