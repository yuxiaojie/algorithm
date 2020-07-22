package leetcode;


/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

* */
public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int maxLen = matrix.length * matrix[0].length;
        int left = 0, right = maxLen - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;

            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new Q74().searchMatrix(m, 3));
        System.out.println(new Q74().searchMatrix(m, 13));
    }
}
