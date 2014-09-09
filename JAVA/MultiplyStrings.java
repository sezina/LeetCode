public class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int ri, i, j, num;
        for (i = num1.length() - 1; i >= 0; i--) {
            num = num1.charAt(i) - '0';
            ri = num1.length() - i - 1;
            for (j = num2.length() - 1; j >= 0; j--) {
                res[ri] += num * (num2.charAt(j) - '0');
                res[ri + 1] += res[ri] / 10;
                res[ri] %= 10;
                ri++;
            }
        }
        i = res.length - 1;
        for (; i >= 0 && res[i] == 0; i--);
        if (i < 0) return "0";
        
        StringBuffer sb = new StringBuffer();
        for (; i >= 0; i--)
            sb.append(res[i]);
        return sb.toString();
    }
}