public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x, result = 0;
        while (temp != 0) {
            if (result > (Integer.MAX_VALUE - temp % 10) / 10)
                return false;
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        return result == x;
    }
}