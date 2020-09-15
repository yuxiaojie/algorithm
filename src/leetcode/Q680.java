package leetcode;

import java.util.ArrayList;

/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000
*/
public class Q680 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, true);
    }

    // abcca
    public boolean validPalindrome(String s, boolean first) {

        if (s == null)
            return false;
        if (s.equals("") || s.length() == 1)
            return true;

        int l = 0, r = s.length() - 1;
        while (l < r) {

            while (l < r && !isValid(s.charAt(l))) l++;
            while (l < r && !isValid(s.charAt(r))) r--;

            if (l < r && upper(s.charAt(l)) != upper(s.charAt(r))) {
                if (first)
                    return validPalindrome(s.substring(l, r), false) || validPalindrome(s.substring(l + 1, r + 1), false);
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c >= '0' && c <= '9';
    }

    private char upper(char c) {
        if (c >= 'a' && c <= 'z')
            return (char) (c - ('a' - 'A'));
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Q680().validPalindrome("abcca"));
//
//        String s = "abcca";
//        int l = 1, r = 3;
//        System.out.println(s.substring(l + 1, r + 1));
//        System.out.println(s.substring(l, r));
    }
}
