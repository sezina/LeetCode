// reference: http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s.isEmpty() && p.isEmpty()) return true;
        
        int si = 0, pi = 0, match = 0, starIdx = -1;
        while (si < s.length()) {
            if (pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
                si++;
                pi++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                starIdx = pi;
                match = si;
                pi++;
            } else if (starIdx != -1) {
                pi = starIdx + 1;
                match++;
                si = match;
            } else return false;
        }
        while (pi < p.length() && p.charAt(pi) == '*') pi++;
        return pi == p.length();
    }
}