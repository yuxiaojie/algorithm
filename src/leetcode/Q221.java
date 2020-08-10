package leetcode;

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
* */
public class Q221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {

                if (y == 0) dp[x][0] = matrix[x][0] - '0';
                else if (x == 0) dp[0][y] = matrix[0][y] - '0';
                else {
                    if (matrix[x][y] == '0')
                        dp[x][y] = 0;
                    else
                        dp[x][y] = matrix[x][y] - '0' + Math.min(dp[x - 1][y], Math.min(dp[x][y - 1], dp[x - 1][y - 1]));
                }
                max = Math.max(max, dp[x][y]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '0', '1', '1', '1'}};
//        char[][] a = new char[][]{{'0', '1'}};
        System.out.println(new Q221().maximalSquare(a));
    }
}
