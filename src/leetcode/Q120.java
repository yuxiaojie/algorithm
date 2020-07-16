package leetcode;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q120 {

    public int minimumTotal1(List<List<Integer>> triangle) {
        // 暴力搜索
        return dfs(triangle, 0, 0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        // 缓存之前的计算结果
        return dfsCache(triangle, new Integer[triangle.size()][triangle.size()],0, 0);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        // 动态规划
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size())
            return 0;
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    private int dfsCache(List<List<Integer>> triangle, Integer[][] cache, int i, int j) {

        if (i == triangle.size())
            return 0;

        if (cache[i][j] != null)
            return cache[i][j];

        cache[i][j] = Math.min(dfsCache(triangle, cache, i + 1, j), dfsCache(triangle, cache, i + 1, j + 1)) + triangle.get(i).get(j);
        return cache[i][j];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Q120 q = new Q120();
        System.out.println(q.minimumTotal3(triangle));

    }


}
