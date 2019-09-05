package part3;

import org.w3c.dom.ranges.RangeException;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class CycleArrayQueue<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theArray;
    private int max;

    private int front = 1;
    private int back = 0;

    public CycleArrayQueue(int max) {

        if (max <= 0)
            throw new IndexOutOfBoundsException();

        this.max = max;
        theArray = (AnyType[]) new Object[max];
    }

    public CycleArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public AnyType dequeue() {
        if (theSize == 0)
            throw new EmptyStackException();

        AnyType find = theArray[front];
        front = (front + 1) % max;
        theSize--;
        return find;
    }

    public void enqueue(AnyType x) {
        if (theSize == max - 1)
            throw new NoSuchElementException();

        back = (back + 1) % max;
        theArray[back] = x;
        theSize++;
    }

    public static void main(String[] args) {

        CycleArrayQueue q = new CycleArrayQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("dequeue: " + q.dequeue());
        System.out.println("dequeue: " + q.dequeue());
        q.enqueue(4);
        q.enqueue(5);
        System.out.println("dequeue: " + q.dequeue());
        q.enqueue(6);
        System.out.println("dequeue: " + q.dequeue());
        System.out.println("dequeue: " + q.dequeue());
        System.out.println("dequeue: " + q.dequeue());
    }
}
