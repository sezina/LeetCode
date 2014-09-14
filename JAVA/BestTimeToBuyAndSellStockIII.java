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

// O(n)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0, sum = 0, maxPrice = prices[prices.length - 1];
        int[] preProfit = new int[prices.length];
        int[] backProfit = new int[prices.length];
        
        // forward
        for (int i = 1; i < prices.length; i++) {
            sum += (prices[i] - prices[i - 1]);
            preProfit[i] = Math.max(sum, preProfit[i - 1]);
            if (sum < 0) sum = 0;
        }
        
        // backward
        max = preProfit[prices.length - 1] + backProfit[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            backProfit[i] = Math.max(backProfit[i + 1], maxPrice - prices[i]);
            max = Math.max(max, backProfit[i] + preProfit[i]);
        }
        return max;
    }
}