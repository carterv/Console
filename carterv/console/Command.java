package carterv.console;

public class Command
{
   Console console;
   
   public Command(Console c)
   {
      console = c;
   }
   
   public abstract String name();
   
   public abstract String[] argNames();
   
   public abstract String helpString();
   
   public abstract void execute(String[] args);
}