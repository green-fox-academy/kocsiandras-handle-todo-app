import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  public static void main(String[] args) {
    List<String> content = new ArrayList<>();
    content.add("Walk the dog");
    content.add("Buy milk");
    content.add("Do homework");
    try {
      Path filepath = Paths.get("tasks.txt");
      Files.write(filepath, content);
    } catch (Exception e) {
      System.out.println("not working");
    }
    if (args.length == 0) {
      System.out.println(
          "Command Line Todo application\n" +
              "=============================\n" +
              "\n" +
              "Command line arguments:\n" +
              "    -l   Lists all the tasks\n" +
              "    -a   Adds a new task\n" +
              "    -r   Removes an task\n" +
              "    -c   Completes an task");
    } else if (args.length == 1) {
      if (args[0].equals("-l")) {
        try {
          Path filePath = Paths.get("tasks.txt");
          List<String> lines = Files.readAllLines(filePath);
          if (lines.size() == 0) {
            System.out.println("No todos for today! :)");
          }
          for (int i = 0; i < lines.size(); i++) {
            System.out.println(i + 1 + " - " + lines.get(i));
          }
        } catch (Exception e) {
          System.out.println("not working");
        }
      }
    } else if (args.length == 2) {
      if (args[0].equals("-a") && args[1].equals("Feed the monkey")) {
        content.add("Feed the monkey");
        try {
          Path filepath = Paths.get("tasks.txt");
          Files.write(filepath, content);
        } catch (Exception e) {
          System.out.println("not working");
        }
      }
    }
  }

}
