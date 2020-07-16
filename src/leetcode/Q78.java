package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
* */
public class Q78 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        for (int k = 0; k <= nums.length; k++) {
            backtrack(0, new ArrayList<Integer>(), nums, k);
        }
        return result;
    }

    private void backtrack(int first, ArrayList<Integer> curr, int[] nums, int max) {

        if (curr.size() == max)
            result.add(new ArrayList(curr));

        for (int i = first; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, max);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q78 q = new Q78();
        System.out.println(q.subsets(new int[]{1, 2, 3}));
    }
}
