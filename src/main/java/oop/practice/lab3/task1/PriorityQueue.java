package oop.practice.lab3.task1;

// PriorityQueue.java
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private final java.util.PriorityQueue<T> pq = new java.util.PriorityQueue<>();

    @Override
    public void enqueue(T element) {
        pq.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return pq.poll();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return pq.peek();
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
