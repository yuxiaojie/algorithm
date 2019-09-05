package part3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount;
    private Node<AnyType> head;
    private Node<AnyType> tail;

    public MyLinkedList() {
        doClear();
    }

    private void doClear() {
        head = new Node<>(null);
        tail = new Node<>(null, head, null);
        theSize = 0;
    }

//    private Node<AnyType> getNode(int inx) {
//        if (inx >= theSize)
//            throw new NoSuchElementException();
//
//        int curr = 0;
//        Node<AnyType> find = head.next;
//        while (curr++ != inx)
//            find = find.next;
//
//        return find;
//    }

    private Node<AnyType> getNode(int inx) {
        return getNode(inx, 0, size());
    }

    private Node<AnyType> getNode(int inx, int lower, int upper) {

        Node<AnyType> p;

        if (inx < lower || inx > upper)
            throw new NoSuchElementException();

        if (inx < size() / 2) {
            p = head.next;
            for (int i = 0; i < inx; i++)
                p = p.next;
        } else {
            p = tail;
            for (int i = size(); i > inx; i--)
                p = p.prev;
        }

        return p;
    }

    public AnyType remove(int inx) {

        return remove(getNode(inx));
    }

    private AnyType remove(Node<AnyType> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.v;
    }

    public boolean add(AnyType v) {

        add(size(), v);
        return true;
    }

    public void add(int inx, AnyType v) {
        addBefore(getNode(inx), v);
    }

    private void addBefore(Node<AnyType> node, AnyType v) {

        Node<AnyType> newNode = new Node<>(v, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    public AnyType get(int inx) {

        Node<AnyType> node = getNode(inx);
        return node.v;
    }

    public void set(int inx, AnyType v) {

        Node<AnyType> node = getNode(inx);
        node.v = v;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public void print() {

        Node<AnyType> p = head.next;
        System.out.print("[");
        for (int i = 0; i < size(); i++) {
            System.out.print(p.v + ", ");
            p = p.next;
        }
        System.out.println("]");
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new Iterator<>() {

            Node<AnyType> curr = head.next;
            int lockMod = modCount;
            boolean okToRemove = false;

            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public AnyType next() {

                if (lockMod != modCount)
                    throw new ConcurrentModificationException();
                if (!hasNext())
                    throw new NoSuchElementException();

                curr = curr.next;
                okToRemove = true;
                return curr.prev.v;
            }

            @Override
            public void remove() {

                if (lockMod != modCount)
                    throw new ConcurrentModificationException();
                if (!okToRemove)
                    throw new IllegalStateException();

                MyLinkedList.this.remove(curr.prev);
                lockMod++;
                okToRemove = false;
            }
        };
    }

    public static class Node<AnyType> {
        public Node<AnyType> prev;
        public Node<AnyType> next;
        public AnyType v;

        public Node(AnyType v) {
            this(v, null, null);
        }

        public Node(AnyType v, Node<AnyType> prev, Node<AnyType> next) {
            this.v = v;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] argv) {

        MyLinkedList<Integer> a = new MyLinkedList<>();
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
            if (v == 4)
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
