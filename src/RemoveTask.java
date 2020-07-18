import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RemoveTask {
  public void removeTask(int removingPosition) {
    try {
      Path filepath = Paths.get("tasks.txt");
      List<String> list = Files.readAllLines(filepath);
      if (list.size() >= removingPosition) {
        list.remove(list.get(removingPosition - 1));
        Files.write(filepath, list);
        System.out.println("removed");
      } else {
        System.out.println("Unable to remove: index is out of bound");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
