package leetcode;

/*
541. 反转字符串 II
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"


提示：

该字符串只包含小写英文字母。
给定字符串的长度和 k 在 [1, 10000] 范围内
* */
public class Q541 {
    public String reverseStr(String s, int k) {

        int n = s.length();
        if (s == null)
            return "";

        char[] cs = s.toCharArray();
        int offset, l, r;
        char tmp;
        for (int i = 0; i * k * 2 < n; i++) {
            offset = i * k * 2;
            l = offset;
            r = offset + k >= n ? n - 1 : offset + k - 1;
            while (l < r) {
                tmp = cs[l];
                cs[l++] = cs[r];
                cs[r--] = tmp;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new Q541().reverseStr("abcdefg",2));
        System.out.println();
    }
}
