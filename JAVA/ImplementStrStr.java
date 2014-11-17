public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            int j = 1;
            for (; j < needle.length() && haystack.charAt(i+j) == needle.charAt(j); j++);
            if (j == needle.length()) return i;
        }
        return -1;
    }
}