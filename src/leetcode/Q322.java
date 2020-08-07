package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1


f(n) = min(f(n-c1), f(n-c2), f(n-c3))
f(1) = min(f(0), f(-1), f(-4))
* */
public class Q322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;

        // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{amount, 0});
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int[] curr = queue.poll();
                for (int i = coins.length - 1; i >= 0; i--) {
                    if (curr[0] == 0)
                        return curr[1];
                    else if (curr[0] >= coins[i])
                        queue.add(new int[]{curr[0] - coins[i], curr[1] + 1});
                }
            }
        }
        return -1;
    }

    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;

        // dp
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Q322().coinChange2(new int[]{2}, 3));
    }
}
