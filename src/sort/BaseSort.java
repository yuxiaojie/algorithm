package sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BaseSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
//        show(a);
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))  {
                System.out.println("[" + (i - 1) + ":" + i + "] is not sorted");
                return false;
            }
        return true;
    }

    private static Comparable[] genRandomArray(int len) {

        int max = len * 10;
        Comparable[] a = new Comparable[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            a[i] = rand.nextInt(max);
        }
        return a;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     *
     * 选择排序
     *
     *      运行时间与输入无关
     *      数据移动最小，只进行 N 次交换
     *
     * @param a
     * @return
     */
    public static Comparable[] selectionSort(Comparable[] a) {

        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++)
                if (!less(a[min], a[j]))
                    min = j;
            if (min != i)
                exch(a, i, min);
        }

        return a;
    }

    /**
     *
     * 插入排序
     *
     *  依赖原有次序，平均需要 N * N / 4 次比较与交换，最好情况下需要 N - 1 次比较和 0 次交换
     *
     * @param a
     * @return
     */
    public static Comparable[] insertionSort(Comparable[] a) {

        int len = a.length;
        for (int i = 1; i < len; i++)
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        return a;
    }

    /**
     *
     * 插入排序
     *
     *  每次比较后都向右移动而不是每次都交换，数据访问次数减半
     *
     * @param a
     * @return
     */
    public static Comparable[] insertionSort2(Comparable[] a) {

        int len = a.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            Comparable min = a[j];
            for (; j > 0 && less(min, a[j-1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = min;
        }
        return a;
    }

    /**
     *
     * 希尔排序
     *
     *      可用于大型数组，任意序列(不一定是随机的)的数组表现也很好
     *
     * @param a
     * @return
     */
    public static Comparable[] shellSort(Comparable[] a) {

        int len = a.length;
        int h = 1;
        while (h < len / 3)
            h = 3 * h + 1;      //   1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            for (int i = h; i < len; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j - h);
            h /= 3;
        }
        return a;
    }

    public static Comparable[] mergeSort(Comparable[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    private static Comparable[] mergeSort(Comparable[] a, int left, int right) {
        if (left == right)
            return new Comparable[] { a[left] };

        int mid = (left + right) / 2;
        Comparable[] leftArr = mergeSort(a, left, mid);
        Comparable[] rightArr = mergeSort(a, mid + 1, right);

        int lp = 0, rp = 0, i = 0;
        Comparable[] result = new Comparable[leftArr.length + rightArr.length];
        while (lp < leftArr.length && rp < rightArr.length)
            result[i++] = leftArr[lp].compareTo(rightArr[rp]) < 0 ? leftArr[lp++] : rightArr[rp++];

        while (lp < leftArr.length)
            result[i++] = leftArr[lp++];
        while (rp < rightArr.length)
            result[i++] = rightArr[rp++];

        for (int j = 0; j < result.length; j++) {
            a[j + left] = result[j];
        }
        return result;
    }

    @FunctionalInterface
    interface TestSpend {
        void sort(Comparable[] a);
    }

    private static void testSpend(TestSpend sorter) {
        testSpend(sorter, 10000);
    }

    private static void testSpend(TestSpend sorter, int numSize) {

        int testCount = 10;
        long sum = 0;
        for (int i = 0; i < testCount; i++) {
            Comparable[] data = genRandomArray(numSize);
            long start = System.currentTimeMillis();
            sorter.sort(data);
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("Sorting " + numSize + " elements takes " + (sum / testCount) + " ms");
    }

    public static void quickSort(Comparable[] a) {

        if (a == null || a.length == 0)
            return;

        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Comparable[] a, int left, int right) {

        if (left < right) {
            int base = (left + right) / 2;
            exch(a, base, right);

            int i = left, j = right - 1;
            while (true) {
                while (i <= j && a[i].compareTo(a[right]) < 0) i++;
                while (i <= j && a[j].compareTo(a[right]) > 0) j--;
                if (i < j) exch(a, i, j);
                else break;
            }

            exch(a, i, right);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        } else {
            insertionSort(a, left, right);
        }

    }

    private static void insertionSort(Comparable[] a, int left, int right) {

        for (int i = left + 1, j = 0; i <= right; i++) {
            Comparable tmp = a[i];
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--)  a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
    public static void main(String[] argv) {

        Comparable[] data = genRandomArray(60);
        show(data);

//        selectionSort(data);        //  5w 9353 ms
//        insertionSort(data);        //  10w 8369 ms
//        insertionSort2(data);     // 10w  4756 ms
//        shellSort(data);            // 10w  26 ms
        quickSort(data);            // 10w  26 ms

        show(data);
        System.out.println("is sorted : " + BaseSort.isSorted(data));

//        testSpend(BaseSort::shellSort, 10000);

    }
}
