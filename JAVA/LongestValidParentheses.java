public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int maxLen = 0, n = s.length();
        int[] curLen = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                curLen[i] = curLen[i+1] = 2;
                maxLen = Math.max(maxLen, 2);
                int low = i - 1, high = i + 2;
                while (low >= 0 && high < n && s.charAt(low) == '(' && s.charAt(high) == ')') {
                    curLen[high] = curLen[low] = curLen[low + 1] + 2;
                    maxLen = Math.max(curLen[high], maxLen);
                    low--;
                    high++;
                }
                
                while (low > 0 && curLen[low] != 0) {
                    curLen[high - 1] += curLen[low];
                    curLen[low - curLen[low] + 1] += curLen[low + 1];
                    low = low - curLen[low];
                    maxLen = Math.max(maxLen, curLen[high - 1]);
                    
                    while (low >= 0 && high < n && s.charAt(low) == '(' && s.charAt(high) == ')') {
                        curLen[high] = curLen[low] = curLen[low + 1] + 2;
                        maxLen = Math.max(maxLen, curLen[high]);
                        low--;
                        high++;
                    }
                }
                
            }
        }
        return maxLen;
    }
}