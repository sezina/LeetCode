// recursive solution
public class Solution {
    public double pow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (Math.abs(x) > 1.0) return 0.0;
            else return x * pow(x, Integer.MAX_VALUE); // abs(Integer.MIN_VALUE) - 1 = Integer.MAX_VALUE
        }
        if (n == 0 || Math.abs(x - 1) < 10e-9) return 1.0;
        if (n == 1) return x;
        if (n < 0) return 1 / pow(x, -n);
        if (n % 2 == 1)
            return x * pow(x * x, n / 2);
        else
            return pow(x * x, n / 2);
    }
}