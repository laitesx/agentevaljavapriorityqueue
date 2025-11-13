import java.util.LinkedList;

// Simple priority queue. Anything with a negative priority is to be done first no matter what. No sorting.
// Negative goes to the front of the queue. Everything else is queued normally.
public class BasicPriorityQueue<T> {
    private LinkedList<Task<T>> immediatePriority = new LinkedList<>();
    private LinkedList<Task<T>> regularPriority = new LinkedList<>();

    public BasicPriorityQueue() { }

    // Negative priority goes first. Everything else is normal.
    public void add(Task<T> task) {
        if (task.getPriority() < 0) {
            immediatePriority.addFirst(task);
        }
        else {
            regularPriority.addLast(task);
        }
    }

    // Just show the first task.
    public Task<T> peek() {
        if (!immediatePriority.isEmpty()) {
            return immediatePriority.getFirst();
        }
        else if (!regularPriority.isEmpty()) {
            return  regularPriority.getFirst();
        }
        else {
            return null;
        }
    }

    // Remove the first task and return it.
    public Task<T> poll() {
        if (!immediatePriority.isEmpty()) {
            return immediatePriority.poll();
        }
        else if (!regularPriority.isEmpty()) {
            return regularPriority.poll();
        }
        else {
            return null;
        }
    }

    // Finds the first task that matches the given information.
    public Task<T> find(T task) {
        for (int i = 0; i < immediatePriority.size(); i++) {
            if (immediatePriority.get(i).getTask().equals(task)) {
                return immediatePriority.get(i);
            }
        }

        for (int i = 0; i < regularPriority.size(); i++) {
            if (regularPriority.get(i).getTask().equals(task)) {
                return regularPriority.get(i);
            }
        }

        return null;
    }

    // Total count of tasks.
    public int count() {
        return immediatePriority.size() + regularPriority.size();
    }
}
