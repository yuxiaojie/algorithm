package leetcode;

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.lang.reflect.Array;
import java.util.*;

public class Q15 {

    public List<List<Integer>> threeSum1(int[] nums) {

        // 暴力三重循环

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        // 引入 hash 减少一重循环

        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i : nums) {
            if (cache.containsKey(i))
                cache.put(i, cache.get(i) + 1);
            else
                cache.put(i, 1);
        }

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                int a = nums[i], b = nums[j], tmp = 0;
                int c =  -(a + b);
                Integer find = cache.get(c);
                int same = (c == a ? 1 : 0) + (c == b ? 1 : 0) + 1;
                if (find != null && find >= same) {

                    if (a > b) {tmp=a; a=b; b=tmp;}
                    if (b > c) {tmp=b; b=c; c=tmp;}
                    if (a > b) {tmp=a; a=b; b=tmp;}
                    result.add(Arrays.asList(a, b, c));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum3(int[] nums) {

        // 排序后双指针
        int head = 0, tail = 0;
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            head = i + 1;
            tail = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1])
                continue;

            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                }

                if (sum <= 0) while (head < tail) {head++; if (nums[head] != nums[i]) break;}
                if (sum > 0) while ( head < tail) {tail--; if (nums[tail] != nums[i]) break;}
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Q15 q = new Q15();
        System.out.println(q.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(q.threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(q.threeSum3(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println(q.threeSum1(new int[]{0, 0, 0, 0}));
        System.out.println(q.threeSum2(new int[]{0, 0, 0, 0}));
        System.out.println(q.threeSum3(new int[]{0, 0, 0, 0}));

        System.out.println(q.threeSum1(new int[]{-1, 0, 1, 0}));
        System.out.println(q.threeSum2(new int[]{-1, 0, 1, 0}));
        System.out.println(q.threeSum3(new int[]{-1, 0, 1, 0}));
    }
}
