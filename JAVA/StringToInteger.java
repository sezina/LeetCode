public class Solution {
    public int atoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int result = 0, i = 0;
        boolean negtive = false;
        if (str.charAt(0) == '-') {
            negtive = true;
            i = 1;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }
        int maxSubTen = Integer.MAX_VALUE / 10;
        for (; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            if (maxSubTen < result || Integer.MAX_VALUE - (result * 10) < (str.charAt(i) - '0')) {
                if (negtive) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            result = result * 10 + (str.charAt(i) - '0');
        }
        if (negtive)
            result = -result;
        return result;
    }
}