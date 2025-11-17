import java.util.LinkedList;

// This holds a priority queue and assign tasks to Task Handlers based on the priority of the queue at the moment.
// The task handler with the least tasks gets the task. In case of ties give it to whichever one was found first.
public class QueueHandler<T> {
    private PriorityQueue<T> priorityQueue = new PriorityQueue<>();

    public void addTask(Task<T> task) {
        priorityQueue.add(task);
    }

    // Given a list of task handlers hand out the next task. If the task isn't timed give it to whichever handler
    // has the least tasks. If it's timed give it to the handler with the lest currently estimated time.
    public TaskHandler<T> assignTask(LinkedList<TaskHandler<T>> handlers) {
        if (handlers.isEmpty() || priorityQueue.count() == 0) {
            return null;
        }

        Task<T> task = priorityQueue.poll();
        TaskHandler<T> assignedHandler = handlers.get(0);

        if (task instanceof TimedTask<T>) {
            for (int i = 1; i < handlers.size(); i++) {
                if (handlers.get(i).estimatedTime() < assignedHandler.estimatedTime()) {
                    assignedHandler = handlers.get(i);
                }
            }
        }
        else {
            for (int i = 1; i < handlers.size(); i++) {
                if (handlers.get(i).taskCount() < assignedHandler.taskCount()) {
                    assignedHandler = handlers.get(i);
                }
            }
        }

        assignedHandler.addTask(task);

        return assignedHandler;
    }

    // Gets the current count of tasks in the queue.
    public int taskCount() {
        return priorityQueue.count();
    }

    // Just checks the next task in the queue. Doesn't remove it.
    public Task<T> nextTask() {
        return priorityQueue.peek();
    }
}
