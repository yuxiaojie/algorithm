package leetcode;

/*
88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
* */

import utils.ArraysUtils;

public class Q88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int insert = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0)
            if (nums1[p1] > nums2[p2])
                nums1[insert--] = nums1[p1--];
            else
                nums1[insert--] = nums2[p2--];

        while (p2 >= 0)
            nums1[insert--] = nums2[p2--];
    }

    public static void main(String[] args) {
        Q88 q = new Q88();
        int[] a1 = {1, 2, 3, 0, 0, 0}, a2 = {2, 5, 6};
        q.merge(a1, 3,  a2, 3);
        ArraysUtils.showIntArray(a1);

        int[] a3 = {0}, a4 = {1};
        q.merge(a3, 0,  a4, 1);
        ArraysUtils.showIntArray(a3);
    }
}
