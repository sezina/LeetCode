public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++)
            res += Math.max(prices[i] - prices[i - 1], 0);
        return res;
    }
}