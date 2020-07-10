package leetcode;

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
* */
public class Q59 {

    public int[][] generateMatrix(int n) {

        int[][] m = new int[n][n];
        int l = 0, r = n - 1, b = n - 1, t = 0;
        int count = 1, total = n * n;
        while (count < total) {
            for (int i = l; i <= r; i++) m[t][i] = count++;
            t++;
            for (int i = t; i <= b; i++) m[i][r] = count++;
            r--;
            for (int i = r; i >= l; i--) m[b][i] = count++;
            b--;
            for (int i = b; i >= t; i--) m[i][l] = count++;
            l++;
        }
        return m;
    }
}
