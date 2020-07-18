import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  public static void main(String[] args) {
    AddNewTask addNewTask = new AddNewTask();
    ListTasks listTasks = new ListTasks();
    PrintFlags printFlags = new PrintFlags();
    RemoveTask removeTask = new RemoveTask();
    CheckTask checkTask = new CheckTask();

    List<String> content = new ArrayList<>();
    content.add("Walk the dog");
    content.add("Buy milk");
    content.add("Do homework");
    Path filepath = Paths.get("tasks.txt");

    try {
      content = Files.readAllLines(filepath);
      filepath = Paths.get("tasks.txt");
      Files.write(filepath, content);
    } catch (Exception e) {
      System.out.println("not working");
    }

    if (args.length == 0) {
      printFlags.printFlags();
    } else if (args[0].equals("-l")) {
      listTasks.listTasks();
    } else if (args.length == 2 && args[0].equals("-a")) {
      addNewTask.addNewTask(args[1]);
    } else if (args.length == 1 && args[0].equals("-a")) {
      System.out.println("Unable to add: no task provided");
    } else if (args.length == 2 && args[0].equals("-r")) {
      try {
        removeTask.removeTask(Integer.parseInt((args[1])));
      } catch (Exception e) {
        System.out.println("Unable to remove: index is not a number");
      }
    } else if (args.length == 1 && args[0].equals("-r")) {
      System.out.println("Unable to remove: no index provided");
    } else if (args.length == 2 && args[0].equals("-c")) {
      checkTask.checkTask(Integer.parseInt((args[1])));
    }
  }
}
