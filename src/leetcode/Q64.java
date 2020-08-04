package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小
* */
public class Q64 {

    public int minPathSum(int[][] grid) {

        // 常规动态规划
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (x == 0 && y == 0) continue;
                else if (y == 0) grid[0][x] = grid[0][x - 1] + grid[0][x];
                else if (x == 0) grid[y][0] = grid[y - 1][0] + grid[y][0];
                else grid[y][x] = Math.min(grid[y - 1][x], grid[y][x - 1]) + grid[y][x];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q64().minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
