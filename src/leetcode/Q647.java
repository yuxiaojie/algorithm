package leetcode;

/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
* */
public class Q647 {

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int size = s.length(), count = 0;
        for (int x = 0; x < size; x++)
            for (int y = x; y < size; y++)
                count += (check(s, x, y) ? 1 : 0);
        return count;
    }

    private boolean check(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Q647 q = new Q647();
        System.out.println(q.countSubstrings("abc"));
        System.out.println(q.countSubstrings("aaa"));
    }
}
