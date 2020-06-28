package leetcode;

/*

1358. 包含所有三种字符的子字符串数目

给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。

示例 1：
输入：s = "abcabc"
输出：10
解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。

示例 2：
输入：s = "aaacb"
输出：3
解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。

示例 3：
输入：s = "abc"
输出：1
* */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q1358 {

    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] charCount = {0, 0, 0};
        int start = 0;

        for (int end=0; end < s.length(); end++) {
            char charAtEnd = s.charAt(end);
            charCount[charAtEnd-'a'] += 1;

            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += s.length() - end;
                char charAtStart = s.charAt(start);
                charCount[charAtStart-'a'] -= 1;
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Q1358 q = new Q1358();
        System.out.println("abcabc => " + q.numberOfSubstrings("abcabc"));
        System.out.println("aaacb => " + q.numberOfSubstrings("aaacb"));
        System.out.println("abc => " + q.numberOfSubstrings("abc"));
        System.out.println("acbbcac => " + q.numberOfSubstrings("acbbcac"));
    }
}
