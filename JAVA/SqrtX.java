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

// binary search
public class Solution2 {
    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int low = 0, high = x, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (low == mid) break;
            if (x / mid >= mid)
                low = mid;
            else 
                high = mid;
        }
        return low;
    }
}