package leetcode;

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
* */
public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        obstacleGrid[m - 1][n - 1] = 1;
        for (int x = m - 2; x >= 0 ; x--)
            obstacleGrid[x][n - 1] = obstacleGrid[x][n - 1] == 1 ? 0 : obstacleGrid[x + 1][n - 1];
        for (int y = n - 2; y >= 0; y--)
            obstacleGrid[m - 1][y] = obstacleGrid[m - 1][y] == 1 ? 0 : obstacleGrid[m - 1][y + 1];

        for (int x = m - 2; x >= 0; x--) {
            for (int y = n - 2; y >= 0; y--) {
                if (obstacleGrid[x][y] == 1)
                    obstacleGrid[x][y] = 0;
                else
                    obstacleGrid[x][y] = obstacleGrid[x + 1][y] + obstacleGrid[x][y + 1];
            }
        }
        return obstacleGrid[0][0];
    }

    public static void main(String[] args) {
        int[][] paths = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Q63().uniquePathsWithObstacles(paths));
    }
}
