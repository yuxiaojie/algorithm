package leetcode;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

4 =
1 1 1 1
1 1 2
1 2 1
2 1 1
2 2
*/

class Solution {

    public int climbStairs(int n) {

        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;

        int a = 1, b = 2;
        for (int i=3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public int climbStairsStack(int n, String prefix) {

        if (n == 1) {
            System.out.println(prefix + "1");
            return 1;
        } else if (n == 2) {
            System.out.println(prefix + "1, 1");
            System.out.println(prefix + "2");
            return 2;
        }

        return climbStairsStack(n - 1, prefix + "1, ") + climbStairsStack(n - 2, prefix + "2, ");
    }
}

public class Q70 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println("input = " + 8 + ", output = " + s.climbStairsStack(10, ""));
        System.out.println("input = " + 8 + ", output = " + s.climbStairs(10));

    }
}
