package MCexamples.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue<T> {
    private Queue<T> queue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait until the queue has space available
        }
        queue.add(item);
        notifyAll(); // Notify any waiting consumers that an item is available
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until the queue has an item available
        }
        T item = queue.poll();
        notifyAll(); // Notify any waiting producers that space is available
        return item;
    }
}

