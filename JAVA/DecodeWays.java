public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] result = new int[s.length()];
        result[0] = 1;
        if (s.length() > 1) {
            int temp = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            if (temp > 26 && temp % 10 == 0) return 0;
            if (temp == 10 || temp == 20 || temp > 26) result[1] = 1;
            else result[1] = 2;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                else {
                    if (s.charAt(i -2) == '0') result[i] = result[i - 1];
                    else if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') < 26)
                        result[i] = result[i - 1] - 1;
                    else result[i] = result[i - 1];
                } 
            } else {
                if (s.charAt(i - 1) == '0') result[i] = result[i - 1];
                else if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') > 26)
                    result[i] = result[i - 1];
                else result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result[s.length() - 1];
    }
}