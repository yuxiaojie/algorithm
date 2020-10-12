package leetcode;

/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
* */
public class Q48 {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 ||  matrix[0].length == 0) return;

        int n = matrix.length, m = matrix[0].length;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < x; y++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }

        for (int x = 0; x < n; x++) {
            int start = 0, end = m - 1;
            while (start < end) {
                int tmp = matrix[x][start];
                matrix[x][start++] = matrix[x][end];
                matrix[x][end--] = tmp;
            }
        }
    }
}
