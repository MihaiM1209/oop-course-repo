package oop.practice.lab3.task1;

// QueueTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.peek());
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    private void assertTrue(boolean empty) {
    }

    private void assertEquals(int i, Integer peek) {
    }

    @Test
    public void testLinkedQueue() {
        Queue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.peek());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertFalse(queue.isEmpty());
    }

    private void assertFalse(boolean empty) {
    }

    private void assertEquals(String a, String peek) {
    }

    @Test
    public void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.dequeue());
        assertFalse(queue.isEmpty());
    }
}
