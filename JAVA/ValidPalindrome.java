public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.trim().toLowerCase();
        if (s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j &&
                    !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                            (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) i++;
            while (i < j &&
                    !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') ||
                            (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) j--;
            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}