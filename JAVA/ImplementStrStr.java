public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
            needle.length() > haystack.length())
            return null;
        if (needle.isEmpty()) return haystack;
        boolean isFind = true;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0))
                continue;
            isFind = true;
            for (int j = 1; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) return haystack.substring(i);
        }
        return null;
    }
}