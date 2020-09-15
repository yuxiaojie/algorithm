package leetcode;

/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
* */
public class Q5 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 1 || s.length() == 0)
            return s;

        int maxLen = 1, l = 0, r = 0, max = 0, maxLeft = 0, maxRight = 0;
        for (int i = 1; i < s.length(); i++) {
            l = i;
            r = i;
            maxLen = 1;

            while (l > 0 && s.charAt(i) == s.charAt(l - 1)) {
                l--;
                maxLen++;
            }

            while (r < s.length() - 1 && s.charAt(i) == s.charAt(r + 1)) {
                r++;
                maxLen++;
            }

            while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                r++;
                l--;
                maxLen += 2;
            }

            if (maxLen > max) {
                max = maxLen;
                maxLeft = l;
                maxRight = r;
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public static void main(String[] args) {

        System.out.println(new Q5().longestPalindrome("abadd"));
    }
}
