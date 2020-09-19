package leetcode;

/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
* */
public class Q34 {

    private int findMin = Integer.MAX_VALUE, findMax = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {

        if (nums == null) return new int[]{-1, -1};

        recurSearch(nums, target, 0, nums.length - 1);
        return findMax < 0 ? new int[]{-1, -1} : new int[]{findMin, findMax};
    }

    private void recurSearch(int[] nums, int target, int l, int r) {

        if (l > r) return;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {

            findMax = Math.max(findMax, mid);
            findMin = Math.min(findMin, mid);

            recurSearch(nums, target, l, mid - 1);
            recurSearch(nums, target, mid + 1, r);
        } else if (nums[mid] > target)
            recurSearch(nums, target, l, mid - 1);
        else
            recurSearch(nums, target, mid + 1, r);
    }
}
