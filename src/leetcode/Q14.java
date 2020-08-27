package leetcode;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z
* */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs[0].length() == 0)
            return "";

        int len = 0;
        while (true) {
            char c = strs[0].charAt(len);
            for (String str : strs) {
                if (len >= str.length() || str.charAt(len) != c)
                    return len == 0 ? "" : str.substring(0, len);
            }
            len++;
        }
    }
}
