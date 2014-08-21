public class Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int temp = x / 2;
        while (x / temp < temp)
            temp /= 2;
        int i = temp;
        for (; x / i >= i; i++);
        return --i;
    }
}