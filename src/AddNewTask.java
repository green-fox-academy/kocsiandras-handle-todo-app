import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddNewTask {
  public void addNewTask(String input) {
    try {
      Path filepath = Paths.get("tasks.txt");
      List<String> lines = Files.readAllLines(filepath);
      lines.add(" - [ ] " + input);
      Files.write(filepath, lines);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
