// O(log(|result|) + 1)
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) 
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);
            
        int minDivisor = Integer.MIN_VALUE >> 1;
        int mult = divisor;
        int shifts = 0;
        while ((mult >= minDivisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }
        
        int result = 0;
        int power = 1 << shifts;
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power;
        }
        return result;
    }
}