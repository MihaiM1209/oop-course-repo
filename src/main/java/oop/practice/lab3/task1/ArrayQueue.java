package oop.practice.lab3.task1;

// ArrayQueue.java
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] elements;
    private int size = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) throw new IllegalStateException("Queue is full");
        elements[size++] = element;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T front = elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        return front;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return elements[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
