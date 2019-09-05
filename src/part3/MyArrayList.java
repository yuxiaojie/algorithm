package part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 5;

    private int theSize;
    private AnyType[] theItems;

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public MyArrayList() {
        doClear();
    }

    private void ensureCapacity(int newCapacity) {

        if (newCapacity < theSize)
            return;

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];

        if (old == null)
            return;

        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public void remove(int inx) {
        if (inx < 0 || inx >= theSize)
            throw new IndexOutOfBoundsException();

        for (int i = inx; i < theSize; i++) {
            theItems[i] = theItems[i+1];
        }
        theSize--;
    }

    public void add(AnyType v) {
        add(theSize, v);
    }

    public void add(int inx, AnyType v) {

        if (inx < 0 || inx > theSize)
            throw new IndexOutOfBoundsException();

        if (theSize >= theItems.length)
            ensureCapacity(theItems.length * 2);

        for (int i = theSize - 1; i >= inx; i--) {
            theItems[i+1] = theItems[i];
        }
        theItems[inx] = v;
        theSize++;
    }

    public AnyType get(int inx) {
        if (inx < 0 || inx >= theSize)
            throw new IndexOutOfBoundsException();
        return theItems[inx];
    }

    public void set(int inx, AnyType v) {
        if (inx < 0 || inx >= theSize)
            throw new IndexOutOfBoundsException();
        theItems[inx] = v;
    }

    public void trimToSize() {
        ensureCapacity(theSize);
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public int size() {
        return theSize;
    }

    public void clear() {
        doClear();
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < theSize; i++)
            System.out.print(theItems[i] + ", ");
        System.out.println("]");
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new Iterator<>() {

            int inx = 0;

            @Override
            public boolean hasNext() {
                return inx < size();
            }

            @Override
            public AnyType next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return theItems[inx++];
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(--inx);
            }
        };
    }

    public static void main(String[] argv) {

        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.print();
        a.set(1, 1000);
        System.out.print("set value 1000 with index 1: ");
        a.print();
        System.out.println("get value with index 1: " + a.get(1));
        a.remove(2);
        a.remove(1);
        a.print();
        a.add(1, 3);
        a.add(1, 2);
        System.out.print("add with index: ");
        a.print();

        Iterator<Integer> it = a.iterator();
        while (it.hasNext()) {
            int v = it.next();
            if (v == 5)
                it.remove();
            else
                System.out.print(v + ", ");
        }

        a.clear();
        System.out.print("do clear: ");
        a.print();
        System.out.println("is empty: " + a.isEmpty());

    }
}
