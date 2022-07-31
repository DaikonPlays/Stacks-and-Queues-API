/**
 * TODO: Add your file header
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * 
 * Custom tests for MyDeque, MyStack, MyQueue. These
 * are designed to test edge cases.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Contains all the tests for edge cases. Tests cases for 
 * all methods in MyDeque, but one for MyStack and MyQueue
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    /**
     * Initializes Deque
     * @param deque to initialize
     * @param data array of elements
     * @param size num of elements
     * @param front index of front
     * @param rear index of rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size, 
    int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initialCapacity is negative
     */
    @Test
    public void testMyDequeConstructor() {
        boolean test = false;
        try{
        MyDeque<Integer> deque = new MyDeque<>(-5);
        }
        catch(Exception e){
            test = true;
        }
        assertTrue(test);
    }

    /**
     * Test the expandCapacity method when capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        MyDeque<Integer> deque1 = new MyDeque<>(3);
        Integer[] first = { 1, 2, 4};
        initDeque(deque1, first, 3, 2, 1);
        // deque.expandCapacity();
        deque1.expandCapacity();
        for(int i = 0; i < deque1.data.length; i++) {
            System.out.println(deque1.data[i]);
        }
        // assertEquals("Checks the capacity", 10, deque.data.length);
    }

    /**
     * Test the addFirst method when deque is at capacity
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] first = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] last = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null, null, null, null, null, 11};
        initDeque(deque, first, 10, 0, 10);
        deque.addFirst(11);
        for(int i = 0; i < deque.data.length; i++){
            assertEquals("checks the new deque", last[i], deque.data[i]);
        }        
    }

    /**
     * Test the addLast method when deque is at capacity
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] first = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] last = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null, null, null, null, null, null, null, null};
        initDeque(deque, first, 10, 0, 9);
        deque.addLast(11);
        for(int i = 0; i < deque.data.length; i++){
            assertEquals("checks the new deque", last[i], deque.data[i]);
        }  
    }

    /**
     * Test the removeFirst method when deque is empty
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        assertEquals("checks if null", null, deque.removeFirst());
    }

    /**
     * Test the removeLast method when deque is empty
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        assertEquals("checks if null", null, deque.removeLast());
    }

    /**
     * Test the peekFirst method when deque is empty
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        assertEquals("checks if null", null, deque.peekFirst());
    }

    /**
     * Test the peekLast method when deque is empty
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        assertEquals("checks if null", null, deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack push when stack is full
     */
    @Test
    public void testMyStack(){
        MyStack<Integer> newstack = new MyStack<>(10);
        Integer[] first = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] last = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null, null, null, null, null, 11};
        initDeque(newstack.theStack, first, 10, 0, 9);
        newstack.push(11);
        for(int i = 0; i < newstack.theStack.data.length; i++){
            assertEquals("checks the new deque", last[i], newstack.theStack.data[i]);
        }  
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue enqueue when queue is full
     */
    @Test
    public void testMyQueue(){
        MyQueue<Integer> newqueue = new MyQueue(10);
        Integer[] first = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] last = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, null, null, null, null, null, null, null, 11};
        initDeque(newqueue.theQueue, first, 10, 0, 9);    
        newqueue.enqueue(11);
        for(int i = 0; i < newqueue.theQueue.data.length; i++){
            assertEquals("checks the new deque", last[i], newqueue.theQueue.data[i]);
        }  
    }
}
