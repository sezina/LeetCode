public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return x;
        int sign = (x < 0) ? -1 : 1;
        int positive = Math.abs(x);
        int result = 0;
        while (positive != 0) {
            if (result > (Integer.MAX_VALUE - positive % 10) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + positive % 10;
            positive /= 10;
        }
        return result * sign;
    }
}

// the test rule has changed
public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        int sign = (x < 0) ? -1 : 1;
        int positive = Math.abs(x);
        int result = 0;
        while (positive != 0) {
            if (result > (Integer.MAX_VALUE - positive % 10) / 10)
                return 0;
            result = 10 * result + positive % 10;
            positive /= 10;
        }
        return result * sign;
    }
}