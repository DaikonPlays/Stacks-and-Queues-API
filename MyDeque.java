import java.util.Arrays;

/**
 * TODO: Add your file header
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * 
 * This file contains a MyDeque class, which implements Deque API
 * using arrays. It is also used to write stack and queue API.
 */

/**
 * This class implements the Deque API. It can add and remove elements.
 * Instance variables;
 * data, array of elements
 * size, number of elements
 * rear, last element
 * front, first element
 */
public class MyDeque<E> implements DequeInterface {
    Object[] data;
    int size;
    int rear;
    int front;
    /**
     * intializes data's size
     * @param initialCapacity size of data
     */
    public MyDeque(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        //sets data's capacity
        data = new Object[initialCapacity];
    }
    /**
     * returns the size of data
     * @return count is num of elements in data
     */
    public int size() {
        int count = 0;
        for(int i = 0; i < data.length; i++) {
            if(data[i] != null) {
                count++;
            }
        }
        return count;
    }
    /**
     * expands capacity of data by 2
     * if data length is 0, sets data to 10
     */
    public void expandCapacity() {
        //creates temp copy of data that is double length
        Object[] newdata = new Object[data.length * 2];
        if(newdata.length == 0) {
            newdata = new Object[10];
        }
        //deep copies data to newdata
        for(int i = 0; i < data.length; i++) { //[1, 2, 4]
            newdata[i] = data[(front + i) % data.length];
        }
        this.data = newdata.clone();
        front = 0;
        if(size == 0) {
            rear = 0;
        }
        else {
            rear = size - 1;
        }
    }
    /**
     * adds element to front and updates front and size
     * @param element to be added to front
     */
    public void addFirst(Object element) {
        if(element == null) {
            throw new NullPointerException();
        }        
        //expands capacity if needed
        if(size() == data.length) {
            expandCapacity();
        }
        //changes front if size > 0
        if(size > 0) {
            front = (front - 1 + data.length)%(data.length);
        }
        //sets the element at the new front
        data[front] = element;
        size++;
    }
    /**
     * adds element to rear and updates rear and size
     * @param element to be added
     */
    public void addLast(Object element) {
        if(element == null) {
            throw new NullPointerException();
        }  
        //expands capacity if needed      
        if(size() == data.length) {
            expandCapacity();
        }
        if(size() != 0) {
            //changes rear
            rear = (rear + 1 + data.length)%(data.length);
        }
        //sets the element at the new rear
        data[rear] = element;  
        size++;  
    }
    /**
     * removes the current front value
     * @return frontbefore front before removing
     */
    public E removeFirst() {
        if(size == 0) {
            return null;
        }
        //saves the old front element
        Object frontbefore = data[front];
        //removes current front
        data[front] = null;
        size--;
        //changes front element
        if(size != 0) {
            front = (front + 1) % data.length;
        }
        return (E) frontbefore;
    }
    /**
     * removes the rear value
     * @return rearbefore rear before removing
     */
    public E removeLast() {
        if(size == 0) {
            return null;
        }
        E rearbefore = (E) data[rear];
        data[rear] = null;
        if(rear == 0) {
            rear = data.length - 1;
        }
        else {
            rear = rear - 1;
        }
        //removes current rear
        size--;
        if(size == 0) {
            rear = front;
        }
        return rearbefore;
    }
    /**
     * returns the element at index front
     * @return frontele the front element 
     */
    public E peekFirst() {
        if(data.length == 0) {
            return null;
        }
        //saves front element
        E frontele = (E) data[front];
        return frontele;
    }
    /**
     * returns the element at index rear
     * @return rearele the front element 
     */
    public E peekLast() {
        if(data.length == 0) {
            return null;
        }
        //saves rear element
        E rearele = (E) data[rear];
        return rearele;
    }
    public int partition(Integer[] array, int low, int high) {
        int index = high - 1;
        int num = array[index];
        int smallerBefore = low;
        int largerAfter = high - 2;
        while (smallerBefore < largerAfter) {
            if (array[smallerBefore].compareTo(num) < 0) {
                smallerBefore += 1;
            } else {
                swap(array, smallerBefore, largerAfter);
                largerAfter -= 1;
            }
        }
        if (array[smallerBefore].compareTo(num) < 0) {
            swap(array, smallerBefore + 1, index);
            return smallerBefore + 1;
        } else {
            swap(array, smallerBefore, index);
            return smallerBefore;
        }
    }
    private void swap(Integer[] array, int smallerBefore, int largerAfter) {
    }
    
}