import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;




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
        //while (!userText.equals("quit")) {
            //if (userText.equals("fibo")) {
                /*System.out.println("Please enter a number n");
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
            }
            else if(userText.equals("freq")){
                System.out.println("Please enter the path of the file");
                String strFilePath = scanner.nextLine();
                Path filePath = Paths.get(strFilePath);
                try
                {
                    String content = Files.readString(filePath).toLowerCase().replaceAll("[^a-z^\n^ ]", "");
                    //content = content.toLowerCase().replaceAll("^[-a-z\n ]", "");
                    String[] words = content.split("[ \n]");
                    List<String> strings = new ArrayList<>();
                    for (String word : words) {
                        if (!word.isBlank()) {
                            strings.add(word);
                        }
                    }
                    Map<String, Long> countWordsNumber =  strings.stream()
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


                    Map<String, Long> countWordsLimit3 = new LinkedHashMap<>();
                    countWordsNumber.entrySet().stream()
                            .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                            .limit(3)
                            .forEachOrdered(e -> countWordsLimit3.put(e.getKey(), e.getValue()));

                    for(Entry entry: countWordsLimit3.entrySet())
                    {
                        System.out.printf("%s ", entry.getKey());
                    }
                    System.out.println();
                }
                catch (NoSuchFileException e)
                {
                    System.out.println("Unreadable File: ");
                    System.out.println("NoSuchFileException");
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    System.out.println("Unreadable File : ");
                    System.out.println("IoException");
                    e.printStackTrace();
                }*/
           // else {
             //   System.out.println("Unknown Command");
            //}
            //userText = scanner.nextLine();
