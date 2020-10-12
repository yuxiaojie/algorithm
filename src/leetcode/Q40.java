package leetcode;

import java.util.*;

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
* */
public class Q40 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,  target, 0, new ArrayDeque<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int begin, Deque<Integer> tmp) {

        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            if (target - candidates[i] < 0 || (i != begin && candidates[i] == candidates[i - 1])) continue;

            tmp.addLast(candidates[i]);
            dfs(candidates,  target - candidates[i], i + 1, tmp);
            tmp.removeLast();
        }
    }
}
