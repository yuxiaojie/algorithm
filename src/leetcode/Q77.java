package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
public class Q77 {

    public void backtracking(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) { // 终结条件
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtracking(combs, comb, i + 1, n, k - 1);
            // 清理子递归对 list 的修改
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        backtracking(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }
}
