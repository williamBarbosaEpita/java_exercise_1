import java.util.*;
public class Launcher {

    public static void main(String args[]) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to the Jungle");
        Command cmd = null;
        List<Command> myCommands = new ArrayList<Command>();
        myCommands.add(new Quit());
        myCommands.add(new Fibo());
        myCommands.add(new Freq());
        String userText = "";
        do {
            userText = scanner.nextLine();
            cmd = null;
            for (Command command : myCommands) {
                if (userText.equals(command.name())) {
                    cmd = command;
                    break;
                }
            }
            if (cmd == null)
                System.out.println("Unknown Command");
        }
        while (cmd == null || !cmd.run(scanner));
        scanner.close();
    }
}