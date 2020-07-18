import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ListTasks {
  public void listTasks() {
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
}
