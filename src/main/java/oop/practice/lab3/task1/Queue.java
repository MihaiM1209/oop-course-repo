package oop.practice.lab3.task1;

// Queue.java
public interface Queue<T> {
    void enqueue(T element); // Adds an element to the queue
    T dequeue();             // Removes and returns the front element
    T peek();                // Returns the front element without removing it
    boolean isEmpty();       // Checks if the queue is empty
}
