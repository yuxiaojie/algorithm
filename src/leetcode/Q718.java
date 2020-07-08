package leetcode;

public class Q718 {

    public int findLength1(int[] A, int[] B) {

        int maxSubLen, maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    maxSubLen = 1;
                    while (i + maxSubLen < A.length && j + maxSubLen < B.length && A[i + maxSubLen] == B[j + maxSubLen]) {
                        maxSubLen++;
                    }
                    maxLen = Math.max(maxSubLen, maxLen);
                }
            }
        }
        return maxLen;
    }

    public int findLength(int[] A, int[] B) {

        int n = A.length, m = B.length, maxLen = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ?  dp[i + 1][j + 1] + 1: 0;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q718 q = new Q718();
        System.out.println(q.findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}));
    }
}
