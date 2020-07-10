package leetcode;

/*
31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
* */

import utils.ArraysUtils;

public class Q31 {

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1)
            return;

        int small = nums.length - 2, big = nums.length - 1, last = nums.length - 1, tmp = 0;

        // 寻找第一个升序的相邻数字
        while (small >= 0 && nums[small] >= nums[big]) {
            small--;
            big--;
        }

        // 数组 small 后的数据必然是升序，从后往前找第一个比small大的数，并交换
        if (small >= 0) {
            while (nums[small] >= nums[last])
                last--;

            tmp = nums[small];
            nums[small] = nums[last];
            nums[last] = tmp;
        }

        // 数组后面的顺序必然是降序，所以直接反转就变成了升序
        for (int i = big, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {

        Q31 q = new Q31();
        int[] a1 = {1, 2, 3};
        q.nextPermutation(a1);
        ArraysUtils.showIntArray(a1);

        int[] a2 = {3, 2, 1};
        q.nextPermutation(a2);
        ArraysUtils.showIntArray(a2);

        int[] a3 = {1, 1, 5};
        q.nextPermutation(a3);
        ArraysUtils.showIntArray(a3);
    }
}
