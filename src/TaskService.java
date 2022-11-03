import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Task> taskMap;

    public TaskService() {
        this.taskMap = new LinkedHashMap<>();
    }

    public void addTask(Task task) {

        if (!taskMap.containsKey(task.getId())) {
            taskMap.put(task.getId(), task);
        } else {
            System.out.println("Такая задача уже есть!");
        }
    }

    public void deleteTask(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
        } else {
            System.out.println("Такой задачи в списке нет!");
        }
    }

    public void printTasksForDay(LocalDate date) {
        System.out.println("На " + date + " : ");
        for (Task value : taskMap.values()) {
            if (value.appearsIn(date)) {
                System.out.println(value);
            }
        }
    }

    public void printAllTasks() {
        for (Task value : taskMap.values()) {
            System.out.println(value);
        }
    }

    @Override
    public String toString() {
        return "TaskService{" +
                "taskMap=" + taskMap +
                '}';
    }
}
