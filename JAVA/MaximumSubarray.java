/**
 * O(n)
 */
public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int a : A) {
            sum += a;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}


/**
 * divide and conque
 */
public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0) return 0;
        return maxHelper(A, 0, A.length - 1);
    }
    
    private int maxHelper(int[] num, int low, int high) {
        if (low == high) return num[low];
        int mid = low + (high - low) / 2;
        int leftans = maxHelper(num, low, mid);
        int rightans = maxHelper(num, mid + 1, high);
        int temp = 0, leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            temp += num[i];
            leftmax = Math.max(temp, leftmax);
        }
        temp = 0;
        for (int i = mid + 1; i <= high; i++) {
            temp += num[i];
            rightmax = Math.max(temp, rightmax);
        } 
        return Math.max(Math.max(leftans, rightans), leftmax+rightmax);
    }
}