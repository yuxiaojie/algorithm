package leetcode;

/*
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法

* */

import utils.ArraysUtils;

import java.util.Arrays;

public class Q189 {

    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            result[(i + k + nums.length) % nums.length] = nums[i];

        for (int i = 0; i < nums.length; i++)
            nums[i] = result[i];
    }

    public void rotate2(int[] nums, int k) {

        int tmp = 0, prev = nums[0], start = k % nums.length, target = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmp = nums[target];
            nums[target] = prev;
            prev = tmp;

            target = (target + k) % nums.length;
            if (target == start) {
                start = ++start % nums.length;
                target = start;
                prev = nums[(start - k + nums.length * 10) % nums.length];
            }
        }
    }

    public void rotate3(int[] nums, int k) {

        int tmp =  0, prev = 0;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];;
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }

    public static void main(String[] args) {

        Q189 q = new Q189();
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
//        q.rotate2(a1, 3);
        ArraysUtils.showIntArray(a1);

        int[] a2 = {-1, -100, 3, 99};
//        q.rotate2(a2, 2);
        ArraysUtils.showIntArray(a2);


        int[] a3 = {1, 2};
        q.rotate2(a3, 3);
        ArraysUtils.showIntArray(a3);
    }
}
