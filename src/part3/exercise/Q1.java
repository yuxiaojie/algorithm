package part3.exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Q1 {

    public static void printLots(List<Integer> l, List<Integer> p) {

        for (int i : p)
            if (i >= l.size())
                throw new NoSuchElementException();

        int indexL = 0;
        Iterator<Integer> iterL = l.iterator();
        Iterator<Integer> iterP = p.iterator();

        while (iterP.hasNext()) {

            int find = iterP.next();
            int findV = -1;

            while (iterL.hasNext() && indexL <= find) {
                indexL++;
                findV = iterL.next();
            }

            System.out.print(findV + ", ");
        }
    }

    public static void main(String[] args) {
        printLots(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), Arrays.asList(2, 4, 6, 8));
    }
}
