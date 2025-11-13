import java.util.LinkedList;

// More advanced priority queue. Negative priority is immediate. Zero priority is normal. Positive priority is sorted.
public class PriorityQueue <T> {
    private LinkedList<Task<T>> immediatePriority = new LinkedList<>();
    private LinkedList<Task<T>> regularPriority = new LinkedList<>();
    private LinkedList<Task<T>> lowPriority = new LinkedList<>();

    public PriorityQueue() {}

    // Add the task where appropriate.
    public void add(Task<T> task) {
        if (task.getPriority() < 0) {
            immediatePriority.addFirst(task);
        }
        else if (task.getPriority() == 0) {
            regularPriority.addLast(task);
        }
        else {
            if (lowPriority.isEmpty()) {
                lowPriority.addFirst(task);
                return;
            }

            for (int i = 0; i < lowPriority.size(); i++) {
                if (lowPriority.get(i).getPriority() > task.getPriority()) {
                    lowPriority.add(i, task);
                    return;
                }
            }

            lowPriority.addLast(task);
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
        else if (!lowPriority.isEmpty()) {
            return lowPriority.getFirst();
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
            return  regularPriority.poll();
        }
        else if (!lowPriority.isEmpty()) {
            return lowPriority.poll();
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

        for (int i = 0; i < lowPriority.size(); i++) {
            if (lowPriority.get(i).getTask().equals(task)) {
                return lowPriority.get(i);
            }
        }

        return null;
    }

    // Total count of tasks.
    public int count() {
        return immediatePriority.size() + regularPriority.size() + lowPriority.size();
    }
}
