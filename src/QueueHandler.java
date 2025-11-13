import java.util.LinkedList;

// This holds a priority queue and assign tasks to Task Handlers based on the priority of the queue at the moment.
// The task handler with the least tasks gets the task. In case of ties give it to whichever one was found first.
public class QueueHandler<T> {
    private PriorityQueue<T> priorityQueue = new PriorityQueue<>();

    public void addTask(Task<T> task) {
        priorityQueue.add(task);
    }

    // Given a list of available task handlers give the next task to whichever one is net and return that handler.
    // If no handlers are provided or the queue is empty return null.
    public TaskHandler<T> assignTask(LinkedList<TaskHandler<T>> handlers) {
        if (handlers.isEmpty() || priorityQueue.count() == 0) {
            return null;
        }

        TaskHandler<T> assignedHandler = handlers.get(0);

        for (int i = 1; i < handlers.size(); i++) {
            if (handlers.get(i).taskCount() < assignedHandler.taskCount()) {
                assignedHandler = handlers.get(i);
            }
        }

        assignedHandler.addTask(priorityQueue.poll());

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
