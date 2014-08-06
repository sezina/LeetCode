public class Solution {
    public int searchInsert(int[] A, int target) {
        int size = A.length;
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < A[mid]) {
                high = mid - 1;
            } else if (target > A[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        
        return low;
    }
}