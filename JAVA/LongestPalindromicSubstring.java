public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int begin = 0, end = 1, low, high;
        for (int i = 1; i < s.length(); i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > end - begin) {
                    end = high + 1;
                    begin = low;
                }
                low--;
                high++;
            }
            
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > end - begin) {
                    end = high + 1;
                    begin = low;
                }
                low--;
                high++;
            }
        }
        return s.substring(begin, end);
    }
}

// manacher algorithm
