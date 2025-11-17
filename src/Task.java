public class Task<T> {
    private Integer priority;
    private T task;

    public Task(Integer priority, T task) {
        if (priority == null) {
            this.priority = 0;
        }
        else {
            this.priority = priority;
        }

        this.task = task;
    }

    public Integer getPriority() { return priority; }

    public T getTask() { return task; }

    public int compareTo(Task<T> task) {
        return this.priority.compareTo(task.priority);
    }
}
