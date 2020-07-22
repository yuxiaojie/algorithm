package leetcode;

import utils.ArraysUtils;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

* */
public class Q42 {

    public int trap(int[] height) {

        int sum = 0;
        for (int i : height)
            sum += i;

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {

            if (height[left] > maxLeft)
                maxLeft = height[left];
            else
                height[left] = maxLeft;

            if (height[right] > maxRight)
                maxRight = height[right];
            else
                height[right] = maxRight;

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        int newSum = 0;
        for (int i : height)
            newSum += i;

        return newSum - sum;
    }

    public static void main(String[] args) {

        Q42 q = new Q42();
        System.out.println(q.trap(new int[]{0, 2, 0, 0, 0, 1,}));
    }
}
