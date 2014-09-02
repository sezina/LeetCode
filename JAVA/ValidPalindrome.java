public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.trim().toLowerCase();
        if (s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}