import java.util.Scanner;

public class Launcher {
    public static void main(String args[])
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String userText = scanner.nextLine();
        while (!userText.equals("quit"))
        {
            System.out.println("Unknown Command");
            userText = scanner.nextLine();
        }
    }
}
