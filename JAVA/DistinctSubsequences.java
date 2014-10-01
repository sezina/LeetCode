// knapsack, O(m) space, O(n*m)time
public class Solution {
    public int numDistinct(String S, String T) {
        if (T.isEmpty() || S.length() < T.length()) return 0;
        if (S.equals(T)) return 1;
        int[] dp = new int[T.length() + 1];
        dp[0] = 1;
        
        for (int j = 0; j < S.length(); j++) {
            for (int i = T.length(); i >= 1; i--) {
                dp[i] = dp[i] + (T.charAt(i - 1) == S.charAt(j) ? dp[i - 1] : 0);
            }
        }
        return dp[T.length()];
    }
}