package leetcode;

/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
* */
public class Q125 {
    public boolean isPalindrome(String s) {

        if (s == null)
            return false;
        if (s.equals("") || s.length() == 1)
            return true;

        int l = 0, r = s.length() - 1;
        while (l < r) {

            while (l < r && !isValid(s.charAt(l))) l++;
            while (l < r && !isValid(s.charAt(r))) r--;

            if (l < r && upper(s.charAt(l++)) != upper(s.charAt(r--))) return false;
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
        System.out.println(new Q125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
