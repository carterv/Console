package carterv.console;

public abstract class Command
{
   Console console;
   
   public Command(Console c)
   {
      console = c;
   }
   
   public Console getConsole()
   {
      return console;
   }
   
   public abstract String name();
   
   public abstract int numArgs();
   
   public abstract String[] argNames();
   
   public abstract String helpString();
   
   public abstract void execute(String[] args);
}