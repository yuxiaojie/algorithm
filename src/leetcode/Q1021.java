package leetcode;

/*
1021. 删除最外层的括号
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。

提示：

S.length <= 10000
S[i] 为 "(" 或 ")"
S 是一个有效括号字符串
* */

import java.util.LinkedList;
import java.util.List;

public class Q1021 {

    public String removeOuterParentheses(String S) {
        int lv = 0;
        StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {

            if (c == '(') lv++;
            if (lv > 1) result.append(c);
            if (c == ')') lv--;
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Q1021 q = new Q1021();
        String s1 = q.removeOuterParentheses("(()())(())");
        assert s1.equals("()()()");
        String s2 = q.removeOuterParentheses("(()())(())(()(()))");
        assert s2.equals("()()()()(())");
        String s3 = q.removeOuterParentheses("()()");
        assert s3.equals("");
        System.out.println("success");
    }
}
