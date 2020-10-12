package sort;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IntegerSort {

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i-1])  {
                System.out.println("[" + (i - 1) + ":" + i + "] is not sorted");
                return false;
            }
        return true;
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static int[] genRandomArray(int len) {

        int max = len * 10;
        int[] a = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            a[i] = rand.nextInt(max);
        }
        return a;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] SelectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr, i, min);
        }
        return arr;
    }

    public static int[] InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--)
                swap(arr, j - 1, j);
        return arr;
    }

    public static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1; j++)
                if (arr[j + 1] < arr[j])
                    swap(arr, j, j + 1);
        return arr;
    }

    public static int[] QuickSort(int[] arr) {
        return QuickSort(arr, 0, arr.length - 1);
    }

    private static int[] QuickSort(int[] arr, int left, int right) {

        if (left >= right)
            return arr;

        int l = left + 1, r = right;
        int base = arr[left];

        while (true) {
            while (l <= r && arr[r] > base) r--;
            while (l <= r && arr[l] < base) l++;

            if (l < r) swap(arr, l, r);
            else break;
        }

        swap(arr, r, left);
        QuickSort(arr, left, r - 1);
        QuickSort(arr, r + 1, right);
        return arr;
    }

    public static int[] MergeSort(int[] arr) {
        return MergeSort(arr, 0, arr.length - 1);
    }

    private static int[] MergeSort(int[] arr, int left, int right) {
        if (left >= right) return arr;
        int mid = (left + right) >> 1;

        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        Merge(arr, left, mid, right);
        return arr;
    }

    private static int[] Merge(int[] arr, int left, int mid, int right) {

        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        for (int p = 0; p <  tmp.length; p++)
            arr[left + p] = tmp[p];

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = genRandomArray(10);
        show(arr);
        QuickSort(new int[]{1, 2});
        show(arr);

        System.out.println("SelectionSort is sorted : " + isSorted(SelectionSort(genRandomArray(100))));
        System.out.println("InsertionSort is sorted : " + isSorted(InsertionSort(genRandomArray(100))));
        System.out.println("BubbleSort is sorted : " + isSorted(BubbleSort(genRandomArray(100))));
        System.out.println("QuickSort is sorted : " + isSorted(QuickSort(genRandomArray(100))));
        System.out.println("MergeSort is sorted : " + isSorted(MergeSort(genRandomArray(100))));
    }
}
