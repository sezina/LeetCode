public class Solution {
    public int searchInsert(int[] A, int target) {
        int pos = -1;
        int size = A.length;
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < A[mid]) {
                high = mid;
            } else if (target > A[mid]) {
                low = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        if (pos < 0) {
            if (target <= A[low])
                pos = low;
            else if (target > A[low])
                pos = low + 1;
        }
        return pos;
    }
}