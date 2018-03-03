/**
 * Problem 172
 *
 * @author sezina
 * @since 3/3/18
 */
public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 4) {
            result += (n / 5);
            n /= 5;
        }
        return result;
    }
}
