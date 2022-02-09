import java.util.Scanner;

public class Launcher {
    public static void main(String args[])
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String userText = scanner.nextLine();
        if (!userText.equals("quit"))
        {
            System.out.println("Unknown Command");
        }
    }
}
