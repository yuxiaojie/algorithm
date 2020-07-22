package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */
public class Q46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums, new ArrayList<>());
        return result;
    }

    private void backtrace(int[] nums, List<Integer> tmp) {

        if (nums.length == tmp.size()) {
            result.add(new ArrayList(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (tmp.contains(nums[i]))
                continue;

            tmp.add(nums[i]);
            backtrace(nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q46 q = new Q46();
        System.out.println(q.permute(new int[]{1, 2, 3}));
    }
}
