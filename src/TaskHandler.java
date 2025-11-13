import java.util.LinkedList;
import java.util.Queue;

public class TaskHandler<T> {
    private String name;
    private String email;

    private Queue<Task<T>> taskQueue = new LinkedList<>();

    public TaskHandler(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int taskCount() {
        return taskQueue.size();
    }

    public void addTask(Task<T> task) {
        taskQueue.add(task);
    }

    public Task<T> nextTask() {
        return taskQueue.peek();
    }

    public Task<T> finishTask() {
        return taskQueue.poll();
    }

    public String getName() { return name; }

    public String getEmail() { return email; }
}
