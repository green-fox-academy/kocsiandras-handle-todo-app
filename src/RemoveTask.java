import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RemoveTask {
  public void removeTask(int removingPosition) {
    try {
      Path filepath = Paths.get("tasks.txt");
      List<String> list = Files.readAllLines(filepath);
      list.remove(list.get(removingPosition - 1));
      Files.write(filepath, list);
      System.out.println("removed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
