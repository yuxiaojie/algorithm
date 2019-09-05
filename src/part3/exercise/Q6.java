package part3.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q6 {

    /**
     *
     * 时间复杂度应该是 n ^ 2
     *
     * 大循环时间复杂度为 n，链表remove 寻址时间复杂度为n
     *
     * @param m
     * @param n
     */
    public static void josephus(int m, int n) {
        long curr = System.currentTimeMillis();

        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            indexList.add(i);

        int i = 0;
//        System.out.print("remove: ");
        while (n > 0) {

            int rm = (i + m) % n;
            i = rm;
            n--;
            indexList.remove(rm);
//            System.out.print(indexList.remove(rm) + ", ");
        }
//        System.out.println();

        System.out.println("josephus spend: " + (System.currentTimeMillis() - curr) + " ms");
    }

    public static void josephus2(int m, int n) {

        long curr = System.currentTimeMillis();

        int i, j, mPrime, numLeft;
        ArrayList<Integer> l = new ArrayList<>();
        for (i = 1; i <= n; i++)
            l.add(i);

        ListIterator<Integer> iter = l.listIterator();
        int item = 0;

        numLeft = n;

//        System.out.print("remove: ");
        for (i = 0; i < n; i++) {

            mPrime = m % numLeft;
            if (mPrime <= numLeft/2) {
                if (iter.hasNext())
                    item = iter.next();

                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext())
                        iter = l.listIterator();
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft-mPrime; j++) {
                    if (!iter.hasPrevious())
                        iter = l.listIterator(l.size());
                    item = iter.previous();
                }
            }

//            System.out.print(item + ", ");
            iter.remove();
            if (!iter.hasNext())
                iter = l.listIterator();
            numLeft--;
        }
//        System.out.println();
        System.out.println("josephus2 spend: " + (System.currentTimeMillis() - curr) + " ms");
    }

    public static void main(String[] args) {

//        josephus(0, 5);
//        josephus(1, 5);
//        josephus(1, 10);
//        josephus(3, 10);
//
//
//        System.out.println(" --------------------------------------");
//        josephus(0, 5);
//        josephus2(1, 5);
//        josephus2(1, 10);
//        josephus2(3, 10);

        josephus(100, 500000);
        josephus2(100, 500000);
    }
}
