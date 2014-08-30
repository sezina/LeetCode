public class Solution {
    public boolean search(int[] A, int target) {
        return binarySearch(A, target, 0, A.length - 1);
    }
    
    public boolean binarySearch(int[] A, int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] == target) return true;
            if (A[low] == A[mid]) {
                return binarySearch(A, target, mid + 1, high) || binarySearch(A, target, low, mid - 1);
            }
            if (A[low] < A[mid]) {
                if (target < A[mid] && target >= A[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target > A[mid] && target <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}