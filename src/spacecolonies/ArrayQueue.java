package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Implementation of the ArrayQueue data structure,
 * which will act be used to hold Person objects
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @param <T> 
 * 
 * @version 2022.10.27
 *
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    
    private T [] queue;
    /**
     * Constant capacity
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    
    /**
     * Default Constructor for ArrayQueue
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    /**
     * Constructor with a single parameter
     * 
     * @param initialCapacity 
     * Determines underlying Array Size for queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity + 1];
        dequeueIndex = 0; //front index//
        enqueueIndex = queue.length - 1; //backindex//
        size = 0;
    }
    
    /**
     * Used to get length of Array(queue)
     * 
     * @return length of queue
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }
    /**
     * Getter method for size
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }
    /**
     * Method to rid all objects out of the ArrayQueue
     * simply dequeue all items until empty
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            this.dequeue();
        }
    }
    /**
     * Method to take an item off the the queue
     * operates on the idea that the ArrayQueue is 
     * first in first out
     */
    @Override
    public T dequeue() {
        T holder = this.getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return holder;
    }
    /**
     * Method to add an item to the queue
     * specifically to the back of the queue
     */
    @Override
    public void enqueue(T item) {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = item;
        size++;
    }
    /**
     * Method to get the item 
     * that is at the frontIndex of the
     * ArrayQueue, essentially a dequeue
     * but it doesn't remove the object
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return queue[dequeueIndex];
        }
    }
    /**
     * Method to see if the ArrayQueue is empty
     * 
     * @return true if Empty
     * false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (((enqueueIndex + 1) % queue.length) == dequeueIndex);
    }
    /**
     * Method to see if the ArrayQueue is full
     * 
     * @return true if Full
     * false otherwise
     */
    private boolean isFull() { 
        return ((enqueueIndex + 2) % queue.length == dequeueIndex);
    }
    
    /**
     * Method to check whether the ArrayQueue if full
     * and expand the "capacity" to allow for more items to be enqueued
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize - 1;
            queue = (T[]) new Object[newSize];
            int j = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[j];
                j = (j + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }
    }
    /**
     * Method to convert items within
     * the ArrayQueue to an object array
     * 
     * @return Array of Objects that was in the 
     * ArrayQueue
     */
    public Object[] toArray() { 
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            Object [] arr = new Object[size];
            for (int i = 0; i < size; i++) {
                arr[i] = queue[(dequeueIndex + i) % queue.length];
            }
            return arr;
        }
    }
    /**
     * Method to convert items within the 
     * ArrayQueue to a string statement
     * 
     * @return String of objects within
     * the ArrayQueue
     */
    public String toString() { //Implement these//
        if (isEmpty()) {
            return "[]";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                String input = null;
                T holder = queue[(dequeueIndex + i) % queue.length];
                if (holder != null) {
                    input = holder.toString();
                }
                sb.append(input);
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
    /**
     * Method to compare two ArrayQueue
     * objects for equality
     * 
     * Equal if they contain the same contents
     * 
     * @return true if they are equal
     * false otherwise
     * 
     */
    @Override
    public boolean equals(Object obj) { //Implement these//
        if (obj == null) {
            return false;
        }
        else if (obj == this) {
            return true;
        }
        else if (obj.getClass() == this.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> o = (ArrayQueue<T>)obj;
            if (o.getSize() != this.getSize()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                T myElement = queue[(dequeueIndex + i) % queue.length];
                T otherElement = o.queue[(o.dequeueIndex + i) % o.queue.length];
                if (!(myElement.equals(otherElement))) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }  
}
