package leetcode;

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围

*/
public class Q200 {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length <= 0)
            return 0;

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num += 1;
                    maskIslands(grid, i,  j);
                }
            }
        }
        return num;
    }

    private void maskIslands(char[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0')
            return;

        grid[x][y] = '0';
        maskIslands(grid, x - 1, y);
        maskIslands(grid, x + 1, y);
        maskIslands(grid, x, y - 1);
        maskIslands(grid, x, y + 1);
    }
}
