package leetcode;


/*

加一

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/

import utils.ArraysUtils;

public class Q66 {

    public int[] plusOne(int[] digits) {

        int len = digits.length;
        for (int i=len-1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i] += 1;
                break;
            }
        }

        if (digits[0] == 0) {
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }
        return digits;
    }

    public static void main(String[] args) {

        Q66 s = new Q66();

        int[] a = {1, 2, 3};
        ArraysUtils.showIntArray(s.plusOne(a));

        int[] b = {9, 9, 9, 9};
        ArraysUtils.showIntArray(s.plusOne(b));

        int[] c = {0};
        ArraysUtils.showIntArray(s.plusOne(c));

    }
}
