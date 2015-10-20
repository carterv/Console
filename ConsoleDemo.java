import carterv.console.Console;
import java.util.Scanner;

public class ConsoleDemo
{
   public static void main(String[] args)
   {
      Console c = new Console(System.getProperty("user.dir") + "\\commands\\");
      Scanner in = new Scanner(System.in);
      System.out.print("> ");
      while (in.hasNextLine())
      {
         c.executeCommand(in.nextLine());
         
         while (c.hasOutput())
         {
            System.out.println(c.nextLine());
         }
         
         if (!c.isActive()) break;
         System.out.print("> ");
      }
   }
}