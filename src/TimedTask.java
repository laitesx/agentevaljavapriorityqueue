public class TimedTask<T> extends Task<T> {
    private int estimatedMinutes;

    public TimedTask(Integer priority, T task, int estimatedMinutes) {
        super(priority, task);

        this.estimatedMinutes = estimatedMinutes;
    }

    public int getEstimatedMinutes() { return estimatedMinutes; }
}
