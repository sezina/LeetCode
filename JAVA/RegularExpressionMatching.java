public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s.isEmpty() && p.isEmpty()) return true;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = false;
        for (int j = 1; j <= p.length(); j++)
            if (p.charAt(j - 1) == '*' && j > 1)
                dp[0][j] = dp[0][j - 2];
            else dp[0][j] = false;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == s.charAt(i - 1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*' && j > 1) {
                    // dp[i-1][j]: abb,ab*: depends on ab,ab*
                    // dp[i][j-2]: a,ab*: depends on a,a
                    // dp[i][j-1]: ab,ab*: depends on ab,ab
                    if (p.charAt(j-2) == s.charAt(i - 1) || p.charAt(j-2) == '.')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i][j-1];
                    else dp[i][j] = dp[i][j-2];
                } else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}