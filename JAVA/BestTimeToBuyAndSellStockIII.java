// worst cast is O(n^2)
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, sum = 0, total = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += (prices[i] - prices[i - 1]);
            if (max < sum) {
                max = sum;
                int temp = helper(i, prices);
                total = Math.max(total, max + temp);
            }
            if (sum < 0) sum = 0;
        }
        return total;
    }
    
    private int helper(int buyday, int[] prices) {
        int max = 0, sum = 0;
        for (int i = buyday + 1; i < prices.length; i++) {
            sum += (prices[i] - prices[i - 1]);
            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}