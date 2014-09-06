public class Solution {
    public String countAndSay(int n) {
        if (n == 0) return "";
        String base = "1";
        StringBuffer sb = new StringBuffer();
        while (n-- > 1) {
            int bn = base.length();
            char c = base.charAt(0);
            int count = 1;
            sb.setLength(0);
            for (int i = 1; i < bn; i++) {
                if (base.charAt(i) != c) {
                    sb.append(count).append(c);
                    c = base.charAt(i);
                    count = 1;
                } else count++;
            }
            sb.append(count).append(c);
            base = sb.toString();
        }
        return base;
    }
}