package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
* */
public class Q39 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recur(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recur(int[] candidates, int target, int start, List<Integer> tmp) {

        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (target - candidates[i] < 0) continue;

            tmp.add(candidates[i]);
            recur(candidates, target - candidates[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
