package part2;

import utils.ComparableInt;

public class BinarySearch {

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {

        int low = 0, high = a.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0)
                low = mid + 1;
            else if (a[mid].compareTo(x) > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        ComparableInt[] a = {new ComparableInt(-3), new ComparableInt(-2), new ComparableInt(-1),
                new ComparableInt(3), new ComparableInt(4), new ComparableInt(9)};
        System.out.println(binarySearch(a, new ComparableInt(9)));
    }
}
