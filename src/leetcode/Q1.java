package leetcode;

/*

1. 两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

* */

import utils.ArraysUtils;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            m.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            Integer partner = m.get(target - nums[i]);
            if (partner == null || partner == i)
                continue;
            return new int[]{i, partner};
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer partner = m.get(target - nums[i]);
            if (partner == null || partner == i) {
                m.put(nums[i], i);
            } else {
                return new int[]{i, partner};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        ArraysUtils.showIntArray(q.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
