import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CheckTask {

  public void checkTask(int checkedIndex) {
    try {
      Path filepath = Paths.get("tasks.txt");
      List<String> list = Files.readAllLines(filepath);
      String done = list.get(checkedIndex - 1);
      if (list.size() >= checkedIndex) {
        list.set(checkedIndex - 1, " - [X] " + done.substring(6));
        Files.write(filepath, list);
      } else {
        System.out.println("Unable to check: index is out of bound");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
