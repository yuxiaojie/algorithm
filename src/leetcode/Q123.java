package leetcode;

public class Q123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - profit1); // 用第一次买的钱，来抵消部分第二次买的钱
            profit2 = Math.max(profit2, prices[i] - buy2);
        }
        return profit2;
    }

    public static void main(String[] args) {
        System.out.println(new Q123().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
