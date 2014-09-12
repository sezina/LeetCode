// backward max match
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String minStr = strs[0];
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }
        }
        boolean isFind = false;
        String prefix = minStr;
        int n = prefix.length();
        for (int i = 0; i <= n && !isFind; i++) {
            prefix = prefix.substring(0, n - i);
            isFind = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].indexOf(prefix) != 0) {
                    isFind = false;
                    break;
                }
            }
        }
        return prefix;
    }
}