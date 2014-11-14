public class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i - 1] += (digits[i] / 10);
            digits[i] %= 10;
        }
        if (digits[0] < 10) return digits;
        digits[0] %= 10;
        int[] res = new int[digits.length + 1];
        System.arraycopy(digits, 0, res, 1, digits.length);
        res[0] = 1;
        return res;
    }
}