package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
    1   0   1       11   00   11
    1   1   1       12   21   32
    1   1   1       13   22   33

    1   1   1       11   21   31
    1   0   1       12   00   12
    1   1   1       13   21   33
* */
public class Q1139 {

    private static final int LEFT = 0;
    private static final int UP = 1;

    public int largest1BorderedSquare(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length, max = 0;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                dp[x][y][LEFT] = grid[x-1][y-1] == 1 ? grid[x-1][y-1] + dp[x-1][y][LEFT] : 0;
                dp[x][y][UP] = grid[x-1][y-1] == 1 ? grid[x-1][y-1] + dp[x][y-1][UP] : 0;
            }
        }

        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                for (int side = Math.min(dp[x][y][LEFT], dp[x][y][UP]); side >= 1 && side > max; side--) {
                    if (dp[x - side + 1][y][UP] >= side && dp[x][y - side + 1][LEFT] >= side) {
                        max = Math.max(max, side);
                        break;
                    }
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(new Q1139().largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
    }
}
