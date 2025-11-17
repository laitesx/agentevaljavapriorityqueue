import java.util.LinkedList;
import java.util.Queue;

public class TaskHandler<T> {
    private int estimatedTime = 0;

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

    public int estimatedTime() {
        return estimatedTime;
    }

    public void addTask(Task<T> task) {
        taskQueue.add(task);

        if (task instanceof TimedTask<T>) {
            estimatedTime += ((TimedTask<T>) task).getEstimatedMinutes();
        }
    }

    public Task<T> nextTask() {
        return taskQueue.peek();
    }

    public Task<T> finishTask() {
        Task<T> task = taskQueue.poll();

        if (task instanceof TimedTask<T>) {
            estimatedTime -= ((TimedTask<T>) task).getEstimatedMinutes();
        }

        return task;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }
}
