package leetcode;

import utils.ArraysUtils;

import java.util.*;

/*
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

*/
public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Integer> cache = new HashSet<>();
        char[] cs = s.toCharArray();
        int maxLen = 0, start = 0, subLen = 0;

        for (int i = 0; i < cs.length; ) {

            if (cache.contains(cs[i] - 'a')) {
                i = ++start;
                cache.clear();
                subLen = 0;
            } else {
                cache.add(cs[i] - 'a');
                i++;
                subLen += 1;
            }
            maxLen = Math.max(maxLen, subLen);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;

        for (int i=0, j=0; i<s.length(); ++i) {

            if (map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {

        if (s.length()==0) return 0;

        Set<Character> cache = new HashSet<>();
        char[] cs = s.toCharArray();
        int maxLen = 0, l = 0, r = -1;

        for (; l  < cs.length; l++) {

            if (l != 0)
                cache.remove(cs[l - 1]);

            while (r + 1 < cs.length && !cache.contains(cs[r + 1]))
                cache.add(cs[r++ + 1]);

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        Q3 q = new Q3();
        System.out.println(q.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(q.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(q.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(q.lengthOfLongestSubstring2(" "));
    }
}
