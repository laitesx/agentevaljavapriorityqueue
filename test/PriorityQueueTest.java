import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PriorityQueueTest {
    @Test
    public void testBasics() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        assertEquals(0, priorityQueue.count());

        assertNull(priorityQueue.peek());
        assertNull(priorityQueue.poll());

        priorityQueue.add(new Task<>(0, "Zero Priority"));

        assertEquals(1, priorityQueue.count());

        assertEquals("Zero Priority", priorityQueue.peek().getTask());

        priorityQueue.add(new Task<>(-1, "Negative One Priority"));

        assertEquals(2, priorityQueue.count());

        assertEquals("Negative One Priority", priorityQueue.peek().getTask());

        priorityQueue.add(new Task<>(2, "Positive Two Priority"));

        assertEquals(3, priorityQueue.count());

        assertEquals("Negative One Priority", priorityQueue.peek().getTask());
        assertEquals("Negative One Priority", priorityQueue.poll().getTask());

        assertEquals(2, priorityQueue.count());

        assertEquals("Zero Priority", priorityQueue.peek().getTask());
        assertEquals("Zero Priority", priorityQueue.poll().getTask());

        assertEquals(1, priorityQueue.count());

        assertEquals("Positive Two Priority", priorityQueue.peek().getTask());
        assertEquals("Positive Two Priority", priorityQueue.poll().getTask());

        assertEquals(0, priorityQueue.count());
    }

    @Test
    public void testPriority() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Task<>(0, "Zero Priority A"));
        priorityQueue.add(new Task<>(-2, "Negative Two Priority"));
        priorityQueue.add(new Task<>(0, "Zero Priority B"));
        priorityQueue.add(new Task<>(2, "Two Priority"));
        priorityQueue.add(new Task<>(0, "Zero Priority C"));
        priorityQueue.add(new Task<>(-1, "Negative One Priority"));
        priorityQueue.add(new Task<>(5, "Five Priority"));
        priorityQueue.add(new Task<>(3, "Three Priority"));

        assertEquals("Negative One Priority", priorityQueue.poll().getTask());
        assertEquals("Negative Two Priority", priorityQueue.poll().getTask());
        assertEquals("Zero Priority A", priorityQueue.poll().getTask());
        assertEquals("Zero Priority B", priorityQueue.poll().getTask());
        assertEquals("Zero Priority C", priorityQueue.poll().getTask());
        assertEquals("Two Priority", priorityQueue.poll().getTask());
        assertEquals("Three Priority", priorityQueue.poll().getTask());
        assertEquals("Five Priority", priorityQueue.poll().getTask());
        assertNull(priorityQueue.poll());
    }

    @Test
    public void testFind() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        Task<String> twoPriority = new Task<>(2, "Two Priority");

        priorityQueue.add(new Task<>(0, "Zero Priority A"));
        priorityQueue.add(new Task<>(-2, "Negative Two Priority"));
        priorityQueue.add(new Task<>(0, "Zero Priority B"));
        priorityQueue.add(twoPriority);
        priorityQueue.add(new Task<>(0, "Zero Priority C"));
        priorityQueue.add(new Task<>(-1, "Negative One Priority"));
        priorityQueue.add(new Task<>(5, "Five Priority"));
        priorityQueue.add(new Task<>(3, "Three Priority"));

        Task<String> searchedTask = priorityQueue.find("Two Priority");

        assertEquals(twoPriority, searchedTask);
    }
}
