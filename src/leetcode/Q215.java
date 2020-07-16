package leetcode;

import java.util.*;

public class Q215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        return q == index ? a[q] : (q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index));
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x)
                swap(a, ++i, j);
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void main(String[] args) {
        Q215 q = new Q215();
        System.out.println(q.findKthLargest(new int[]{2, 1, 5, 6, 4}, 2));
        System.out.println(q.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));



    }
}
