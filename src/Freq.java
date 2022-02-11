import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
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

            for(Map.Entry entry: countWordsLimit3.entrySet())
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
        }
        return false;
    }
}
