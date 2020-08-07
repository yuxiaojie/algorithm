package leetcode;

/*
1143. 最长公共子序列

给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。
* */
public class Q1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int lcs(String text1, String text2, int i, int j) {
        if (i == -1 || j == -1)
            return 0;
        if (text1.charAt(i) == text2.charAt(j))
            return lcs(text1, text2, i - 1, j - 1) + 1;
        else
            return Math.max(lcs(text1, text2, i - 1, j), lcs(text1, text2, i, j - 1));
    }

    private int dp(String text1, String text2) {

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Q1143().dp("abcde", "ace"));
    }
}

