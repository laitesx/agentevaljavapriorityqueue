import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueueHandlerTest {

    @Test
    public void testQueueHandler() {
        TaskHandler<String> handlerZero = new TaskHandler<>("Handler Zero", "handlerzero@example.com");
        TaskHandler<String> handlerOne = new TaskHandler<>("Handler One", "handlerone@example.com");

        LinkedList<TaskHandler<String>> handlers = new LinkedList<>();

        handlers.add(handlerZero);
        handlers.add(handlerOne);

        QueueHandler<String> queueHandler = new QueueHandler<>();

        assertEquals(0, queueHandler.taskCount());
        assertNull(queueHandler.assignTask(handlers));

        Task<String> taskZero = new Task<>(0, "Task Zero");
        Task<String> taskOne = new Task<>(1, "Task One");
        Task<String> taskNegativeOne = new Task<>(-1, "Task Negative One");

        queueHandler.addTask(taskZero);
        queueHandler.addTask(taskOne);
        queueHandler.addTask(taskNegativeOne);

        assertEquals(3, queueHandler.taskCount());

        assertNull(queueHandler.assignTask(new LinkedList<>()));

        assertEquals(3, queueHandler.taskCount());

        assertEquals(handlerZero, queueHandler.assignTask(handlers));
        assertEquals(2, queueHandler.taskCount());
        assertEquals(handlerOne, queueHandler.assignTask(handlers));
        assertEquals(1, queueHandler.taskCount());
        assertEquals(handlerZero, queueHandler.assignTask(handlers));
        assertEquals(0, queueHandler.taskCount());

        assertEquals(2, handlerZero.taskCount());
        assertEquals(1, handlerOne.taskCount());

        assertEquals(taskNegativeOne, handlerZero.finishTask());
        assertEquals(1, handlerZero.taskCount());
        assertEquals(taskOne, handlerZero.finishTask());
        assertEquals(0, handlerZero.taskCount());

        assertEquals(taskZero, handlerOne.finishTask());
        assertEquals(0, handlerOne.taskCount());
    }
}
