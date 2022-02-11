import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibo implements Command
{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Please enter a number n");
        try
        {
            int userNumber = scanner.nextInt();
            scanner.nextLine();
            int fn1 = 0;
            int fn2 = 1;
            int i = 0;
            while (i < userNumber)
            {
                i++;
                fn2 = fn2 + fn1;
                fn1 = fn2 - fn1;
            }
            System.out.println(fn1);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Not an int :");
            System.out.println("InputMismatchException");
            e.printStackTrace();
        }
        return false;
    }
}
