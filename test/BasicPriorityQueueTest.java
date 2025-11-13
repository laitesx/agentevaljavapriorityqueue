import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BasicPriorityQueueTest {

    @Test
    public void testBasics() {
        BasicPriorityQueue<String> basicQueue = new BasicPriorityQueue<>();

        assertEquals(0, basicQueue.count());

        assertNull(basicQueue.peek());
        assertNull(basicQueue.poll());

        basicQueue.add(new Task<>(0, "Zero Priority"));

        assertEquals(1, basicQueue.count());

        assertEquals("Zero Priority", basicQueue.peek().getTask());

        basicQueue.add(new Task<>(-1, "Negative One Priority"));

        assertEquals(2, basicQueue.count());

        assertEquals("Negative One Priority", basicQueue.peek().getTask());
        assertEquals("Negative One Priority", basicQueue.poll().getTask());

        assertEquals(1, basicQueue.count());

        assertEquals("Zero Priority", basicQueue.poll().getTask());

        assertEquals(0, basicQueue.count());
    }

    @Test
    public void testPriority() {
        BasicPriorityQueue<String> basicQueue = new BasicPriorityQueue<>();

        basicQueue.add(new Task<>(0, "Zero Priority A"));
        basicQueue.add(new Task<>(-2, "Negative Two Priority"));
        basicQueue.add(new Task<>(0, "Zero Priority B"));
        basicQueue.add(new Task<>(2, "Two Priority"));
        basicQueue.add(new Task<>(0, "Zero Priority C"));
        basicQueue.add(new Task<>(-1, "Negative One Priority"));

        assertEquals("Negative One Priority", basicQueue.poll().getTask());
        assertEquals("Negative Two Priority", basicQueue.poll().getTask());
        assertEquals("Zero Priority A", basicQueue.poll().getTask());
        assertEquals("Zero Priority B", basicQueue.poll().getTask());
        assertEquals("Two Priority", basicQueue.poll().getTask());
        assertEquals("Zero Priority C", basicQueue.poll().getTask());
        assertNull(basicQueue.poll());
    }

    @Test
    public void testFind() {
        BasicPriorityQueue<String> basicQueue = new BasicPriorityQueue<>();

        Task<String> zeroPriorityB = new Task<>(0, "Zero Priority B");

        basicQueue.add(new Task<>(0, "Zero Priority A"));
        basicQueue.add(new Task<>(-2, "Negative Two Priority"));
        basicQueue.add(zeroPriorityB);
        basicQueue.add(new Task<>(2, "Two Priority"));
        basicQueue.add(new Task<>(0, "Zero Priority C"));
        basicQueue.add(new Task<>(-1, "Negative One Priority"));

        Task<String> searchedTask = basicQueue.find("Zero Priority B");

        assertEquals(zeroPriorityB, searchedTask);
    }
}
