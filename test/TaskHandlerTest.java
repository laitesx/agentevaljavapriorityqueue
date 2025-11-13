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

        testHandler.addTask(new Task<>(2, "Second Task"));
        assertEquals(2, testHandler.taskCount());

        assertEquals("First Task", testHandler.nextTask().getTask());

        assertEquals("First Task", testHandler.finishTask().getTask());
        assertEquals("Second Task", testHandler.finishTask().getTask());

        assertNull(testHandler.finishTask());
    }
}
