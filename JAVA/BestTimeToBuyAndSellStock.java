// transform the problem to max sum of subarray
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int days = prices.length, sum = 0, max = 0;
        for (int i = days - 1; i > 0; i--)
            prices[i] = prices[i] - prices[i - 1];
        prices[0] = 0;
        
        for (int i = 0; i < days; i++) {
            sum += prices[i];
            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}

// more shorter
public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length, sum = 0, max = 0;
        for (int i = 1; i < days; i++) {
            sum += (prices[i] - prices[i - 1]);
            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}