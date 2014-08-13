public class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        int n = digits.length;
        digits[n - 1] += 1;
        for (int i = n - 1; i >= 0; i--) {
            if (carry)
                digits[i] += 1;
            if (digits[i] > 9) {
                carry = true;
                digits[i] -= 10;
            } else
                carry = false;
        }
        int[] result;
        if (carry) {
            result = new int[n + 1];
            result[0] = 1;
            for (int i = 0; i < n; i++)
                result[i + 1] = digits[i];
            return result;
        } else {
            result = digits;
        }
        return result;
    }
}