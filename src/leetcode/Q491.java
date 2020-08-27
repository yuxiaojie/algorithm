package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况

3   2   1   2   3
* */
public class Q491 {

    private List<List<Integer>> result = new ArrayList<>();
    private Set<Integer> repeat = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        if (nums == null || nums.length == 0)
            return result;

        dfs(nums, 0, new ArrayList<>(nums.length));
        return result;
    }

    public int getHash(int base, int mod, List<Integer> paths) {
        int hashValue = 0;
        for (int x : paths) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    private void dfs(int[] nums, int start, List<Integer> paths) {

        if (start >= nums.length)
            return;

        for (int i = start; i < nums.length; i++) {

            if (!paths.isEmpty() && paths.get(paths.size() - 1) > nums[i])
                continue;

            paths.add(nums[i]);
            int hashValue = getHash(263, (int) 1E9 + 7, paths);

            if (!repeat.contains(hashValue) && paths.size() > 1) {
                repeat.add(hashValue);
                result.add(new ArrayList<>(paths));
            }

            dfs(nums, i + 1, paths);
            paths.remove(paths.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q491().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1}));
//        System.out.println(new Q491().findSubsequences(new int[]{3, 2, 1, 2, 3}));

    }
}
