package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * Class to test all methods within the ArrayQueue<T> class
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.10.27
 *
 */

public class ArrayQueueTest extends TestCase {
    
    private ArrayQueue<Person> aq1;
    private ArrayQueue<Person> aq2;
    private ArrayQueue<Person> aq3;
    private Person p1;
    private Person p4;
    private Person p2;
    private Person p3;
    
    /**
     * Sets up
     */
    public void setUp() {
        aq1 = new ArrayQueue<Person>();
        aq2 = new ArrayQueue<Person>();
        aq3 = new ArrayQueue<Person>();
        p1 = new Person("Dave", 1, 2, 3, "Jupiter");
        p2 = new Person("David", 1, 5, 9, "Mars");
        p3 = new Person("Bob", 4, 8, 10, ""); 
        p4 = new Person("Bobby", 8, 7, 6, "");
        aq1.enqueue(p1);
        aq1.enqueue(p2);
        aq1.enqueue(p3);
        aq1.enqueue(p4);
        aq2.enqueue(p1);
        aq2.enqueue(p2);
        aq2.enqueue(p3);
        aq2.enqueue(p4);
        aq3.enqueue(p4);
        aq3.enqueue(p3);
        aq3.enqueue(p2);
        aq3.enqueue(p1);
    }
    /**
     * Tests getLengthOfUnderlyingArray
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(aq1.getLengthOfUnderlyingArray(), 21);
        assertEquals(aq2.getLengthOfUnderlyingArray(), 21);
        assertEquals(aq3.getLengthOfUnderlyingArray(), 21);
        ArrayQueue<Person> tUnder = new ArrayQueue<Person>(100);
        assertEquals(tUnder.getLengthOfUnderlyingArray(), 101);
    }
    /**
     * Tests getSize 
     */
    public void testGetSize() {
        assertEquals(aq1.getSize(), 4);
        assertEquals(aq2.getSize(), 4);
        assertEquals(aq3.getSize(), 4);
        aq3 = new ArrayQueue<Person>();
        assertEquals(aq3.getSize(), 0);
    }
    /**
     * Tests clear
     */
    public void testClear() {
        aq1.clear();
        assertEquals(aq1.getSize(), 0);
        assertTrue(aq1.isEmpty());
    }
    /**
     * Tests dequeue 
     */
    public void testDequeue() {
        aq1.dequeue();
        assertEquals(aq1.getSize(), 3);
    }
   /**
    * Tests enqueue
    */
    public void testEnqueue() {
        Person p5 = new Person("Fav", 8, 7, 9, "");
        aq1.enqueue(p5);
        assertEquals(aq1.getSize(), 5);
    }
    /**
     * Tests getFront
     */
    public void testGetFront() {
        assertEquals(aq1.getFront(), p1);
        assertEquals(aq3.getFront(), p4);
        aq1.dequeue();
        assertEquals(aq1.getFront(), p2);
        aq3.dequeue();
        assertEquals(aq3.getFront(), p3);
        aq2 = new ArrayQueue<Person>();
        Exception e = null;
        try {
            aq2.dequeue();
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);
    }
    /**
     * Tests isEmpty
     */
    public void testIsEmpty() {
        assertFalse(aq1.isEmpty());
        assertFalse(aq3.isEmpty());
        aq2 = new ArrayQueue<Person>();
        assertTrue(aq2.isEmpty());
    }
    /**
     * Tests isFull
     */
    public void testEnsureCapacity() {
        for (int i = 0; i < 16; i++) {
            aq1.enqueue(p1);
        }
        aq1.enqueue(p3);
        assertEquals(aq1.getSize(), 21);
        assertEquals(aq1.getLengthOfUnderlyingArray(), 41);
    }
    /**
     * Tests toArray
     */
    public void testToArray() {
        aq2 = new ArrayQueue<Person>();
        Exception e = null;
        try {
            aq2.toArray();
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof EmptyQueueException);
        aq2.enqueue(p1);
        aq2.enqueue(p3);
        Object[] arr = new Object[2];
        Object[] arr2;
        arr[0] = p1;
        arr[1] = p3;
        arr2 = aq2.toArray();
        assertEquals(arr[0], arr2[0]);
        assertEquals(arr[1], arr2[1]);   
    }
    /**
     * Tests toString
     */
    public void testToString() {
        aq1 = new ArrayQueue<Person>();
        assertEquals(aq1.toString(), "[]");
        aq1.enqueue(p1);
        aq1.enqueue(p3);
        assertEquals(aq1.toString(), 
            "[Dave A:1 M:2 T:3 Wants: Jupiter, No-Planet Bob A:4 M:8 T:10]");
        assertEquals(aq1.getSize(), 2);
        assertEquals(aq1.dequeue(), p1);
        p1 = null;
        aq1.enqueue(p1);
        assertEquals(aq1.toString(), "[No-Planet Bob A:4 M:8 T:10, null]");
    }
    /**
     * Tests equals
     */
    public void testEquals() {
        assertFalse(aq1.equals(null));
        assertFalse(aq1.equals("Do"));
        assertTrue(aq1.equals(aq1));
        assertTrue(aq1.equals(aq2));
        assertFalse(aq1.equals(aq3));
        aq3 = new ArrayQueue<Person>();
        assertFalse(aq1.equals(aq3));
    }
}
