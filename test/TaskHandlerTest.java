import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskHandlerTest {

    @Test
    public void testTaskHandler() {
        TaskHandler<String> testHandler = new TaskHandler<>("Test Man", "testman@example.com");

        assertEquals(0, testHandler.taskCount());

        testHandler.addTask(new Task<>(1, "First Task"));
        assertEquals(1, testHandler.taskCount());
        assertEquals(0, testHandler.estimatedTime());

        testHandler.addTask(new Task<>(2, "Second Task"));
        assertEquals(2, testHandler.taskCount());
        assertEquals(0, testHandler.estimatedTime());

        assertEquals("First Task", testHandler.nextTask().getTask());

        assertEquals("First Task", testHandler.finishTask().getTask());
        assertEquals("Second Task", testHandler.finishTask().getTask());

        assertNull(testHandler.finishTask());

        testHandler.addTask(new TimedTask<>(1, "Third Task", 10));
        assertEquals(1, testHandler.taskCount());
        assertEquals(10, testHandler.estimatedTime());

        testHandler.addTask(new TimedTask<>(2, "Fourth Task", 20));
        assertEquals(2, testHandler.taskCount());
        assertEquals(30, testHandler.estimatedTime());

        assertEquals("Third Task", testHandler.finishTask().getTask());
        assertEquals(1, testHandler.taskCount());
        assertEquals(20, testHandler.estimatedTime());

        assertEquals("Fourth Task", testHandler.finishTask().getTask());
        assertEquals(0, testHandler.taskCount());
        assertEquals(0, testHandler.estimatedTime());
    }
}
