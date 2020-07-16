package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
* */
public class Q47 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, new boolean[nums.length], new ArrayList<>(), 0);
        return result;
    }

    private void backtrace(int[] nums, boolean[] cache, List<Integer> tmp, int curr) {

        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (cache[i])
                continue;

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !cache[i - 1])
                continue;

            tmp.add(nums[i]);
            cache[i] = true;
            backtrace(nums, cache, tmp, curr + 1);
            cache[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {

        Q47 q = new Q47();
        System.out.println(q.permuteUnique(new int[]{1, 1, 2}));
    }
}
